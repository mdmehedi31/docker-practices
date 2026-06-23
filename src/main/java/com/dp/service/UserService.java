package com.dp.service;


import com.dp.entity.UserEntity;
import com.dp.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


   // private UserRepository userRepository;

    public UserService(/*UserRepository userRepository*/) {
     //   this.userRepository = userRepository;

    }


    public UserEntity save(UserEntity user) {
      //  return userRepository.save(user);
        return user;
    }

    public List<UserEntity> findAll() {
     //   return userRepository.findAll();
        return new ArrayList<UserEntity>();
    }

    public UserEntity findById(int id) {
     //   return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : new UserEntity();
        return new UserEntity();
    }


}
