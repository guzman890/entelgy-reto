package com.entelgy.reto.model.mapper;

import com.entelgy.reto.model.dto.CommentDTO;
import com.entelgy.reto.model.entidad.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mappings(
        {
            @Mapping(source="postId", target = "postId" ),
            @Mapping(source="id", target = "id" ),
            @Mapping(source="email", target = "email" ),
        }
    )
    CommentDTO toCommentDTO(Comment comment);
    List<CommentDTO> toCommentDTOs(List<Comment> comments);
}
