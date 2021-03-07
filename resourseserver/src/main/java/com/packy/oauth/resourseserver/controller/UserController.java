package com.packy.oauth.resourseserver.controller;

import com.packy.oauth.resourseserver.response.UserResponse;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status() {
        return "Working...";
    }

    @PreAuthorize("hasAuthority('ROLE_backend') and #id==#jwt.subject")
//    @Secured("ROLE_backend")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId==#jwt.subject")
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserResponse("Packy", "Ran", id);
    }
}
