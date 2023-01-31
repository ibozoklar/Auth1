package com.bilgeadam.repository;


import com.bilgeadam.repository.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRepository extends JpaRepository<Personal,Long> {



    Optional<Personal> findOptionalByEmail(String email);

    Optional<Personal> findOptionalByEmailAndPassword(String email, String password);

    //List<Optional<Personal>> findAllOptional();

}
