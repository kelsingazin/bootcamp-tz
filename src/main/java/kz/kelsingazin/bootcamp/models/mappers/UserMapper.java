package kz.kelsingazin.bootcamp.models.mappers;

import kz.kelsingazin.bootcamp.models.dtos.UserDto;
import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.shared.utils.mappers.AbstractModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper extends AbstractModelMapper<User, UserDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> toEntityList(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
