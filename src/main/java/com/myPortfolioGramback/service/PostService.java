package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.Photos;
import com.myPortfolioGramback.domain.likes.Likes;
import com.myPortfolioGramback.domain.comments.Comments;
import com.myPortfolioGramback.domain.comments.CommentsDto;
import com.myPortfolioGramback.domain.comments.CommentsRepository;
import com.myPortfolioGramback.domain.likes.LikesRepository;
import com.myPortfolioGramback.domain.post.*;
import com.myPortfolioGramback.domain.userInfo.UserInfo;
import com.myPortfolioGramback.domain.userInfo.UserRepository;
import com.myPortfolioGramback.service.amazonS3.S3Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.IOException;
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

    private final S3Service s3Service;

    public Success getPostList(String userId) {
        Success success = new Success(true);

        List<Post> postList = postRepository.findAll();

        List<PostDto> postDtoList = convertToPostDTO(userId, postList);
        /*
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
            if(post.getPhotos().size() > 0) {
                postDto.setImgUrl(post.getPhotos().get(0).getFileName());
            }


            postDtoList.add(postDto);
        }

        return postDtoList;
    }

    public Success getPostListDetail(String userId, String isMypage) {
        Success success = new Success(false);
        List<Post> postList = new ArrayList<>();
        postList = postRepository.findAllByOrderByCreateDateDesc();

        /**
         * 참조객체인 userinfo를 통해 post정보 찾는 방법 찾기.
         */
//        if(ObjectUtils.isEmpty(isMypage)) {
//            postList = postRepository.findAllByOrderByCreateDateDesc();
//        } else {
//            postList = postRepository.findAllByUserInfo_idByOrderByCreateDateDesc(userInfo.getId());
//        }


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
            if(!ObjectUtils.isEmpty(post.getContent())) postDetailDto.setContent(post.getContent());
            if(!ObjectUtils.isEmpty(post.getUserInfo().getUserName())) postDetailDto.setNickName(post.getUserInfo().getUserName());
            postDetailDto.setUserImgUrl(post.getUserInfo().getUserImgUrl());
            postDetailDto.setCreateDate(post.getCreateDate());
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
            postDetailDto.setIsLiked("false");
            while(likes.hasNext()) {
                UserInfo userInfo = likes.next().getUserInfo();
                likes.remove();
                if(Objects.equals(userId, userInfo.getUserId())) {
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

    @Transactional
    public Success saveLikeForPost(String userId, String postId, String isLiked) {
        Success success = new Success(false);

        Post post = postRepository.getById(Integer.parseInt(postId));
        UserInfo userInfo = userRepository.getById(Long.parseLong(userId)); //id인지 userId 인지?

        Likes likes =new Likes();
        likes.setPost(post);
        likes.setUserInfo(userInfo);

        int deleteCount = 0;
        boolean isDelete = false; //false : delete, true : save

        if(!ObjectUtils.isEmpty(post) && !ObjectUtils.isEmpty(userId)){
            if(Objects.equals(isLiked, "false")) {
                deleteCount = likesRepository.deleteByPostAndUserInfo(post, userInfo);
            }
            else if(Objects.equals(isLiked, "true")){
                Likes getLikes = likesRepository.findByPostAndUserInfo(post, userInfo);
                if(ObjectUtils.isEmpty(getLikes)) {
                    Likes likesResult = likesRepository.save(likes);
                    if(ObjectUtils.isEmpty(likesResult)) {
                        success.setSuccess(false);
                        success.setErrorMsg("failed_to_save");
                        return success;
                    }
                } else {
                    success.setSuccess(false);
                    success.setErrorMsg("already_saved_data_sync_probs_exist");
                    return success;
                }
                deleteCount = 1;
                isDelete = true;
            }
        }
        if(deleteCount != 1) {
            success.setSuccess(false);
            success.setErrorMsg("something_is_wrong");
            return success;
        }
        success.setResult(isDelete);

        success.setSuccess(true);
        return success;
    }

    public Success savePost(SavePostDto savePostDto) throws IOException {
        Success success = new Success(true);

        Post post = modelMapper.map(savePostDto.getPostDetailDto(), Post.class);

        UserInfo userInfo = userRepository.getById(savePostDto.getPostDetailDto().getUserId()); //id인지 userId 인지?

        List<String> fileList = new ArrayList<>();
        List<Photos> photoList = new ArrayList<>();

        for(int i = 0; i < savePostDto.getMultipartFiles().size(); i++) {
            Photos photo = new Photos();
            String fileName = s3Service.upload(savePostDto.getMultipartFiles().get(i));
            fileList.add(fileName);
            photo.setFileName(fileName);
            photo.setPost(post);
            photoList.add(photo);
        }

        post.setPhotos(photoList);
        post.setUserInfo(userInfo);

        postRepository.save(post);

        return success;
    }
}
