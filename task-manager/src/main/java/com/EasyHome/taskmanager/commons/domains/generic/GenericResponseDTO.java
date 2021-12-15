package com.EasyHome.taskmanager.commons.domains.generic;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GenericResponseDTO implements Serializable {

    public String message;
    public Object objectResponse;
    public int statusCode;
}
