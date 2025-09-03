package com.sea.service.impl;

import com.sea.dto.UserDTO;
import com.sea.exception.ResourceNotFoundException;
import com.sea.model.User;
import com.sea.repository.UserRepository;
import com.sea.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository users;

    public UserServiceImpl(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User u = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();
        u = users.save(u);
        return toDTO(u, false);
    }

    @Override
    public UserDTO getById(Long id) {
        User u = users.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return toDTO(u, false);
    }

    @Override
    public List<UserDTO> getAll() {
        return users.findAll().stream()
                .map(u -> toDTO(u, false))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User u = users.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        if (dto.getEmail() != null) u.setEmail(dto.getEmail());
        if (dto.getName() != null) u.setName(dto.getName());
        if (dto.getPassword() != null) u.setPassword(dto.getPassword());
        return toDTO(users.save(u), false);
    }

    @Override
    public void delete(Long id) {
        if (!users.existsById(id)) throw new ResourceNotFoundException("User not found: " + id);
        users.deleteById(id);
    }

    private UserDTO toDTO(User u, boolean includePassword) {
        return UserDTO.builder()
                .id(u.getId())
                .email(u.getEmail())
                .name(u.getName())
                .password(includePassword ? u.getPassword() : null)
                .build();
    }
}
