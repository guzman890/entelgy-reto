package com.entelgy.reto.service;

import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.model.entidad.Comment;
import com.entelgy.reto.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService service;

    @Mock
    private CommentRepository repository;

    @Test
    public void whengetCommentList() {

        ArrayList<Comment> listaComment = new ArrayList<Comment>();

        Comment comment = new Comment();

        comment.setId(1);
        comment.setPostId(1);
        comment.setEmail("Eliseo@gardner.biz");

        listaComment.add(comment);

        Mockito.when(repository.getCommets()).thenReturn(listaComment);

        DataDTO getDataDTO = service.getCommentList();

        StringJoiner concatenado = new StringJoiner("|");

        concatenado.add( "1" );
        concatenado.add( "1" );
        concatenado.add( "Eliseo@gardner.biz" );

        assertEquals(
                getDataDTO.getData().get(0),
                concatenado.toString()
        );
    }
}
