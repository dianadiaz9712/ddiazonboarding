package com.prototype.product.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.product.dto.MessageResponse;
import com.prototype.product.dto.ProductRequestUpdateDTO;
import com.prototype.product.dto.ProductResponseDTO;
import com.prototype.product.dto.ProductResquestDTO;
import com.prototype.product.dto.mappers.ProductMapperDTO;
import com.prototype.product.service.ProductService;
import com.prototype.product.service.entities.ProductEntities;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductMapperDTO productMapperDTO;




	@GetMapping("/")
	@ApiOperation(value = "Operación para consultar los datos de un producto", httpMethod = "GET", response = ProductResponseDTO.class, responseContainer = "List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exito en la consulta."),
			@ApiResponse(code = 400, message = "Se produjo una excepción en la consulta de productos"),
			@ApiResponse(code = 404, message = "No existe productos disponibles"),
			@ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
	public List<ProductResponseDTO> getProducts() {
		return productMapperDTO.productsEntitiesToDtos(productService.getProducts());
	}

	@GetMapping("/idProduct/{idProduct}")
	@ApiOperation(value = "Operación para consultar por idProducto", httpMethod = "GET", response = ProductResponseDTO.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Consulta exitosa por id del producto"),
			@ApiResponse(code = 400, message = "Se produjo una excepción en la consulta del producto"),
			@ApiResponse(code = 404, message = "No existe el producto"),
			@ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
	public ProductResponseDTO getProduct(
			@ApiParam(value = "Identificador del producto", name = "idProduct", type = "UUID", required = true, example = "8c8a0f04-5c88-463e-ad22-2f4f7e839056") @Valid @NotBlank(message = "El campo idProduct no puede ser vacio") @PathVariable @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "El parámetro idProduct debe contener un formato válido") String idProduct) {
		return productMapperDTO.productEntityToProductDto(productService.getProduct(UUID.fromString(idProduct)));
	}

	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Operación para crear un producto", httpMethod = "POST", response = MessageResponse.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Se registro con exito el producto."),
			@ApiResponse(code = 400, message = "Se produjo una excepción en la creacion de productos"),
			@ApiResponse(code = 404, message = "No existe productos disponibles"),
			@ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse createProduct(@Valid @RequestBody ProductResquestDTO productResquest) {
		final ProductEntities productEntities = productMapperDTO.productDtoToProductEntity(productResquest);
		return productService.createProduct(productEntities);

	}

	@PutMapping("/")
	@ApiOperation(value = "Operación para actualizar un producto", httpMethod = "PUT", response = MessageResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Se actualizo con exito el producto."),
			@ApiResponse(code = 400, message = "Se produjo una excepción en la actualizacion de productos"),
			@ApiResponse(code = 404, message = "No existe productos disponibles"),
			@ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
	public MessageResponse updateProduct(@Valid @RequestBody ProductRequestUpdateDTO productResquestUpdate) {
		final ProductEntities productEntities = productMapperDTO.productUpdateDtoToProductEntity(productResquestUpdate);
		return productService.updateProduct(productEntities);

	}

	@DeleteMapping("/idProduct/{idProduct}")
	@ApiOperation(value = "Operación para eliminar el producto por idProducto", httpMethod = "DELETE", response = MessageResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Se elimino el registro con exito"),
			@ApiResponse(code = 400, message = "Se produjo una excepción con la eliminacion del producto"),
			@ApiResponse(code = 404, message = "No existe el producto"),
			@ApiResponse(code = 500, message = "Se produjo una excepción del lado del servidor") })
	public MessageResponse deleteProduct(
			@ApiParam(value = "Identificador del producto", name = "idProduct", type = "UUID", required = true, 
			example = "8c8a0f04-5c88-463e-ad22-2f4f7e839056")
			@Valid 
			@PathVariable 
			@Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
			message = "El parámetro idProduct debe contener un formato válido") String idProduct) {
		return productService.deleteProduct(UUID.fromString(idProduct));

	}
}
