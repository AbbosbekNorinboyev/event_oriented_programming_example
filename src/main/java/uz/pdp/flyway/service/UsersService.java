package uz.pdp.flyway.service;

import uz.pdp.flyway.dto.UserCreateDTO;
import uz.pdp.flyway.entity.Users;

import java.util.List;

public interface UsersService {
    Users createUser(UserCreateDTO userCreateDTO);

    Users getUser(Integer id);

    List<Users> getUserAll();

    void updateUser(Users user);

    void deleteUser(Integer id);
}
