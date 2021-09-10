package com.prototype.product.dto.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.prototype.product.dto.ProductRequestUpdateDTO;
import com.prototype.product.dto.ProductResponseDTO;
import com.prototype.product.dto.ProductResquestDTO;
import com.prototype.product.service.entities.ProductEntities;

@Mapper(componentModel = "spring")
public interface ProductMapperDTO {

	ProductMapperDTO INSTANCE = Mappers.getMapper(ProductMapperDTO.class);

	ProductEntities productDtoToProductEntity(ProductResquestDTO productResquestDTO);
	
	@Mapping(source = "idProduct", target = "idProduct", qualifiedByName = "stringToUuid")
	ProductEntities productUpdateDtoToProductEntity(ProductRequestUpdateDTO productResquestDTO);

	@Named("stringToUuid")
	default UUID stringToUuid(String string) {
		return UUID.fromString(string);
	}

	ProductResponseDTO productEntityToProductDto(final ProductEntities product);

	List<ProductResponseDTO> productsEntitiesToDtos(final List<ProductEntities> productsEntities);
}
