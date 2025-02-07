package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.User;
import com.EnzoBonatoPersonal.MyLittleLibrary.repositories.UserRepository;
import com.EnzoBonatoPersonal.MyLittleLibrary.exceptions.UserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return userRepository.findByNameIgnoreCase(name)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new UserNotFoundException(name));
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user) {
        return userRepository.findById(id)
            .map(existingUser -> {
                existingUser.setName(user.getName());
                existingUser.setEmail(user.getEmail());
                return ResponseEntity.ok(existingUser);
            })
            .orElseThrow(() -> new UserNotFoundException(id.toString()));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id.toString()));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
