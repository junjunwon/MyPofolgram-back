package com.myPortfolioGramback.domain.user.follow;

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
@Table(name="Follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "follower")
    private List<Following> followings = new ArrayList<>();
}
