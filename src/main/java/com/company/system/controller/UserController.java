package com.company.system.controller;

import com.company.system.model.User;
import com.company.system.service.UserService;
import com.company.system.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public Optional<List<User>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{_id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long _id) {
        return ResponseEntity.ok(userService.getById(_id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User _user) {
        _user.setPassword(UserUtil.cryptography(_user.getPassword()));
        return ResponseEntity.ok(userService.save(_user));
    }

    @DeleteMapping("/{_id}")
    public void deleteById(@PathVariable Long _id) {
        userService.deleteById(_id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        userService.deleteAll();
    }

    @PutMapping("/{_id}")
    public ResponseEntity<User> updateUser(@PathVariable Long _id, @RequestBody User _user) {
        _user.setPassword(UserUtil.cryptography(_user.getPassword()));
        return ResponseEntity.ok(userService.updateUser(_id, _user));
    }

    @PatchMapping("/{_id}")
    public ResponseEntity<User> updatePartialUser(@PathVariable Long _id, @RequestBody User _user) {
        _user.setPassword(UserUtil.cryptography(_user.getPassword()));
        return ResponseEntity.ok(userService.updatePartialUser(_id, _user));
    }
}
