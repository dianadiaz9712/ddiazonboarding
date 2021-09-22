package com.prototype.payments.repository.mappers;

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
            @Mapping(target = "idCustomer", source = "orderEntity.buyerEntity.idCustomer", qualifiedByName = "stringToUuid"),
            @Mapping(target = "city", source = "orderEntity.buyerEntity.shippingAddressEntity.city"),
            @Mapping(target = "country", source = "orderEntity.buyerEntity.shippingAddressEntity.country"),
            @Mapping(target = "platform", source = "platform"),
    })
    CardModel cardEntityToEntityModelToken(TransactionEntity transactionEntity);

    @Named("stringToUuid")
	default UUID stringToUuid(String string) {
		return UUID.fromString(string);
	}

}
