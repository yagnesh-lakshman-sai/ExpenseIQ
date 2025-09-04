package com.sea.service;

import com.sea.dto.UserDTO;
import com.sea.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
