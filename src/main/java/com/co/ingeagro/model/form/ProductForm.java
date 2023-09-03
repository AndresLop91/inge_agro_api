package com.co.ingeagro.model.form;

import com.co.ingeagro.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {

    private Product product;
    private Long sellerId;
    private Boolean updateProduct;
}
