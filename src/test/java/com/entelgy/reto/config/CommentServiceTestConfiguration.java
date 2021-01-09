package com.entelgy.reto.config;

import com.entelgy.reto.service.CommentService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CommentServiceTestConfiguration {

    @Bean
    @Primary
    public CommentService commentService() {
        return Mockito.mock(CommentService.class);
    }
}
