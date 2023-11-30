package dscar.demojwt.Auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dscar.demojwt.User.Role;
import dscar.demojwt.User.User;
import dscar.demojwt.User.UserRepository;
import dscar.demojwt.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public enum AuthService {
    ;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    //private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        
        User user = User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }

}
