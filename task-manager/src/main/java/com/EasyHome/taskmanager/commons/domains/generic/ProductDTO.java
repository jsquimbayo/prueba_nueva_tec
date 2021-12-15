package com.EasyHome.taskmanager.commons.domains.generic;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO implements Serializable {

    private Integer idProduct;
    private String codeProduct;
    private String nameProduct;
    private String priceProduct;
    private String categoryProduct;
    private String isOffter;

}
