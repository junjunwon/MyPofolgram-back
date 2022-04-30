package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.follow.Follow;
import com.myPortfolioGramback.domain.user.follow.FollowDto;
import com.myPortfolioGramback.domain.user.follow.FollowRepository;
import com.myPortfolioGramback.domain.user.post.Post;
import com.myPortfolioGramback.domain.user.userInfo.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    @Transactional
    public Success getUserInfo(String userId) {

        Success success = new Success(false);

        UserInfo userInfo = userRepository.findByUserId(userId);
        long followerCnt = 0;
        long followeeCnt = 0;
        long postCnt = userInfo.getPosts().size();
        for(Follow follow : userInfo.getFollows()) {
            if(Objects.equals(userId, follow.getFollower())) {
                followerCnt ++;
            }
            if(Objects.equals(userId, follow.getFollowingId())) {
                followeeCnt++;
            }
        }

        UserInfoDto userInfoDto = convertToDto(userInfo, followerCnt, followeeCnt, postCnt);
        success.setResult(userInfoDto);
        success.setSuccess(true);

        return success;
    }

    public Success getProfileInfo(String userId) {
        Success success = new Success(false);

        UserInfo userInfo = userRepository.findByUserId(userId);

        UserProfileDto userProfileDto = modelMapper.map(userInfo, UserProfileDto.class);

        success.setResult(userProfileDto);
        success.setSuccess(true);

        return success;
    }


    public Success setUserInfo(SetUser setUser) {

        Success success = new Success(true);

        Optional<UserInfo> userInfoOptional = userRepository.findById(Long.parseLong(setUser.getSystemId()));
        UserInfo userInfo = userInfoOptional.orElseThrow(() -> new NoSuchElementException());

        if(Objects.equals(setUser.getType(), "name")) {
            userInfo.setUserId(setUser.getValue());
        } else if (Objects.equals(setUser.getType(), "nickname")) {
            userInfo.setUserName(setUser.getValue());
        } else if (Objects.equals(setUser.getType(), "intro")){
            userInfo.setIntro(setUser.getValue());
        }

        userRepository.save(userInfo);

        return success;
    }

    public Success getFollowList(String userId) {
        Success success = new Success(false);
        Map<String, Object> dataMap = new HashMap<>();

        //user 팔로잉 search
        List<Follow> followee = followRepository.findByFollowingId(userId);
        List<FollowDto> followeeDtoList = followee.stream().map(Follow -> modelMapper.map(Follow, FollowDto.class)).collect(Collectors.toList());

        //user 팔로워 search
        List<Follow> following = followRepository.findByFollower(userId);
        List<FollowDto> followerDtoList = following.stream().map(Follow -> modelMapper.map(Follow, FollowDto.class)).collect(Collectors.toList());

        int[] followCnt = {followeeDtoList.size(), followerDtoList.size()}; //following
        dataMap.put("followCnt", followCnt);
        dataMap.put("followeeList", followeeDtoList);
        dataMap.put("followerList", followerDtoList);

        success.setResult(dataMap);
        success.setSuccess(true);

        return success;

    }

    public UserInfoDto convertToDto(UserInfo userInfo, long followerCnt, long followeeCnt, long postCnt) {
        UserInfoDto userInfoDto = modelMapper.map(userInfo, UserInfoDto.class);
        //dummy data
        userInfoDto.setFollowerCnt(followerCnt);
        userInfoDto.setFolloweeCnt(followeeCnt);
        userInfoDto.setPostCnt(postCnt);
        return userInfoDto;
    }
}
