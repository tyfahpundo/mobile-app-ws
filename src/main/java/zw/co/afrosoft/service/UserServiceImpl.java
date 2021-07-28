package zw.co.afrosoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.dto.UserDto;
import zw.co.afrosoft.model.User;
import zw.co.afrosoft.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        user.setEncryptedPassword("test");
        user.setUserId("testUserID");

        User storedUser = repo.save(user);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }
}
