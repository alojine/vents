package com.management.vently.controller;

import com.management.vently.model.Password;
import com.management.vently.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passwords")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public ResponseEntity<List<Password>> getAll() {
        return new ResponseEntity<>(passwordService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Password> save(@RequestBody Password password) {
        return new ResponseEntity<>(passwordService.save(password), HttpStatus.CREATED);
    }
}
