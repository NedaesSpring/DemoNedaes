package nedaesSeguridad.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import nedaes.demo.model.Users;
import nedaes.demo.repository.IUsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoWebApplicationTests {

	@Autowired
	private IUsersRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
/*	@Test
	void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setIdUsuario(4);
		us.setNombre("Marta");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
		
		
	}
	*/
	/*@Test
	void crearUsuarioTestFLLISO() {
		Usuario us = new Usuario();
		us.setIdUsuario(4);
		us.setNombre("Raul");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
		
		
	}*/
	@Test
	void crearUsuarioTestConTExto() {
		Users us = new Users();
		us.setId(3);
		us.setUsername("Miguel");
		us.setPassword(encoder.encode("123"));
		us.setEnabled(1);
		Users retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
		
		
	}

}
