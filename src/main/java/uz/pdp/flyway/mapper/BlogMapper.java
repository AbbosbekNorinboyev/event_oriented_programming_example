package uz.pdp.flyway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.flyway.dto.BlogCreateDTO;
import uz.pdp.flyway.entity.Blog;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BlogMapper {
    Blog toEntity(BlogCreateDTO blogCreateDTO);
    BlogCreateDTO toDto(Blog blog);
}
