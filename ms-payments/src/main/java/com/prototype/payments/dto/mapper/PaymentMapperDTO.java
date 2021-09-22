package com.prototype.payments.dto.mapper;

import com.prototype.payments.dto.RefundDTO;
import com.prototype.payments.dto.ResponseDTO;
import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.prototype.payments.dto.PaymentRequestDTO;
import com.prototype.payments.service.entities.PaymentEntity;


@Mapper(componentModel = "spring")
public interface PaymentMapperDTO {

    PaymentMapperDTO INSTANCE = Mappers.getMapper(PaymentMapperDTO.class);

    @Mappings({
		@Mapping(target = "transactionEntity.orderEntity.additionalValuesEntity.txValueEntity", source = "transactionDTO.orderDTO.additionalValuesDTO.txValueDTO"),
     	@Mapping(target = "transactionEntity.orderEntity.additionalValuesEntity.txTaxEntity", source = "transactionDTO.orderDTO.additionalValuesDTO.txTaxDTO"),
		@Mapping(target = "transactionEntity.orderEntity.additionalValuesEntity.txTaxReturnBaseEntity", source = "transactionDTO.orderDTO.additionalValuesDTO.txTaxReturnBaseDTO"),
		@Mapping(target = "transactionEntity.orderEntity.buyerEntity.shippingAddressEntity", source = "transactionDTO.orderDTO.buyerDTO.shippingAddressDTO"),
		@Mapping(target = "transactionEntity.orderEntity.buyerEntity", source = "transactionDTO.orderDTO.buyerDTO"),
		@Mapping(target = "transactionEntity.orderEntity.additionalValuesEntity", source = "transactionDTO.orderDTO.additionalValuesDTO"),
		@Mapping(target = "transactionEntity.creditCardEntity", source = "transactionDTO.creditCardDTO"),
		@Mapping(target = "transactionEntity.creditCardTokenEntity", source = "transactionDTO.creditCardTokenDTO"),
		@Mapping(target = "transactionEntity.payerEntity", source = "transactionDTO.payerDTO"),
		@Mapping(target = "transactionEntity.payerEntity.billingAddressEntity", source = "transactionDTO.payerDTO.billingAddressDTO"),
        //Constant
		@Mapping(target = "language", constant = "es"),
		@Mapping(target = "command" , constant = "SUBMIT_TRANSACTION"),
		@Mapping(target = "merchantEntity.apiKey", constant = "012345678901"),
		@Mapping(target = "merchantEntity.apiLogin", constant = "012345678901"),
		@Mapping(target = "transactionEntity.orderEntity.accountId" , constant = "1"),
    	@Mapping(target = "transactionEntity.payerEntity.merchantPayerId" , constant =  "1"),
		@Mapping(target = "transactionEntity.orderEntity.buyerEntity.merchantBuyerId" , constant = "1")

			})
    PaymentEntity paymentDtoToPaymentEntity(PaymentRequestDTO paymentRequestDTO);


	@Mappings({
			@Mapping(target = "transactionResponseDTO", source = "transactionResponseEntity")
				})
    ResponseDTO responseEntityToResponseDTO(ResponseEntity responseEntity);


	@Mappings({
			@Mapping(target = "transactionRefundEntity.type", source = "transactionRefundDTO.type"),
			@Mapping(target = "transactionRefundEntity.parentTransactionId", source = "transactionRefundDTO.parentTransactionId"),
			@Mapping(target = "transactionRefundEntity.reason", source = "transactionRefundDTO.reason"),
			@Mapping(target = "transactionRefundEntity.orderRefundEntity", source = "transactionRefundDTO.orderRefundDTO"),
			@Mapping(target = "language", constant = "es"),
			@Mapping(target = "command" , constant = "SUBMIT_TRANSACTION")
	})
	RefundEntity refundDTOtoRefundEntity(RefundDTO refundDTO);
}
