package com.prototype.payments.repository.mappers;

import com.prototype.payments.model.BankModel;
import com.prototype.payments.model.CardModel;
import com.prototype.payments.service.entities.TransactionEntity;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentRepositoryMapper {

    PaymentRepositoryMapper INSTANCE = Mappers.getMapper(PaymentRepositoryMapper.class);

    @Mappings({
            @Mapping(target = "idCustomer", source = "transactionEntity.orderEntity.buyerEntity.idCustomer", qualifiedByName = "stringToUuid"),
            @Mapping(target = "city", source = "transactionEntity.orderEntity.buyerEntity.shippingAddressEntity.city"),
            @Mapping(target = "country", source = "transactionEntity.orderEntity.buyerEntity.shippingAddressEntity.country"),
            @Mapping(target = "platform", source = "transactionEntity.platform"),
            @Mapping(target = "bank" , source = "bankModel"),
            @Mapping(target = "tokenCard" , source = "tokenCard")
    })
    CardModel cardEntityToEntityModelToken(TransactionEntity transactionEntity, BankModel bankModel, String tokenCard);

    @Named("stringToUuid")
	default UUID stringToUuid(String string) {
		return UUID.fromString(string);
	}



}
