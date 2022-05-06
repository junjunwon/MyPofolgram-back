package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.Photos;
import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.post.PostDetailDto;
import com.myPortfolioGramback.domain.user.post.PostDto;
import com.myPortfolioGramback.domain.user.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final EntityManager entityManager;

    public Success getPostList(String userId) {
        Success success = new Success(true);

        List<Post> postList = postRepository.findAll();

        List<PostDto> postDtoList = convertToPostDTO(userId, postList);
        /**
         * select post.id, file_name, p.id from post inner join photos p ON post.id = p.postid
         * where post.id = 1
         * order by p.id asc
         */
//        String jpql = "select p from Post p inner join p.photos pt order by pt.id asc"; //working

//         List<Post> posts = entityManager.createQuery(jpql, Post.class).getResultList(); //working

//        List<PostDto> postDtos = convertToPostDTO(posts);

        success.setResult(postDtoList);

        return success;
    }

    private List<PostDto> convertToPostDTO(String userId, List<Post> postList) {

        List<PostDto> postDtoList = new ArrayList<>();
        for(Post post : postList) {
            //추후 findByUserId로 변경해서 최적화
            if(!Objects.equals(userId, post.getUserInfo().getUserId())) continue;
            PostDto postDto = new PostDto();
            postDto.setPostId(post.getId());

            //Set으로 처리할때
//            Iterator<Photos> photos = post.getPhotos().iterator();
//            postDto.setImgUrl(photos.next().getFileName());
            postDto.setImgUrl(post.getPhotos().get(0).getFileName());

            postDtoList.add(postDto);
        }

        return postDtoList;
    }

    public Success getPostListDetail() {
        Success success = new Success(false);

        List<Post> postList = postRepository.findAll();

        List<PostDetailDto> postDetailDtos = convertToPostDetailDto(postList);

        success.setSuccess(true);
        return success;
    }

    private List<PostDetailDto> convertToPostDetailDto(List<Post> postList) {

    }
}
