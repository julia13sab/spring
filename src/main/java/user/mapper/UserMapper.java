package user.mapper;

import org.mapstruct.Mapper;
import user.dto.UserDTO;
import user.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(UserEntity userEntity);

    UserEntity toEntity(UserDTO userDTO);
}
