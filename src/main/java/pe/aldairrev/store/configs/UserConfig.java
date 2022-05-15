package pe.aldairrev.store.configs;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.aldairrev.store.models.User;
import pe.aldairrev.store.repositories.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User user = new User(
                1L,
                "aldairrev",
                "Aldair",
                "Revilla",
                "aldairreva@gmail.com",
                LocalDate.of(2000, Month.JULY, 6)
            );
            repository.save(user);
        };
    }
}
