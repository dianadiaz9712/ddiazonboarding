package com.prototype.product.repository.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prototype.product.model.ProductModel;
import com.prototype.product.service.entities.ProductEntities;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


	ProductEntities modelToEntity(ProductModel productModel);
	
	ProductModel entityToModel(ProductEntities productEntities);
	
	List<ProductEntities> productsEntitiesToModels(final List<ProductModel> productsModels);
}