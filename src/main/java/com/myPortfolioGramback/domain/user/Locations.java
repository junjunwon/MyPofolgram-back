package com.myPortfolioGramback.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="Locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @Column(name="title",columnDefinition = "VARCHAR (50)")
    private String title;

    @Column(name="address", columnDefinition = "VARCHAR (100)")
    private String address;

}
