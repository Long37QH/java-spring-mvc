package vn.hoidanit.laptopshop.service;

import java.util.List;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    

    public UserService(UserRepository userRepository,RoleRepository roleRepository,ProductRepository productRepository,OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public User handlSaveUser(User user){
        User usernew = this.userRepository.save(user);
        System.out.println(usernew);
        return usernew ;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public List<User> getAllByEmail(String email){
        return this.userRepository.findOneByEmail(email);
    }

    public User getUserById(long id){
        return this.userRepository.findById(id);
    }

    public void deleteUser(long id){
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name){
        return this.roleRepository.findByName(name);
    }

    // mapper tu RegisterDTO -> User

    public User registerDTOtoUser(RegisterDTO registerDTO){
        User user = new User();
        user.setFullName(registerDTO.getFirstName()+" "+registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }

    public boolean checkEmailExist(String email){
        return this.userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public long coutUsers(){
        return this.userRepository.count() ;
    }
    public long coutProducts(){
        return this.productRepository.count() ;
    }
    public long coutOrders(){
        return this.orderRepository.count() ;
    }
}
