package nedaes.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nedaes.demo.serviceImp.UsersServiceImpl;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//		@Autowired
		//private UsuarioServiceImpl userDetailsService;
		
		@Autowired 
		private BCryptPasswordEncoder bcrypt;
		
		@Autowired
		private DataSource dataSource;
		
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}
		
		@Autowired
		public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
			builder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(bcrypt)
			.usersByUsernameQuery("Select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("Select u.username, r.rol from roles r inner join users u on r.id_usuario = u.id where u.username=?");		
		}
		 
		
		
/*		@Override
		protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
				auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
		}
	*/	
		
		@Override
		protected void configure(HttpSecurity http)	throws Exception {
			http.authorizeRequests().antMatchers("/css/**","/js/**","/img/**","/fonts/**","/error/403","/403","/xls/**","/xml/**").permitAll()
			// con hasAnyRole("ADMIN") permito solo a este rol ver ese getmapping
			// si no esta en este listado se podra ver independientemente del rol, porque al final pone que si estas autenticado se puedan ver el resto de paginas
			// El campo ROL en BBDD tiene que ser ROLE_xxxxx   y aqui se puede utilizar ROLE_xxxx o xxxx ; como se quiera
			// ** es comodin a lo que sea despues
			.antMatchers("/perceptores").hasAnyRole("ADMIN")
			.antMatchers("/listarPerceptores/**").hasAnyRole("ADMIN")
			.antMatchers("/inicioPerceptor/**").hasAnyRole("ADMIN")
			.antMatchers("/listarPerceptoresProvincia").hasAnyRole("ADMIN")
			.antMatchers("/consultaPerceptor**").hasAnyRole("ADMIN")
			.antMatchers("/consultaTodosPerceptores").hasAnyRole("ADMIN")
			.antMatchers("/perceptor").hasAnyRole("ADMIN")
			.antMatchers("/insertarModificarPerceptor").hasAnyRole("ADMIN")			
			.antMatchers("/borrarPerceptor").hasAnyRole("ADMIN")
			.antMatchers("/editarPerceptor").hasAnyRole("ADMIN")
			.antMatchers("/visualizarPerceptor").hasAnyRole("ADMIN")
			.antMatchers("/exportPerceptor").hasAnyRole("ADMIN")
			.antMatchers("/habilitaciones").hasAnyRole("ADMIN")
			.antMatchers("/inicioHabilitacion/**").hasAnyRole("ADMIN")
			.antMatchers("/consultaHabilitacion**").hasAnyRole("ADMIN")
			.antMatchers("/consultaTodasHabilitaciones").hasAnyRole("ADMIN")
			.antMatchers("/habilitacion").hasAnyRole("ADMIN")
			.antMatchers("/insertarModificarHabilitacion**").hasAnyRole("ADMIN")			
			.antMatchers("/borrarHabilitacion").hasAnyRole("ADMIN")
			.antMatchers("/editarHabilitacion**").hasAnyRole("ADMIN")
			.antMatchers("/visualizarHabilitacion").hasAnyRole("ADMIN")
			.antMatchers("/exportHabilitacion").hasAnyRole("ADMIN")
			.antMatchers("/editarHabilitacionPersonal").hasAnyRole("ADMIN")
			.antMatchers("/editarHabilitacionBancaria").hasAnyRole("ADMIN")
			.antMatchers("/editarHabilitacionMutua").hasAnyRole("ADMIN")
			.antMatchers("/insertarModificarHabilitacionPersonal").hasAnyRole("ADMIN")
			.antMatchers("/insertarModificarHabilitacionBancaria").hasAnyRole("ADMIN")
			.antMatchers("/insertarModificarHabilitacionMutua").hasAnyRole("ADMIN")
			.antMatchers("/ListarLocalidProvinc").hasAnyRole("ADMIN")
			.antMatchers("/ListarSucurbaBanco").hasAnyRole("ADMIN")
			.antMatchers("/ListarLocalidProvincEdit").hasAnyRole("ADMIN")
			.antMatchers("/ListarSucurbaBancoEdit").hasAnyRole("ADMIN")
			.antMatchers("/ListarLocalidProvincPersonalEdit").hasAnyRole("ADMIN")			
			.antMatchers("/ListarSucurbaBancoPersonalEdit").hasAnyRole("ADMIN")
			.antMatchers("/ListarSucurbaBancoBancariaEdit").hasAnyRole("ADMIN")
			.antMatchers("/Informes").hasAnyRole("ADMIN")
			.antMatchers("/InformesMasivo").hasAnyRole("ADMIN")
			.antMatchers("/consultaCambioDni/**").hasAnyRole("ADMIN")
			.antMatchers("/cambioDnis").hasAnyRole("ADMIN")
			
			
			// Asi se puede permitir varios roles a un getMapoing
			.antMatchers("/listarProvincias").hasAnyAuthority("ROLE_USUARIO","ROLE_ADMIN")
			
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().logoutSuccessUrl("/login?logout=true").permitAll();
		}

}
