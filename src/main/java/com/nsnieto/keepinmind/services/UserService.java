package com.nsnieto.keepinmind.services;

import com.nsnieto.keepinmind.entities.User;
import com.nsnieto.keepinmind.exception.DuplicatedUser;
import com.nsnieto.keepinmind.exception.ValueNotFound;
import com.nsnieto.keepinmind.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) throws RuntimeException {

        if (userRepository.findByNickName(user.getNickName()).isPresent()) {
            throw new DuplicatedUser();
        }

        return userRepository.save(user);

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserByNickName(String nickName) throws Exception {
        return userRepository.findByNickName(nickName)
                .orElseThrow(() -> new ValueNotFound("User  " + nickName));

    }

}
