package com.bilgeadam.utility;

import com.bilgeadam.repository.IRepository;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.repository.entity.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@RequiredArgsConstructor
public class DataIMPL {

    private final IRepository repository;
    @PostConstruct
    public void initData(){

        createUser();
    }
    public void createUser(){

        Personal personal=Personal.builder()
                .name("Hilal")
                .address("Ankara")
                .email("hilaler1@hotmail.com")
                .nationalId(2352462462L)
                .photo("foto")
                .userType(UserType.ADMIN)
                .build();

        Personal personal2=Personal.builder()
                .name("Ihsan")
                .address("Ankara")
                .email("i@hotmail.com")
                .nationalId(2352462462L)
                .photo("foto")
                .userType(UserType.ADMIN)
                .password("1234")
                .build();

        repository.save(personal2);
        repository.save(personal);
    }
}
