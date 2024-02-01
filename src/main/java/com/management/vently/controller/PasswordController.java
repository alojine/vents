package com.management.vently.controller;

import com.management.vently.mapper.PasswordMapper;
import com.management.vently.domain.DTO.PasswordDTO;
import com.management.vently.domain.DTO.UserDTO;
import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;
import com.management.vently.service.PasswordService;
import com.management.vently.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/password")
public class PasswordController {

    private final PasswordService passwordService;

    private final UserService userService;

    private final PasswordMapper passwordMapper;

    @Autowired
    public PasswordController(PasswordService passwordService, UserService userService, PasswordMapper passwordMapper) {
        this.passwordService = passwordService;
        this.userService = userService;
        this.passwordMapper = passwordMapper;
    }

    @GetMapping
    public ResponseEntity<List<PasswordDTO>> getAllByUser(UserDTO userDTO) {
        User user = userService.getByEmail(userDTO.email())
                .orElseThrow(() -> new RuntimeException(""));
        return new ResponseEntity<>(passwordMapper.passwordListToPasswordDTOList(passwordService.getAllByUser(user)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody PasswordDTO passwordDTO) {
//        passwordService.save(passwordMapper.passwordDTOtoPassword(passwordDTO), userService.getByEmail(passwordDTO.user().getEmail()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> put(@RequestBody Password password) {
        passwordService.put(password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
