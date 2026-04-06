package br.com.lgbv.prateleira_inteligente_v2.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    String username;
    String password;
    String email;
}