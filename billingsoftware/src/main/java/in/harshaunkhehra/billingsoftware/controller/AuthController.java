package in.harshaunkhehra.billingsoftware.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import in.harshaunkhehra.billingsoftware.io.AuthRequest;
import in.harshaunkhehra.billingsoftware.io.AuthResponse;
import in.harshaunkhehra.billingsoftware.service.impl.AppUserDetailsService;
import in.harshaunkhehra.billingsoftware.util.JwtUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService appUserDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) throws Exception {
        // authenticate the user, if the credentials are valid, it will return a JWT
        // token
        authenticate(request.getEmail(), request.getPassword());
        final UserDetails userDetails = appUserDetailsService.loadUserByUsername(request.getEmail()); // get the user
                                                                                                      // details from
                                                                                                      // the service
        final String jwtToken = jwtUtil.generateToken(userDetails); // generate the JWT token

        // FETCH THE ROLE FROM THE REPOSITORY
        return new AuthResponse(request.getEmail(), "USER", jwtToken); // return the response with email, role and token
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials provided");
        }
    }

    @PostMapping("/encode")
    public String encodePassword(@RequestBody Map<String, String> request) {
        // this endpoint is used to encode passwords
        return passwordEncoder.encode(request.get("password"));
    }

}
