package com.myPortfolioGramback.service;

import com.myPortfolioGramback.common.Success;
import com.myPortfolioGramback.domain.user.UserInfo;
import com.myPortfolioGramback.domain.user.UserInfoDto;
import com.myPortfolioGramback.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    /**
     * 사용자 프로필 조회
     *
     * @author jh.won
     * @since 2022.03.23
     * @return Success
     */
    public Success getProfileInfo() {

        Success success = new Success(false);

        List<UserInfo> userInfo = userRepository.findAll();


        List<UserInfoDto> userInfoDtos = userInfo.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        success.setResult(userInfoDtos);
        success.setSuccess(true);

        return success;
    }

    public UserInfoDto convertToDto(UserInfo userInfo) {
        UserInfoDto userInfoDto = modelMapper.map(userInfo, UserInfoDto.class);
        return userInfoDto;
    }
}
