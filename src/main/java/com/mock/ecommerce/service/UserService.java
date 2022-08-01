package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.User;
import com.mock.ecommerce.entity.UserDetail;
import com.mock.ecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * author CuongTTC
 *
 * */

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("USer " + username + "not found!!" );
        }

        return new UserDetail(user);
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }


    public void processUserOAuth(String email, String username){
        int existUser = userRepo.countByEmail(email);

        if (existUser == 0 ){
            User newUser = new User();
            newUser.setRole("ROLE_USER");
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setEnabled(true);
            userRepo.save(newUser);
        }
    }
}
