package com.nick.example.graphql_example_kickstart.security.jwt;

import com.nick.example.graphql_example_kickstart.security.jwt.exception.AuthenticationException;
import com.nick.example.graphql_example_kickstart.security.jwt.resource.JwtTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@Component
public class JwtAuthenticationService {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtUserDetailService;

    public String createAuthenticationToken(String username, String password) throws AuthenticationException{
        authenticate(username, password);
        final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        return new JwtTokenResponse(token).getToken();
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    public void authenticate(String username, String password){
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new AuthenticationException("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }

}
