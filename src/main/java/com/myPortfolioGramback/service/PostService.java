package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    PostRepository postRepository;

    public Success getPostList(String userId) {
        Success success = new Success(true);

        List<Post> postList = postRepository.findAll();

        return success;
    }
}
