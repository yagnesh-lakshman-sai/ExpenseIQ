package com.sea.service;

import java.util.List;
import com.sea.dto.UserDTO;

public interface UserService {
	UserDTO create(UserDTO dto);
	UserDTO getById(Long id);
	List<UserDTO> getAll();
	UserDTO update(Long id ,UserDTO dto);
	void delete(Long id);
}
