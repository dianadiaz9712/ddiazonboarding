package com.prototype.payments.thirdyparty.payu.dto.mappers;

import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.thirdyparty.payu.dto.Payment;
import com.prototype.payments.thirdyparty.payu.dto.PaymentResponse;
import com.prototype.payments.thirdyparty.payu.dto.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentDTOEntityMapper {

	PaymentDTOEntityMapper INSTANCE = Mappers.getMapper(PaymentDTOEntityMapper.class);

	@Mappings({
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.additionalValuesEntity.txValueEntity", target = "transaction.order.additionalValues.txValue"),
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.additionalValuesEntity.txTaxEntity", target = "transaction.order.additionalValues.txTax"),
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.additionalValuesEntity.txTaxReturnBaseEntity", target = "transaction.order.additionalValues.txTaxReturnBase"),
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.buyerEntity.shippingAddressEntity", target = "transaction.order.buyer.shippingAddress"),
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.buyerEntity", target = "transaction.order.buyer"),
			@Mapping(source = "paymentEntity.transactionEntity.orderEntity.additionalValuesEntity", target = "transaction.order.additionalValues"),
			@Mapping(source = "paymentEntity.transactionEntity.creditCardEntity", target = "transaction.creditCard"),
			@Mapping(source = "paymentEntity.transactionEntity.payerEntity", target = "transaction.payer"),
			@Mapping(source = "paymentEntity.transactionEntity.payerEntity.billingAddressEntity", target = "transaction.payer.billingAddress"),
			@Mapping(source = "paymentEntity.merchantEntity", target = "merchant"),
			@Mapping(source = "tokenCard", target = "transaction.creditCardTokenId")
	})
    Payment paymentToPaymentEntity(PaymentEntity paymentEntity, String tokenCard);

	@Mappings({
			@Mapping(source = "transactionResponse", target = "transactionResponseEntity")
})
	ResponseEntity paymentResponseEntityToResponse(PaymentResponse paymentResponse);


	@Mappings({
			@Mapping(source = "transactionRefundEntity", target = "transactionRefund"),
			@Mapping(source = "transactionRefundEntity.orderRefundEntity",   target = "transactionRefund.orderRefund"),
			@Mapping(source = "merchantEntity", target = "merchant")
	})
	Refund refundToRefundEntity(RefundEntity refundEntity);

}
