package com.co.ingeagro.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoveItemFromCartForm {

    private Long cartId;
    private Long sellProductId;

}
