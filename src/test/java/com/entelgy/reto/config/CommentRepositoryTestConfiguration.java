package com.entelgy.reto.config;

import com.entelgy.reto.repository.CommentRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CommentRepositoryTestConfiguration {
    @Bean
    @Primary
    public CommentRepository commentRepository() {
        return Mockito.mock(CommentRepository.class);
    }
}
