package com.farmmart.controller.refreshtoken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.appuser.AppUserNotFoundException;
import com.farmmart.data.model.userrole.UserRole;
import com.farmmart.service.appuser.AppUserDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class RefreshTokenController {

    private final AppUserDetailService appUserDetailService;

    @GetMapping("/refresh/token")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {

        String authorizationHeader=request.getHeader(AUTHORIZATION);

        if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){

            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());

                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();

                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String username = decodedJWT.getSubject();

                AppUser appUser=appUserDetailService.findUserByUsername(username);

                String access_token= JWT.create()
                        .withSubject(appUser.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles",appUser.getUserRoles()
                                .stream()
                                .map(UserRole::getRoleName)
                                .collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens=new HashMap<>();

                tokens.put("access_token",access_token);

                tokens.put("refresh_token",refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }catch (Exception | AppUserNotFoundException ex){

                log.error("Error logging in: {}", ex.getMessage());

                response.setHeader("error", ex.getMessage());

                response.setStatus(FORBIDDEN.value());

                Map<String, String> error=new HashMap<>();

                error.put("error_message", ex.getMessage());

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }

        }else {
            throw new RuntimeException("Refresh token is missing");
        }

    }
}
