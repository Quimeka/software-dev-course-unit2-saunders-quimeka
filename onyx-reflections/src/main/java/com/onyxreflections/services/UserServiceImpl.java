package com.onyxreflections.services;

import com.onyxreflections.dto.UserDTO;
import com.onyxreflections.exceptions.ItemAlreadyExistsException;
import com.onyxreflections.model.User;
import com.onyxreflections.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, PasswordEncoder encoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new ItemAlreadyExistsException("Profile already exists for " + userDTO.getEmail());
        }
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        User user = mapToUserEntity(userDTO);

        //Updated to set default theme and font
        if (user.getTheme() == null || user.getTheme().isBlank()) {
            user.setTheme("default");
        }
        if (user.getFont() == null || user.getFont().isBlank()) {
            user.setFont("Georgia");
        }
        user = userRepository.save(user);

        return mapToUserDTO(user);
    }
    // Map values from entity to DTO
    private UserDTO mapToUserDTO(User userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    // Map values from DTO to entity
    private User mapToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
