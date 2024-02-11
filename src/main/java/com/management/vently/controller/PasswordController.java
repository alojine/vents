package com.management.vently.controller;

import com.management.vently.domain.DTO.PasswordUpdateDto;
import com.management.vently.mapper.PasswordMapper;
import com.management.vently.domain.DTO.PasswordDTO;
import com.management.vently.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/password")
public class PasswordController {

    private final PasswordService passwordService;

    private final PasswordMapper passwordMapper;

    @Autowired
    public PasswordController(PasswordService passwordService, PasswordMapper passwordMapper) {
        this.passwordService = passwordService;
        this.passwordMapper = passwordMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasswordDTO> getPasswordById(@PathVariable Long id) {
        return new ResponseEntity<>(passwordMapper.passwordToPasswordDTO(passwordService.getById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPassword(@RequestBody PasswordDTO passwordDTO) {
        passwordService.add(passwordMapper.passwordDTOtoPassword(passwordDTO), passwordDTO.userId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updatePassword(@RequestBody PasswordUpdateDto passwordDTO) {
        passwordService.update(passwordDTO, passwordDTO.userId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        passwordService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
