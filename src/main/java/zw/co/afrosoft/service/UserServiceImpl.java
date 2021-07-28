package zw.co.afrosoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.dto.UserDto;
import zw.co.afrosoft.model.User;
import zw.co.afrosoft.persistence.UserRepository;
import zw.co.afrosoft.utilities.Utils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        if(repo.findUserByEmail(userDto.getEmail()) != null) throw new RuntimeException("User Already Exist");

        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        String publicUserId = utils.generateUserId(30);
        user.setUserId(publicUserId);

        user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        User storedUser = repo.save(user);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
