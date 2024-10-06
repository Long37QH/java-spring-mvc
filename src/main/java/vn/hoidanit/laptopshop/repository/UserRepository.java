package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // ham save data = insert into user values ()
    User save(User usernew); 

    List<User> findByEmail(String email);

    List<User> findAll();

    User findById(long id);
}
