package com.dhernandez.gimnasio.domain.dto;

import lombok.Data;

@Data
public class EmailBody {
    private String email;
    private String content;
    private String subject;

}
