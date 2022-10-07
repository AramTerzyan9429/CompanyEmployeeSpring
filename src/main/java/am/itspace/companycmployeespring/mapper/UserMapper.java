package am.itspace.companycmployeespring.mapper;

import am.itspace.companycmployeespring.dto.CreateUserDto;
import am.itspace.companycmployeespring.entity.Role;
import am.itspace.companycmployeespring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;


    public User mapToEntity(CreateUserDto dto){
        return User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.USER)
                .build();
    }
}
