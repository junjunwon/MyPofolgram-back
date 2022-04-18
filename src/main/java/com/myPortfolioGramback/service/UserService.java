package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.follow.Follow;
import com.myPortfolioGramback.domain.user.follow.FollowDto;
import com.myPortfolioGramback.domain.user.follow.FollowRepository;
import com.myPortfolioGramback.domain.user.userInfo.SetUser;
import com.myPortfolioGramback.domain.user.userInfo.UserInfo;
import com.myPortfolioGramback.domain.user.userInfo.UserInfoDto;
import com.myPortfolioGramback.domain.user.userInfo.UserRepository;
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
    /**
     * 사용자 프로필 조회
     *
     * @author jh.won
     * @since 2022.03.23
     * @return Success
     */
    @Transactional
    public Success getProfileInfo(String userId) {

        Success success = new Success(false);

        UserInfo userInfo = userRepository.findByUserId(userId);

        UserInfoDto userInfoDto = convertToDto(userInfo);
        success.setResult(userInfoDto);
        success.setSuccess(true);

        return success;
    }

    public UserInfoDto convertToDto(UserInfo userInfo) {
        UserInfoDto userInfoDto = modelMapper.map(userInfo, UserInfoDto.class);
        //dummy data
        userInfoDto.setWebsite("http://naver.com");
        userInfoDto.setIntroduction("Hi this is wonjunho");
        userInfoDto.setFollow(15000);
        userInfoDto.setFollower(500000);
        userInfoDto.setCountBoard(67);
        return userInfoDto;
    }

    public Success setProfile(SetUser setUser) {

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

    /**
     * @author jh.won
     * @since 2022.04.16
     * @param userId
     * @return
     */
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
}
