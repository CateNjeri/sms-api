package com.great.school.controllers;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;
import com.great.school.models.request.LoginRequest;
import com.great.school.models.request.RegisterUserAccountRequest;
import com.great.school.services.AuthenticationService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Kibet on 27-Nov-17.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserAccount> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<UserAccount> userAccountOptional = authenticationService.login(loginRequest);
        return userAccountOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@Valid @RequestBody UserAccount userAccount) {
        Optional<UserAccount> userAccountOptional = authenticationService.register(userAccount);
        return userAccountOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .build());
    }

    @PostMapping("/register/schools/accounts")
    public ResponseEntity<UserAccount> registerSchoolUserAccount(@Valid @RequestBody SchoolUserAccount schoolUserAccount) {
        schoolUserAccount = authenticationService.registerSchoolUserAccount(schoolUserAccount);

        Optional<UserAccount> userAccountOptional = authenticationService
                .login(new LoginRequest(schoolUserAccount.getUserAccount().getUsername(),
                        schoolUserAccount.getUserAccount().getPassword()));
        return userAccountOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .build());
    }
}
