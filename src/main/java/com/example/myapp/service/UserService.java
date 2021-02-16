package com.example.myapp.service;
import com.example.myapp.Entity.User;
import com.example.myapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUserService(){
        List<User> report = userRepository.getAllUser();
        return report;
    }

    public boolean addUserService(User user){
        boolean returnvalue = userRepository.addUser(user);
        return returnvalue;
    }
//    public List<User> selectParticular(String company_code){
//        List<User> report = userRepository.mergeUserComCode(company_code);
//        return report;
//    }

    public User getCompanyByCodeService(String company_code){
        User result = userRepository.getCompanyByCode(company_code);
        return result;
    }

    public boolean updateUser(User user){
        return userRepository.updateUser(user);
    }

    public boolean deleteUserService(String code){
        return userRepository.deleteUser(code);
    }

}
