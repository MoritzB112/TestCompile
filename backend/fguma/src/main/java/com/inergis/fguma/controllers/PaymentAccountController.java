package com.inergis.fguma.controllers;

import com.inergis.fguma.entities.PaymentAccount;
import com.inergis.fguma.converters.PaymentAccountConverter;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inergis.fguma.services.PaymentAccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/paymentAccount")
public class PaymentAccountController {

    @Autowired
    private PaymentAccountService paymentAccountService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<PaymentAccount>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User user = userService.getByToken(token);
        return ResponseEntity.ok(paymentAccountService.getAll().stream().filter(paymentAccount -> {
            if (user == null) {
                return false;
            }
            if (user.getAppUser() == null) {
                return false;
            }
            return paymentAccount.getDepartment().getId().equals(user.getAppUser().getDepartment().getId());
        }).map(PaymentAccountConverter::toExternal).toList());
    }
}