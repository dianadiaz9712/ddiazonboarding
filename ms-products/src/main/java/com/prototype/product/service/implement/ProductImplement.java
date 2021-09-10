package com.prototype.product.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.product.constant.ProductConstant;
import com.prototype.product.constant.ProductMessages;
import com.prototype.product.dto.MessageResponse;
import com.prototype.product.exeption.ProductNotFoundException;
import com.prototype.product.exeption.ProductConflicException;
import com.prototype.product.model.ProductModel;
import com.prototype.product.repository.ProductRepository;
import com.prototype.product.repository.mappers.ProductMapper;
import com.prototype.product.service.ProductService;
import com.prototype.product.service.entities.ProductEntities;

/**
 * @author dianadiazmartinez
 *
 */

@Service
public class ProductImplement implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private LockImplements lockImplements;

	/**
	 *
	 * Method for consulting available productss
	 *
	 */
	@Override
	public List<ProductEntities> getProducts() {
		List<ProductEntities> listProductEntities = null;
		List<ProductModel> listProductModel = productRepository.findByState(ProductConstant.ACTIVO);
		if (listProductModel.isEmpty()) {
			throw new ProductNotFoundException(ProductMessages.DESCP0001);
		} else {
			listProductEntities = productMapper.productsEntitiesToModels(listProductModel);
		}
		return listProductEntities;
	}

	/*
	 * Method for consulting by product id
	 */

	@Override
	public ProductEntities getProduct(UUID idProduct) {
		ProductEntities productEntities = null;
		Optional<ProductModel> optProduct = productRepository.findById(idProduct);
		if (optProduct.isPresent()) {
			productEntities = productMapper.modelToEntity(optProduct.get());
		} else {
			throw new ProductNotFoundException(ProductMessages.DESCP0002);
		}
		return productEntities;
	}

	/**
	 *
	 * Method for creating products
	 *
	 */
	@Override
	public MessageResponse createProduct(ProductEntities productEntities) {
		MessageResponse mes = new MessageResponse();

		ProductModel productModel = productMapper.entityToModel(productEntities);

		Optional<ProductModel> optProductModel = productRepository
				.findByNameProductAndState(productModel.getNameProduct(), ProductConstant.ACTIVO);

		if (optProductModel.isPresent()) {
			throw new ProductConflicException(ProductMessages.DESCP0008);
		} else {
			productModel.setState(ProductConstant.ACTIVO);
			productRepository.save(productModel);
			mes.setMensaje(ProductMessages.DESCP0003);
		}

		return mes;

	}

	/**
	 *
	 * Method for update products
	 *
	 */
	@Override
	public MessageResponse updateProduct(ProductEntities productEntities) {
		MessageResponse mes = new MessageResponse();

		try {
			ProductModel productModel = productMapper.entityToModel(productEntities);
			Optional<ProductModel> optProductModel = productRepository.findById(productModel.getIdProduct());

			if (optProductModel.isPresent()) {
				//lockImplements.lock(productEntities.getIdProduct().toString());
				productRepository.save(productModel);
				mes.setMensaje(ProductMessages.DESCP0004);
			} else {
				throw new ProductNotFoundException(ProductMessages.DESCP0005);
			}

			return mes;
		} finally {
			lockImplements.unlock(productEntities.getIdProduct().toString());
		}

	}

	/**
	 *
	 * Method for update products
	 *
	 */
	@Override
	public MessageResponse deleteProduct(UUID idProduct) {
		MessageResponse mes = new MessageResponse();
		Optional<ProductModel> optProductModel = productRepository.findById(idProduct);

		if (optProductModel.isPresent()) {
			ProductModel productModel = optProductModel.get();
			productModel.setState(ProductConstant.INACTIVO);
			productRepository.save(productModel);
			mes.setMensaje(ProductMessages.DESCP0006);
		} else {
			throw new ProductNotFoundException(ProductMessages.DESCP0007);
		}
		return mes;
	}
}
