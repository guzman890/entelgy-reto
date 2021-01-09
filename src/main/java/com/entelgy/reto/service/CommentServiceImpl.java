package com.entelgy.reto.service;

import com.entelgy.reto.model.dto.CommentDTO;
import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.model.entidad.Comment;
import com.entelgy.reto.model.mapper.CommentMapper;
import com.entelgy.reto.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper mapper;

    @Override
    public DataDTO getCommentList() {

        List<Comment> comments = commentRepository.getCommets();

        List<CommentDTO>  CommentDTOs = mapper.toCommentDTOs(comments);

        DataDTO dataDTO =new DataDTO();
        dataDTO.setData(CommentDTOs);

        return dataDTO;
    }
}
