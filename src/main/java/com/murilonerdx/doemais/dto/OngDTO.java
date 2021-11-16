package com.murilonerdx.doemais.dto;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OngDTO {
    private Long id;
    private String name;
    @CNPJ
    private String cnpj;
    private String address;

    private CredentialDTO user;
}
