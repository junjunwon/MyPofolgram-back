package com.myPortfolioGramback.domain.user;

import com.myPortfolioGramback.domain.user.userInfo.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="Settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "bigint")
    private int id;

    @Column(name="isPrivate")
    private boolean isPrivate;

    @Column(name="addingPhotos",columnDefinition = "VARCHAR (255)")
    private String addingPhotos;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;
}
