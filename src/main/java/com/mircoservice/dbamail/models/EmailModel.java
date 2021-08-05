package com.mircoservice.dbamail.models;

import com.mircoservice.dbamail.enums.StatusEmail;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class EmailModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;

    //informações do email

    private String remetente;
    private String emailDe;
    private String emailPara;
    private String emailAssunto;
    private String emailTexto;
    private LocalDateTime dataDeEnvio;
    private StatusEmail statusEmail ;

}
