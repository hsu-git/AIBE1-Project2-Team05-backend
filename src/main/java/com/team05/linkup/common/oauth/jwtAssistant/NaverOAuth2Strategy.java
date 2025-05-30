package com.team05.linkup.common.oauth.jwtAssistant;


import com.team05.linkup.domain.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NaverOAuth2Strategy implements OAuth2ProviderStrategy {
    @Override
    public String extractProviderId(OAuth2User oAuth2User) {
        Map<String, Object> response = oAuth2User.getAttribute("response");
        return response != null ? (String) response.get("id") : null;
    }

    @Override
    public Map<String, Object> buildUserAttributes(User user) {
        return Map.of("id", user.getProviderId(),
                    "name", user.getName(),
                    "profile_image", user.getProfileImageUrl());
    }
}
