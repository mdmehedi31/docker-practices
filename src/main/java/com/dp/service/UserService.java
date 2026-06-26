package com.dp.service;


import com.dp.entity.UserEntity;
import com.dp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {



    @Value("${app.file.path}")
    private String filePath;

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

    public String addName(String name) throws IOException {

        File file = new File(filePath);

        // create directory if not exists
        file.getParentFile().mkdirs();

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(name + System.lineSeparator());
        }

        return "Name saved successfully";
    }


    public List<String> getNames() throws IOException {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            return List.of();
        }

        return Files.readAllLines(path);
    }

}
