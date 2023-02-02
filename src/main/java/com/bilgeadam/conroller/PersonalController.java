package com.bilgeadam.conroller;

import com.bilgeadam.dto.BaseRequestDto;
import com.bilgeadam.dto.LoginRequestDto;
import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {


    private final PersonalService personalService;


    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(personalService.register(dto));

    }


    @PostMapping("/findall")
    public ResponseEntity<List<Personal>> findByToken(@RequestBody @Valid BaseRequestDto dto){

        return ResponseEntity.ok(personalService.findAll(dto));
    }

    @PutMapping("/updateAddress/{id}/{address}")
    public ResponseEntity<Boolean> updateAddress(@PathVariable Long id, @PathVariable String address){

        return ResponseEntity.ok(personalService.updateAddress(id, address));
    }

    @PutMapping("/updatePhoto/{id}/{photo}")
    public ResponseEntity<Boolean> updatePhoto(@PathVariable Long id, @PathVariable String photo){

        return ResponseEntity.ok(personalService.updatePhoto(id, photo));
    }

    @PutMapping("/updateTelephone/{id}/{telephone}")
    public ResponseEntity<Boolean> updateTelephone(@PathVariable Long id, @PathVariable String telephone){

        return ResponseEntity.ok(personalService.updateTelephone(id, telephone));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto){

        return ResponseEntity.ok(personalService.login(dto));

    }

}
