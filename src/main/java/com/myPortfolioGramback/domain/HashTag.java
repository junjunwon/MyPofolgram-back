package com.myPortfolioGramback.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="HashTag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @Column(name="title", columnDefinition = "VARCHAR (100)")
    private String title;


    @OneToMany(mappedBy = "hashTag")
    private List<PostHashTag> postHashTags = new ArrayList<>();
}
