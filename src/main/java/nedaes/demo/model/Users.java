package nedaes.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Users {
	
	@Id
	private Integer id;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private String enabled;
	
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public Integer getId() {
		return id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setClave(String password) {
		this.password = password;
	}
	public void setEnabled(int i) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
