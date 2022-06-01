package com.myPortfolioGramback.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<Post> findAllByUserInfo_idByOrderByCreateDateDesc(long userId);
    List<Post> findAllByOrderByCreateDateDesc();

    @Query(value = "select p.content, p.create_date, ui.user_id, ui.user_img_url, p2.file_name from post p \n" +
            "inner join user_info ui on p.userinfo_id = ui.id\n" +
            "right outer join photos p2 on p.id = p2.postid order by p.create_date desc", nativeQuery = true)
    Optional<Object[]> getPostList();

    @Query(value = "select a.post_id, a.count commentCnt, b.count likeCnt from\n" +
            "(select c.post_id post_id, count(c.user_id) from \"comments\" c \n" +
            "group by c.post_id) a\n" +
            "inner join \n" +
            "(select l.post_id, count(l.user_id) from likes l \n" +
            "group by l.post_id) b\n" +
            "on a.post_id = b.post_id", nativeQuery = true)
    Optional<Object[]> getCnts();
}
