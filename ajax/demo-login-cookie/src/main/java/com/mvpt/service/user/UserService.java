package com.mvpt.service.user;

import com.mvpt.model.User;
import com.mvpt.model.dto.UserDTO;
import com.mvpt.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);
}
