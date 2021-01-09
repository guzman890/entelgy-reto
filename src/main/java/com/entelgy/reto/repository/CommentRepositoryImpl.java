package com.entelgy.reto.repository;

import com.entelgy.reto.constants.Constants;
import com.entelgy.reto.model.entidad.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Comment> getCommets() {
        try {
            URI uri =  new URI(Constants.RESOURCE_URL_COMMENTS);
            RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
            ResponseEntity<Comment[]> response = restTemplate.exchange(requestEntity, Comment[].class);
            List<Comment> listComment= Arrays.asList(response.getBody());
            return listComment;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
