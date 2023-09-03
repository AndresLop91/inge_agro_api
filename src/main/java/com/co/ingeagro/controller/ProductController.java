package com.co.ingeagro.controller;

import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.form.ProductForm;
import com.co.ingeagro.model.form.RemoveProductForm;
import com.co.ingeagro.service.product.IProductService;
import com.co.ingeagro.service.seller.ISellerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping( path = ControllerConstants.Product.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class ProductController {
    private IProductService productService;
    private ISellerService sellerService;

    @Autowired
    public ProductController(
            IProductService productService,
            ISellerService sellerService) {
        this.productService = productService;
        this.sellerService = sellerService;
    }

    @RequestMapping(value= ControllerConstants.SAVE ,method = RequestMethod.POST)
    public void save(@RequestBody ProductForm product) throws IngeagroException {
        this.productService.saveProduct(product);
    }

    @RequestMapping(value= ControllerConstants.REMOVE ,method = RequestMethod.POST)
    public void remove(@RequestBody RemoveProductForm product) throws IngeagroException {
        this.productService.removeProduct(product);
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    public List<Product> getAll(){
        return productService.getAll();
    }

    @RequestMapping(value= ControllerConstants.Product.PAGEABLE ,method = RequestMethod.POST)
    public Page<Product> getAll(Pageable page){
        return productService.getAll(page);
    }

    @RequestMapping(value= ControllerConstants.Product.GET_BY_SELLER_ID ,method = RequestMethod.GET)
    public List<Product> getAllBySellerId(@Param("sellerId") Long sellerId){
        return sellerService.getAllBySellerId(sellerId);
    }

    @RequestMapping(value= ControllerConstants.FIND_BY_ID ,method = RequestMethod.GET)
    public Product findByID(@Param("productId") Long productId) throws IngeagroException {
        return productService.findById(productId);
    }

}
