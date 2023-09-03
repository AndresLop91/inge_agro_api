package com.co.ingeagro.service.product.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.form.ProductForm;
import com.co.ingeagro.model.form.RemoveProductForm;
import com.co.ingeagro.repository.product.IProductRepository;
import com.co.ingeagro.service.product.IProductService;
import com.co.ingeagro.service.seller.ISellerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private Converter<ProductData, Product> converter;
    private IProductRepository repository;
    private ISellerService sellerService;

    @Autowired
    public ProductService(Converter<ProductData, Product> converter,
                          IProductRepository repository,
                          ISellerService sellerService) {
        this.converter = converter;
        this.repository = repository;
        this.sellerService = sellerService;
    }

    @Override
    public void saveProduct(ProductForm product) throws IngeagroException {
        ProductData productData = converter.convert2Data(product.getProduct());
        List<ProductData> productsSaved = this.repository.saveAll(Collections.singletonList(productData));
        List<Product> savedProducts = converter.convertAll2Model(productsSaved);
        if(Objects.isNull(product.getUpdateProduct()) || !product.getUpdateProduct()){
            this.sellerService.updateProducts(product.getSellerId(), savedProducts);
        }
    }

    @Override
    public List<Product> getAll() {
        List<ProductData> products = repository.getAll();
        products = products.stream()
                .filter(isThereStock())
                .filter(isActive())
                .collect(Collectors.toList());
        return converter.convertAll2Model(products);
    }

    @NotNull
    private Predicate<ProductData> isActive() {
        return p -> p.getActive() == null || p.getActive();
    }

    @NotNull
    private Predicate<ProductData> isThereStock() {
        return p -> p.getStock().getRemainingQuantity() > 0;
    }

    @Override
    public Page<Product> getAll(Pageable page) {
        Page<ProductData> all = repository.getAll(page);
        List<ProductData> content = all.getContent();
        List<Product> contentModel = converter.convertAll2Model(content);
        Page<Product> pageModel = new PageImpl<>(contentModel, page, all.getTotalElements());
        return pageModel;
    }

    @Override
    public List<Product> getAllBySellerId(Long sellerId) {
        List<ProductData> productsData = repository.getBySellerId(sellerId);
        return converter.convertAll2Model(productsData);
    }

    @Override
    public Product findById(Long productId) throws IngeagroException {
        ProductData product = repository.getById(productId);
        if(Objects.isNull(product)){
            throw new IngeagroException(String.format("El producto con el id %s no existe", productId));
        }
        return converter.convert2Model(product);
    }

    @Override
    public void removeProduct(RemoveProductForm product) throws IngeagroException {
        ProductData productData = repository.getById(product.getProductId());
        productData.setActive(Boolean.FALSE);
        repository.saveAll(Collections.singletonList(productData));
    }
}
