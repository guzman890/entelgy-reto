package com.entelgy.reto.web.controller;

import com.entelgy.reto.constants.Constants;
import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + Constants.PATH_COMMENTS)
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public DataDTO getComments(){
        return commentService.getCommentList();
    }
}
