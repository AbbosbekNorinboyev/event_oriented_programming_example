package uz.pdp.flyway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.flyway.dto.UserCreateDTO;
import uz.pdp.flyway.entity.Users;
import uz.pdp.flyway.repository.UsersRepository;
import uz.pdp.flyway.service.UsersService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UsersRepository usersRepository;
    private final UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.status(201).body(usersService.createUser(userCreateDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(usersService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUserAll() {
        return ResponseEntity.ok(usersService.getUserAll());
    }

    @PutMapping
    public ResponseEntity<Void> deleteUser(@RequestBody Users updatingUser) {
        Users user = usersRepository.findById(updatingUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found: " + updatingUser.getId()));
        if (updatingUser.getName() != null) {
            user.setName(updatingUser.getName());
        }
        if (updatingUser.getAge() != null) {
            user.setAge(updatingUser.getAge());
        }
        if (updatingUser.getOtp() != null) {
            user.setOtp(updatingUser.getOtp());
        }
        usersService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
