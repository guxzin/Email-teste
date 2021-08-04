package com.mircoservice.dbamail.controllers;

import com.mircoservice.dbamail.dtos.EmailDTO;
import com.mircoservice.dbamail.models.EmailModel;
import com.mircoservice.dbamail.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<EmailModel> enviarEmail(@RequestBody @Valid EmailDTO emailDTO){

        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.enviarEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }
}
