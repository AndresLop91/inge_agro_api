package com.co.ingeagro.service.cart.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.cart.CartConverter;
import com.co.ingeagro.data.CartData;
import com.co.ingeagro.data.SellProductData;
import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Cart;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.SellProduct;
import com.co.ingeagro.model.form.AddToCartForm;
import com.co.ingeagro.model.form.BuyCartForm;
import com.co.ingeagro.model.form.RemoveItemFromCartForm;
import com.co.ingeagro.repository.cart.ICartRepository;
import com.co.ingeagro.service.buyer.IBuyerService;
import com.co.ingeagro.service.cart.ICartService;
import com.co.ingeagro.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {

    public static final String OCURRIÓ_UN_PROBLEMA_AL_FINALIZAR_LA_COMPRA = "Ocurrió un problema al finalizar la compra";
    private ICartRepository repository;
    private IProductService productService;
    private IBuyerService buyerService;
    private Converter<CartData, Cart> converter;


    @Autowired
    public CartService(ICartRepository repository,
                       IProductService productService,
                       IBuyerService buyerService,
                       CartConverter converter) {
        this.repository = repository;
        this.productService = productService;
        this.buyerService = buyerService;
        this.converter = converter;
    }

    @Override
    public Cart getACartById(Long cartId) {
        if(Objects.isNull(cartId) || cartId <= 0){
            Cart cart = Cart.builder().build();
            CartData newCart = repository.getANewCart(converter.convert2Data(cart));
            return converter.convert2Model(newCart);
        }
        else{
            CartData cartData = repository.getACartById(cartId);
            List<SellProductData> products = cartData.getProducts().stream()
                    .filter(p -> {
                        return p.getProduct() != null & (p.getProduct().getActive() == null
                                || p.getProduct().getActive());
                    }).collect(Collectors.toList());
            cartData.setProducts(products);
            return converter.convert2Model(cartData);
        }
    }

    @Override
    public Cart addProduct(AddToCartForm addToCartForm) throws IngeagroException {
        Product product = productService.findById(addToCartForm.getProductId());
        if(Objects.nonNull(product.getActive()) && !product.getActive()){
            throw new IngeagroException("Este producto ha sido removido, no se puede agregar al carrito");
        }
        Cart cart = this.getACartById(addToCartForm.getCartId());
        SellProduct sellProduct = SellProduct.builder()
                .quantity(addToCartForm.getQty())
                .product(product).build();

        if(Objects.nonNull(cart)){
            if(Objects.nonNull(cart.getProducts()) && cart.getProducts().size() > 0){
                if (cart.getProducts().stream().anyMatch(p -> Objects.equals(p.getProduct().getId(), product.getId()))){
                    updateProductOnCart(addToCartForm, product, cart);
                }
                else{
                    addNewProductToCart(cart, sellProduct);
                }
                return converter.convert2Model(repository.save(converter.convert2Data(cart)));
            }
            else{
                initializeCartProducts(cart, sellProduct);
            }
            if(Objects.isNull(cart.getUser())){
                cart.setUser(buyerService.getByUserId(addToCartForm.getBuyerId()));
            }
            return converter.convert2Model(repository.save(converter.convert2Data(cart)));
        }
        throw new IngeagroException("No se pudo agregar producto al carrito");
    }

    private void initializeCartProducts(Cart cart, SellProduct sellProduct) {
        cart.setProducts(List.of(sellProduct));
    }

    private void addNewProductToCart(Cart cart, SellProduct sellProduct) {
        cart.getProducts().add(sellProduct);
    }

    private void updateProductOnCart(AddToCartForm addToCartForm, Product product, Cart cart) {
        Integer remainingQuantity = product.getStock().getRemainingQuantity();
        Integer qtyAlreadyInCart = 0;

        for (int i= 0; i < cart.getProducts().size() ; i++ ) {
            SellProduct sellProduct = cart.getProducts().get(i);
            if(sellProduct.getProduct().getId().equals(product.getId())){
                qtyAlreadyInCart = sellProduct.getQuantity();
                if((addToCartForm.getQty() + qtyAlreadyInCart) > remainingQuantity){
                    cart.getProducts().get(i).setQuantity(remainingQuantity);
                }
                else{
                    cart.getProducts().get(i).setQuantity(qtyAlreadyInCart + addToCartForm.getQty());
                }
            }
        }
    }

    @Override
    public Cart getANewCart(Long buyerId) {
        Buyer buyer = Buyer.builder().id(buyerId).build();
        Cart cart = Cart.builder().user(buyer).build();
        CartData newCart = repository.getANewCart(converter.convert2Data(cart));
        return converter.convert2Model(newCart);
    }

    @Override
    public Cart removeItemFromCart(RemoveItemFromCartForm item) throws IngeagroException {
        if(Objects.isNull(item) || Objects.isNull(item.getCartId()) || Objects.isNull(item.getSellProductId())){
            throw new IngeagroException("No se pudo eliminar el producto del carrito");
        }
        if(item.getCartId() <= 0){
            throw new IngeagroException("No se pudo eliminar el producto del carrito");
        }
        CartData cart = repository.getACartById(item.getCartId());
        if(Objects.isNull(cart) || Objects.isNull(cart.getProducts()) || cart.getProducts().size() <= 0){
            throw new IngeagroException("No hay prouctos por eliminar en este carrito");
        }
        boolean isThereAnItem = cart.getProducts().stream().anyMatch(p -> item.getSellProductId().equals(p.getId()));
        if(!isThereAnItem){
            throw new IngeagroException("No hay un item que eliminar del carrito");
        }
        for (int i = 0; i < cart.getProducts().size() ; ++i){
            if(item.getSellProductId().equals(cart.getProducts().get(i).getId())){
                cart.getProducts().remove(i);
            }
        }
        return converter.convert2Model(repository.save(cart));
    }

    @Override
    public Cart buyCart(BuyCartForm form) throws IngeagroException {
        if(Objects.isNull(form) || Objects.isNull(form.getCartId())){
            throw new IngeagroException(OCURRIÓ_UN_PROBLEMA_AL_FINALIZAR_LA_COMPRA);
        }
        CartData cart = repository.getACartById(form.getCartId());
        if(Objects.isNull(cart) && Objects.nonNull(cart.getProducts())){
            throw new IngeagroException(OCURRIÓ_UN_PROBLEMA_AL_FINALIZAR_LA_COMPRA);
        }
        //*************** INI - VALIDATE STOCK ******************
        validateQuantityStock(cart);
        //*************** FINISH - VALIDATE STOCK ******************
        for (int i=0; i<cart.getProducts().size(); i++){
            SellProductData sp = cart.getProducts().get(i);
            // Subtract the remaining qty with the qty bought
            cart.getProducts()
                    .get(i).getProduct().getStock()
                    .setRemainingQuantity(sp.getProduct().getStock().getRemainingQuantity() - sp.getQuantity());
            //Sum the sold qty with the qty bought
            cart.getProducts().get(i).getProduct()
                    .getStock().setSoldQuantity(sp.getProduct().getStock().getSoldQuantity() + sp.getQuantity());

        }
        cart.setBought(Boolean.TRUE);
        return converter.convert2Model(repository.save(cart));
    }

    private void validateQuantityStock(CartData cart) throws IngeagroException {
        List<SellProductData> products = cart.getProducts();
        for(SellProductData sp : products){
            // if the qty of the item cart is greater than the remaining product stock, then the buy is not succeeded
            if(sp.getQuantity() > sp.getProduct().getStock().getRemainingQuantity()){
                if(sp.getProduct().getStock().getRemainingQuantity() > 0){
                    throw new IngeagroException(String.format("El producto %s no tiene stock: solo se pueden %d",
                            sp.getProduct().getProductType().getName(), sp.getProduct().getStock().getRemainingQuantity()));
                }
                else{
                    throw new IngeagroException(String.format("El producto %s no tiene stock", sp.getProduct().getProductType().getName()));
                }
            }
        }
    }
}
