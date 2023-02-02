package com.bilgeadam.mapper;

import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.repository.entity.Personal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T11:19:58+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IPersonalMapperImpl implements IPersonalMapper {

    @Override
    public Personal fromRegisterRequestDto(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personal.PersonalBuilder personal = Personal.builder();

        personal.password( dto.getPassword() );
        personal.email( dto.getEmail() );

        return personal.build();
    }
}
