package com.mircoservice.dbamail.service;

import com.mircoservice.dbamail.enums.StatusEmail;
import com.mircoservice.dbamail.models.EmailModel;
import com.mircoservice.dbamail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel enviarEmail(EmailModel emailModel) {
        emailModel.setDataDeEnvio(LocalDateTime.now());
        try{
            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setFrom(emailModel.getEmailDe());
            mensagem.setTo(emailModel.getEmailPara());
            mensagem.setSubject(emailModel.getAssunto());
            mensagem.setText(emailModel.getTexto());
            emailSender.send(mensagem);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
         emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(emailModel);
        }

    }
}
