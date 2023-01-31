package com.bilgeadam.service;

import com.bilgeadam.dto.LoginRequestDto;
import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.mapper.IPersonalMapper;
import com.bilgeadam.repository.IRepository;
import com.bilgeadam.repository.entity.Personal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonalService {

    private final IRepository repository;

    public Boolean register(RegisterRequestDto dto){

        Optional<Personal> personal = repository.findOptionalByEmail(dto.getEmail());

        if (personal.isPresent()){

            throw new RuntimeException("BU EMAIL ADRESI ALINMIS...");

        }else {

            repository.save(IPersonalMapper.INSTANCE.fromRegisterRequestDto(dto));

            return true;
        }

    }

    public Boolean login(LoginRequestDto dto){

        Optional<Personal> personal = repository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());

        if (personal.isEmpty()){

            throw new RuntimeException("HATALI SIFRE VEYA EMAIL...");

        }else {



            return true;
        }


    }


    public List<Personal> findAll(){

        List<Personal>personals = repository.findAll();

        if (personals.isEmpty()){
            throw new RuntimeException("HIC BIR PERSONEL BULUNAMADI...");
        }

        return personals;
    }

    public Boolean updateAddress(Long id, String address){

        Optional<Personal> personal = repository.findById(id);

        if (personal.isEmpty()){
            throw new RuntimeException("BU KULLANICI BULUNAMADI...");
        }

        personal.get().setAddress(address);
        repository.save(personal.get());
        return true;
    }

}
