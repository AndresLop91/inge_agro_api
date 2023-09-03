package com.co.ingeagro.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartForm {

    private Long cartId;
    private Integer qty;
    private Long productId;
    private Long buyerId;

}
