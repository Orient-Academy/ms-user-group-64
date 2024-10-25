package az.edu.orient.msusergroup64.mapper;

import az.edu.orient.msusergroup64.entity.UserEntity;
import az.edu.orient.msusergroup64.request.UserCreateRequest;
import az.edu.orient.msusergroup64.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserCreateRequest request);

    UserResponse toResponse(UserEntity entity);

    void updateEntityFromRequest(@MappingTarget UserEntity entity, UserCreateRequest request);
    List<UserResponse> toResponseList(List<UserEntity> userEntityList);
}
