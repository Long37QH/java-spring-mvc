package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handlSaveUser(User user){
        User usernew = this.userRepository.save(user);
        System.out.println(usernew);
        return usernew ;
    }
}
