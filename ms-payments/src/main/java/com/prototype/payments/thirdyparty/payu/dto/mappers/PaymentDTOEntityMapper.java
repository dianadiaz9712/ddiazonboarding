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
			@Mapping(source = "transactionEntity.orderEntity.additionalValuesEntity.txValueEntity", target = "transaction.order.additionalValues.txValue"),
			@Mapping(source = "transactionEntity.orderEntity.additionalValuesEntity.txTaxEntity", target = "transaction.order.additionalValues.txTax"),
			@Mapping(source = "transactionEntity.orderEntity.additionalValuesEntity.txTaxReturnBaseEntity", target = "transaction.order.additionalValues.txTaxReturnBase"),
			@Mapping(source = "transactionEntity.orderEntity.buyerEntity.shippingAddressEntity", target = "transaction.order.buyer.shippingAddress"),
			@Mapping(source = "transactionEntity.orderEntity.buyerEntity", target = "transaction.order.buyer"),
			@Mapping(source = "transactionEntity.orderEntity.additionalValuesEntity", target = "transaction.order.additionalValues"),
			@Mapping(source = "transactionEntity.creditCardEntity", target = "transaction.creditCard"),
			@Mapping(source = "transactionEntity.payerEntity", target = "transaction.payer"),
			@Mapping(source = "transactionEntity.payerEntity.billingAddressEntity", target = "transaction.payer.billingAddress"),
			@Mapping(source = "merchantEntity", target = "merchant")
	})
    Payment paymentToPaymentEntity(PaymentEntity paymentEntity);

	@Mappings({
			@Mapping(source = "transactionResponse", target = "transactionResponseEntity")
})
	ResponseEntity paymentEntityToPayment(PaymentResponse paymentResponse);


	@Mappings({
			@Mapping(source = "transactionRefundEntity", target = "transactionRefund"),
			@Mapping(source = "transactionRefundEntity.orderRefundEntity",   target = "transactionRefund.orderRefund"),
			@Mapping(source = "merchantEntity", target = "merchant")
	})
	Refund refundToRefundEntity(RefundEntity refundEntity);

}
