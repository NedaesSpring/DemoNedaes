package nedaes.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nedaes.demo.model.Users;
import nedaes.demo.repository.IUsersRepository;

@Service
public class UsersServiceImpl implements UserDetailsService {

	@Autowired
	private IUsersRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users us= repo.findByUsername(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(us.getUsername(), us.getPassword(), roles);
		
		return userDet;
	}

	
	
//	@Autowired	
//	private IUsersRepo repo;
		
	//	public void registrar(User t) {
			
	//			repo.save(t);
//		}
		
}
