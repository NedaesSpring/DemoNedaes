package nedaes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nedaes.demo.model.Users;



public interface IUsersRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);
}
