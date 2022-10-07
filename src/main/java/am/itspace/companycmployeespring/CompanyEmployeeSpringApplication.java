package am.itspace.companycmployeespring;

import am.itspace.companycmployeespring.entity.Role;
import am.itspace.companycmployeespring.entity.User;
import am.itspace.companycmployeespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

//start linox klass
@SpringBootApplication

public class CompanyEmployeeSpringApplication  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(CompanyEmployeeSpringApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> byEmail = userRepository.findByEmail("admin@email.com");
        if (byEmail.isEmpty()){
            userRepository.save(User.builder()
                            .email("admin@email.com")
                            .password(passwordEncoder().encode("admin"))
                            .role(Role.ADMIN)
                    .build());
        }
    }
}
