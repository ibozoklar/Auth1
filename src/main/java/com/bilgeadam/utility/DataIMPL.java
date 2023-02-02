package com.bilgeadam.utility;

import com.bilgeadam.repository.IPersonalRepository;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.repository.entity.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@RequiredArgsConstructor
public class DataIMPL {

    private final IPersonalRepository repository;

    @PostConstruct
    public void initData() {
        createPersonals();
    }

    private void createPersonals() {
        Personal personal1 = Personal.builder().name("Hilal Zülfü").address("Ankara").email("hilaler@hotmail.com").nationalId(25698103791L).photo("foto").password("1234").userType(UserType.ADMIN).build();
        Personal personal2 = Personal.builder().name("İhsan Can").address("İzmir").email("ihsancan@hotmail.com").nationalId(28568103791L).photo("foto").userType(UserType.ADMIN).build();
        Personal personal3 = Personal.builder().name("Emre Ilgar").address("İstanbul").email("eilgar@hotmail.com").nationalId(32058103791L).photo("foto").userType(UserType.DIRECTOR).build();
        Personal personal4 = Personal.builder().name("Tuna Dağ").address("Antalya").email("tunadag@hotmail.com").nationalId(32058105555L).photo("foto").password("3456").userType(UserType.PERSONAL).build();
        repository.save(personal1);
        repository.save(personal2);
        repository.save(personal3);
        repository.save(personal4);
    }
}
