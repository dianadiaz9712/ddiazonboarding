package com.prototype.product.service;

import java.util.List;
import java.util.UUID;

import com.prototype.product.dto.MessageResponse;
import com.prototype.product.service.entities.ProductEntities;

public interface ProductService {
	
	public List<ProductEntities> getProducts();
	
	public ProductEntities getProduct(UUID idProduct);
	
	public MessageResponse createProduct(ProductEntities productEntities);
	
	public MessageResponse updateProduct(ProductEntities productEntitiest);
	
	public MessageResponse deleteProduct(UUID idProduct);
}
