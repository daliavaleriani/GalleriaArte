package it.uniroma3.GalleriaArte.security;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


 
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
	    }
	}
	