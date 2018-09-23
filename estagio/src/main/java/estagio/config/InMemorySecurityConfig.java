package estagio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//class used for login tests
//@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		builder.inMemoryAuthentication()
		.withUser("admin").password("123").roles("ADMIN")
		.and()
		.withUser("user").password("123").roles("USER");
		
	}

}
