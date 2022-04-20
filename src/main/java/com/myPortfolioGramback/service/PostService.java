package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.post.PostDto;
import com.myPortfolioGramback.domain.user.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Success getPostList(String userId) {
        Success success = new Success(true);

        List<Post> postList = postRepository.findAll();

        PostDto postDto = convertToPostDTO(postList);
        success.setResult(postDto);

        return success;
    }

    private PostDto convertToPostDTO(List<Post> postList) {

        PostDto postDto = new PostDto();
        for(Post post : postList) {
            postDto.setPostId(post.getId());
            postDto.setImgUrl(post.getPhotos().get(0).getFileName());
        }
        return postDto;
    }
}
