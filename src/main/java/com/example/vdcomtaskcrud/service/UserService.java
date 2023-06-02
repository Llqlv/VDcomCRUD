package com.example.vdcomtaskcrud.service;

import com.example.vdcomtaskcrud.entity.User;
import com.example.vdcomtaskcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void save(User user) {
       userRepository.save(user);
    }

    @Transactional
    public void saveAll(List<User> list) {
        userRepository.saveAll(list);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
