package uz.pdp.flyway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.flyway.dto.CommentCreateDTO;
import uz.pdp.flyway.entity.Comment;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    Comment toEntity(CommentCreateDTO commentCreateDTO);
    CommentCreateDTO toDto(Comment comment);
}
