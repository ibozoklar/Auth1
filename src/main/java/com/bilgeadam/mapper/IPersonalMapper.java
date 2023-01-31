package com.bilgeadam.mapper;

import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.repository.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonalMapper {

    IPersonalMapper INSTANCE = Mappers.getMapper(IPersonalMapper.class);

    Personal fromRegisterRequestDto(final RegisterRequestDto dto);

}
