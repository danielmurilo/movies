package estagio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/search").permitAll()
			.antMatchers("/update/{id}").hasAuthority("ROLE_ADMIN")
			.antMatchers("/delete/{id}").hasAuthority("ROLE_ADMIN")
			.antMatchers("/insert").hasAuthority("ROLE_ADMIN")
			.antMatchers("/save").hasAuthority("ROLE_ADMIN")
			.anyRequest()
			.authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
		.logout()
			.logoutSuccessUrl("/")
			.permitAll()
		.and()
			  .exceptionHandling().accessDeniedPage("/403");
		
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
	  	.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery(
			"select username, password, enabled from app_users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from app_users where username=?");
	}	

}
