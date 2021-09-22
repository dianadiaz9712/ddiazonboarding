package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class ExtraParametersDTO {

    public int installments_number;
}
