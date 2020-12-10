package com.bbtutorials.users.service;


import com.bbtutorials.users.entity.User;
import com.bbtutorials.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public Boolean checkUser(User user) throws UsernameNotFoundException {
        User userDB = userRepository.findByUsername(user.getUsername());
        System.out.println(userDB);
        if (userDB != null)
            return true;
        else return false;
    }


    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }
    }

    public Boolean checkPassword(User user) {
        User userDB = userRepository.findByUsername(user.getUsername());
        return bCryptPasswordEncoder.matches(user.getPassword(), userDB.getPassword());

    }
}
