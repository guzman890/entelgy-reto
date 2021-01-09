package com.entelgy.reto.service;

import com.entelgy.reto.model.dto.CommentDTO;
import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.model.entidad.Comment;
import com.entelgy.reto.model.mapper.CommentMapper;
import com.entelgy.reto.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper mapper;

    @Override
    public DataDTO getCommentList() {

        List<Comment> comments = commentRepository.getCommets();

        //List<CommentDTO>  CommentDTOs = mapper.toCommentDTOs(comments);

        List<String> commentList = new ArrayList<String>();

        DataDTO dataDTO =new DataDTO();
        comments.forEach( iterador ->{
            StringJoiner concatenado = new StringJoiner("|");

            concatenado.add( iterador .getPostId().toString());
            concatenado.add( iterador .getId().toString());
            concatenado.add( iterador .getEmail());

            commentList.add(concatenado.toString());
        });
        
        dataDTO.setData(commentList);

        return dataDTO;
    }
}
