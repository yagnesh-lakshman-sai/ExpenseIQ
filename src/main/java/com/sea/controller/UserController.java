package com.sea.controller;

import com.sea.dto.UserDTO;
import com.sea.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService users;

    public UserController(UserService users) {
        this.users = users;
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto) {
        return users.create(dto);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable Long id) {
        return users.getById(id);
    }

    @GetMapping
    public List<UserDTO> list() {
        return users.getAll();
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO dto) {
        return users.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        users.delete(id);
    }
}
