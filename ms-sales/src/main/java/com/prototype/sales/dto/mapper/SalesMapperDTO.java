package com.prototype.sales.dto.mapper;

import com.prototype.sales.dto.SalesRequestDTO;
import com.prototype.sales.service.entities.SalesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SalesMapperDTO {

    SalesMapperDTO INSTANCE = Mappers.getMapper(SalesMapperDTO.class);

    SalesEntity salesDtoToSalesEntity(SalesRequestDTO salesRequestDTO);

}
