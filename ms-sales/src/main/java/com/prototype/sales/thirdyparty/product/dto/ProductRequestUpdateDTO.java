package com.prototype.sales.thirdyparty.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestUpdateDTO{

	
	private String idProduct;

	private String nameProduct;

	private String description;

	private int quantityAvailable;

	private String state;

	private float unitValue;

	private float taxValue;

	private float baseValue;
}
