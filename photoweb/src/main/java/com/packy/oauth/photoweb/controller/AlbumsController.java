package com.packy.oauth.photoweb.controller;

import com.packy.oauth.photoweb.response.AlbumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class AlbumsController {
    @Autowired
    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @GetMapping("/albums")
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient oAuth2AuthorizedClient = oAuth2AuthorizedClientService
                .loadAuthorizedClient(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId(), oAuth2AuthenticationToken.getName());
        String jwtAccessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
        System.out.println("jwtAccessToken = " + jwtAccessToken);

        String idToken = oidcUser.getIdToken().getTokenValue();
        System.out.println("idToken = " + idToken);


        AlbumResponse album1 = new AlbumResponse();
        album1.setAlbumId("Album 1");
        album1.setAlbumTitle("Album 1 title");
        album1.setAlbumUrl("http://localhost:8087/albums/1");

        AlbumResponse album2 = new AlbumResponse();
        album2.setAlbumId("Album 2");
        album2.setAlbumTitle("Album 2 title");
        album2.setAlbumUrl("http://localhost:8087/albums/2");

        model.addAttribute("albums", Arrays.asList(album1, album2));
        return "albums";
    }
}