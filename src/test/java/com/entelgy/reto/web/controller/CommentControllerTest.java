package com.entelgy.reto.web.controller;

import com.entelgy.reto.model.dto.CommentDTO;
import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentControllerTest {
    @Autowired
    private CommentController controller;

    @Mock
    private CommentService service;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void whengetCommentList(){

        DataDTO dataDTO =  new DataDTO();

        ArrayList<String> listaComment= new ArrayList<String>();

        StringJoiner concatenado = new StringJoiner("|");

        concatenado.add( "1" );
        concatenado.add( "1" );
        concatenado.add( "Eliseo@gardner.biz" );

        listaComment.add(concatenado.toString());

        dataDTO.setData(listaComment);

        Mockito.when(service.getCommentList()).thenReturn(dataDTO);

        DataDTO getDataDTO = controller.getComments();

        assertEquals(
                getDataDTO.getData().get(0),
                dataDTO.getData().get(0)
        );

    }

}
