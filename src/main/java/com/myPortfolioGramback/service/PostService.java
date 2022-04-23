package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.Photos;
import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.post.PostDto;
import com.myPortfolioGramback.domain.user.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Success getPostList(String userId) {
        Success success = new Success(true);

        List<Post> postList = postRepository.findAll();

        List<PostDto> postDtoList = convertToPostDTO(postList);
        success.setResult(postDtoList);

        return success;
    }

    private List<PostDto> convertToPostDTO(List<Post> postList) {

        List<PostDto> postDtoList = new ArrayList<>();
        for(Post post : postList) {
            PostDto postDto = new PostDto();
            postDto.setPostId(post.getId());
            Iterator<Photos> photos = post.getPhotos().iterator();
            postDto.setImgUrl(photos.next().getFileName());

            postDtoList.add(postDto);
        }

        return postDtoList;
    }
}
