package com.prototype.sales.thirdyparty.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {

	private UUID idProduct;
	
	private String nameProduct;
	
	private String description;
	
	private float quantityAvailable;
	
	private String state;
	
	private float unitValue;
	
	private float taxValue;
	
	private float baseValue;
}
