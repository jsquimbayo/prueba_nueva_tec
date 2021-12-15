package com.EasyHome.taskmanager.commons.domains.entity;



import lombok.*;

import javax.persistence.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "col_product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "code_product")
    private String codeProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "price_product")
    private String priceProduct;

    @Column(name = "category_product")
    private String categoryProduct;

    @Column(name = "is_offer")
    private String isOffter;

}
