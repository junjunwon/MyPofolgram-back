package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.likes.Likes;
import com.myPortfolioGramback.domain.comments.Comments;
import com.myPortfolioGramback.domain.comments.CommentsDto;
import com.myPortfolioGramback.domain.comments.CommentsRepository;
import com.myPortfolioGramback.domain.likes.LikesRepository;
import com.myPortfolioGramback.domain.post.Post;
import com.myPortfolioGramback.domain.post.PostDetailDto;
import com.myPortfolioGramback.domain.post.PostDto;
import com.myPortfolioGramback.domain.post.PostRepository;
import com.myPortfolioGramback.domain.userInfo.UserInfo;
import com.myPortfolioGramback.domain.userInfo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final EntityManager entityManager;

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;

    private final CommentsRepository commentsRepository;

    private final UserRepository userRepository;

    private final LikesRepository likesRepository;


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

    public Success getPostListDetail(String userId) {
        Success success = new Success(false);

        List<Post> postList = postRepository.findAll();

        List<PostDetailDto> postDetailDtos = convertToPostDetailDto(userId, postList);

        success.setSuccess(true);
        success.setResult(postDetailDtos);
        return success;
    }

    private List<PostDetailDto> convertToPostDetailDto(String userId, List<Post> postList) {

        List<PostDetailDto> postDetailDtos = new ArrayList<>();

        for(Post post : postList) {
            PostDetailDto postDetailDto = new PostDetailDto();
            postDetailDto.setId(post.getId());
            postDetailDto.setContent(post.getContent());
            postDetailDto.setCreateDate(post.getCreateDate());
            postDetailDto.setNickName(post.getUserInfo().getUserName());
            postDetailDto.setUserImgUrl(post.getUserInfo().getUserImgUrl());
            List<String> photos = new ArrayList<>();
            for(int i = 0; i<post.getPhotos().size(); i++) {
                photos.add(post.getPhotos().get(i).getFileName());
            }
            postDetailDto.setPhotoImgUrl(photos);
            postDetailDto.setCommentCount(post.getComments().size());
            postDetailDto.setLikeCount(post.getLikes().size());

            //Set으로 처리할때
//            Iterator<Photos> photos = post.getPhotos().iterator();
//            postDto.setImgUrl(photos.next().getFileName());

            Iterator<Likes> likes = post.getLikes().iterator();

            while(likes.hasNext()) {
                if(Objects.equals(userId, likes.next().getUserInfo().getUserId())) {
                    postDetailDto.setIsLiked("true");
                    break;
                }
            }

            postDetailDtos.add(postDetailDto);
        }

        return postDetailDtos;
    }


    public Success getCommentList(String postId) {
        Success success = new Success(false);

        List<Comments> commentsList = commentsRepository.findAllByPostId(Integer.parseInt(postId));

        List<CommentsDto> commentsDtos = convertToCommentDto(commentsList);

        success.setResult(commentsDtos);
        success.setSuccess(true);

        return success;

    }

    private List<CommentsDto> convertToCommentDto(List<Comments> commentsList) {
        List<CommentsDto> list = new ArrayList<>();

        for(Comments comments : commentsList) {
            CommentsDto commentsDto = new CommentsDto();
            long userId = comments.getUserId();
            String jpql = "select u from UserInfo u where u.id = :userId";
            TypedQuery<UserInfo> query = entityManager.createQuery(jpql, UserInfo.class);
            query.setParameter("userId", userId);

            List<UserInfo> resultList = query.getResultList();

            commentsDto.setNickName(resultList.get(0).getUserName());
            commentsDto.setUserImgUrl(resultList.get(0).getUserImgUrl());
            commentsDto.setComment(comments.getComment());
            commentsDto.setCreateDate(comments.getCreateDate());

            list.add(commentsDto);
        }

        return list;
    }

    public Success saveLikeForPost(String userId, String postId) {
        Success success = new Success(false);
        Likes likes = new Likes();
        Post post = postRepository.getById(Integer.parseInt(postId));
        UserInfo userInfo = userRepository.findByUserId(userId); //id인지 userId 인지?
        likes.setPost(post);
        likes.setUserInfo(userInfo);
        likesRepository.save(likes);

        success.setSuccess(true);
        return success;
    }
}
