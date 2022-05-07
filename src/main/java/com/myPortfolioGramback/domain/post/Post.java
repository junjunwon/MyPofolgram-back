package com.myPortfolioGramback.domain.post;

import com.myPortfolioGramback.domain.*;
import com.myPortfolioGramback.domain.comments.Comments;
import com.myPortfolioGramback.domain.likes.Likes;
import com.myPortfolioGramback.domain.userInfo.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PostHashTag> postHashTags = new HashSet<PostHashTag>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comments> comments = new HashSet<Comments>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Likes> likes = new HashSet<Likes>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Photos> photos = new ArrayList<>();

    public void addPhotos(Photos photo) {
        photo.setPost(this);
        photos.add(photo);
    }
}
