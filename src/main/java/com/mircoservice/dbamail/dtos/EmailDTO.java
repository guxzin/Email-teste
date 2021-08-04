package com.mircoservice.dbamail.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {

    private Long emailId;

    @NotBlank
    private String remetente;

    @NotBlank
    @Email
    private String emailDe;

    @NotBlank
    @Email
    private String emailPara;

    @NotBlank
    private String assunto;

    @NotBlank
    private String telefone;

    @NotBlank
    private String texto;

}
