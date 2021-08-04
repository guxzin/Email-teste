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
    private String remetente;
    private String emailDe;
    private String emailPara;
    private String assunto;
    private String telefone;

    @Column(columnDefinition = "TEXT")
    private String texto;
    private LocalDateTime dataDeEnvio;
    private StatusEmail statusEmail ;

}
