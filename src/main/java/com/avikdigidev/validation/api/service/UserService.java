package com.avikdigidev.validation.api.service;

import com.avikdigidev.validation.api.entity.User;
import com.avikdigidev.validation.api.dto.UserRequest;
import com.avikdigidev.validation.api.exception.UserNotFoundException;
import com.avikdigidev.validation.api.repository.UserRepository;
import com.avikdigidev.validation.api.utils.ValidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }


    public List<User> getALlUsers() {
        return repository.findAll();
    }


    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException(ValidUtils.SV001, ValidUtils.SV001_MESSAGE);
        }
    }
}
