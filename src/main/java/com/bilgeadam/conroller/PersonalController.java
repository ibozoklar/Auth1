package com.bilgeadam.conroller;

import com.bilgeadam.dto.LoginRequestDto;
import com.bilgeadam.dto.RegisterRequestDto;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {


    private final PersonalService personalService;


    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(personalService.register(dto));

    }
    @GetMapping("/findall")
    public ResponseEntity<List<Personal>> findAll(){
        return ResponseEntity.ok(personalService.findAll());
    }

    @PutMapping("/updateAddress/{id}/{address}")
    public ResponseEntity<Boolean> updateAddress(@PathVariable Long id, @PathVariable String address){

        return ResponseEntity.ok(personalService.updateAddress(id, address));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody @Valid LoginRequestDto dto){

        return ResponseEntity.ok(personalService.login(dto));

    }

}
