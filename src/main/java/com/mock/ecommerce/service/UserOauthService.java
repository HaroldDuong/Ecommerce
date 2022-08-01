package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.UserOAuth;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * author: CuongTTC
 * */

@Service
@Transactional
public class UserOauthService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{
        OAuth2User user = super.loadUser(oAuth2UserRequest);
        return new UserOAuth(user);
    }

}
