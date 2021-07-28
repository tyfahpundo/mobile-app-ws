package zw.co.afrosoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import zw.co.afrosoft.dto.UserDto;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}
