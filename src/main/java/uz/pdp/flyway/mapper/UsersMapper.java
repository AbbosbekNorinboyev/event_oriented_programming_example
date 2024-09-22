package uz.pdp.flyway.mapper;

import org.mapstruct.*;
import uz.pdp.flyway.dto.UserCreateDTO;
import uz.pdp.flyway.entity.Users;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {
    Users toEntity(UserCreateDTO userCreateDTO);

    UserCreateDTO toDto(Users users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Users partialUpdate(UserCreateDTO userCreateDTO, @MappingTarget Users users);
}