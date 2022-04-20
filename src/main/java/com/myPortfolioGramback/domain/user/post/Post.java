package com.myPortfolioGramback.domain.user.post;

import com.myPortfolioGramback.domain.user.*;
import com.myPortfolioGramback.domain.user.userInfo.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userinfo_id")
    private UserInfo userInfo;

    @Column(name="content", columnDefinition = "VARCHAR(2000)")
    private String content;

//    @OneToMany
//    @JoinColumn(name = "Photos_id")
//    private Set<Photos> photoId;

    @OneToMany
    @JoinColumn(name = "Locations_id")
    private Set<Locations> locationId;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "updateDate")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name = "removeDate")
    private LocalDateTime removeDate;

    @OneToMany(mappedBy = "post")
    private List<PostHashTag> postHashTags = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id")
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Photos> photos = new ArrayList<>();
}
