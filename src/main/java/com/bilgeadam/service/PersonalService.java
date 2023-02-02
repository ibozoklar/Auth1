package com.bilgeadam.service;

import com.bilgeadam.dto.BaseRequestDto;
import com.bilgeadam.dto.LoginRequestDto;
import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.exception.AuthMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.IPersonalMapper;
import com.bilgeadam.repository.IPersonalRepository;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.repository.entity.UserType;
import com.bilgeadam.utility.JwtTokenManager;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonalService {

    private final IPersonalRepository repository;
    private final JwtTokenManager jwtTokenManager;

    public PersonalService(IPersonalRepository repository, JwtTokenManager tokenGenerator) {

        this.repository = repository;
        this.jwtTokenManager = tokenGenerator;

    }

    public Boolean register(RegisterRequestDto dto) {

        Optional<Personal> personal = repository.findOptionalByEmail(dto.getEmail());

        if (personal.isPresent()) {

            throw new AuthMicroserviceException(ErrorType.REGISTER_EMAIL_KAYITLI);

        } else {

            repository.save(IPersonalMapper.INSTANCE.fromRegisterRequestDto(dto));

            return true;
        }

    }

    public String login(LoginRequestDto dto) {

        Optional<Personal> personal = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());

        if (personal.isEmpty())
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);

        Optional<String> token = jwtTokenManager.createToken(personal.get().getId());

        if (token.isEmpty())
            throw new AuthMicroserviceException(ErrorType.JWT_TOKEN_CREATE_ERROR);

        return token.get();
    }


    public List<Personal> findAll(BaseRequestDto dto) {
        Optional<Long> id = jwtTokenManager.getByIdFromToken(dto.getToken());

        if (id.isEmpty())
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);

        Optional<Personal> personal = repository.findOptionalById(id.get());
        if (personal.isEmpty()) {
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        if (personal.get().getUserType() != UserType.ADMIN) {
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        return repository.findAll();
    }



    public Boolean updateAddress(Long id, String address) {

        Optional<Personal> personal = repository.findById(id);

        if (personal.isEmpty()) {
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }

        personal.get().setAddress(address);
        repository.save(personal.get());
        return true;
    }

    public Optional<Personal> findById(Long id) {
        return repository.findById(id);
    }

    public Boolean updatePhoto(Long id, String photo) {

        Optional<Personal> personal = repository.findById(id);

        if (personal.isEmpty()) {
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }

        personal.get().setPhoto(photo);
        repository.save(personal.get());
        return true;
    }


    public Boolean updateTelephone(Long id, String telephone) {

        Optional<Personal> personal = repository.findById(id);

        if (personal.isEmpty()) {
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }

        personal.get().setTelephone(telephone);
        repository.save(personal.get());
        return true;
    }
}
