package uz.pdp.flyway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import uz.pdp.flyway.dto.UserCreateDTO;
import uz.pdp.flyway.entity.Users;
import uz.pdp.flyway.events.OtpGenerateEvent;
import uz.pdp.flyway.mapper.UsersMapper;
import uz.pdp.flyway.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    public Users createUser(UserCreateDTO userCreateDTO) {
        Users user = usersMapper.toEntity(userCreateDTO);
        usersRepository.save(user);
        publisher.publishEvent(new OtpGenerateEvent(user));
        return user;
    }

    @Override
    public Users getUser(Integer id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Override
    public List<Users> getUserAll() {
        return usersRepository.findAll();
    }

    @Override
    public void updateUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }
}
