package SecurityConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
		@Autowired
		LoginSuccessHandler successHandler;
		@Autowired
		private CustomUserDetailsService userDetailsService;
	   @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		   http.userDetailsService(userDetailsService);
	    	 CorsConfiguration corsConfiguration = new CorsConfiguration();
	         corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
	         corsConfiguration.setAllowedOrigins(List.of("*"));
	         corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
	         corsConfiguration.setAllowCredentials(true);
	         corsConfiguration.setExposedHeaders(List.of("Authorization"));

	         http.csrf().disable().cors().configurationSource(request -> corsConfiguration);
	         http
	       .authorizeRequests(authorizeRequests -> 
	           authorizeRequests
	      
	               .requestMatchers("/login","/register", "/WEB-INF/jsp/**","/css/**", "/js/**", "/img/**").permitAll()
	               .requestMatchers("/admin/**").hasAuthority("ADMIN")
	               .requestMatchers("/**").hasAuthority("USER")
	               .anyRequest().authenticated()
	       )
	       .formLogin(formLogin -> 
	           {
				try {
					formLogin
					   .loginPage("/login").permitAll()
					   .successHandler(successHandler)
					   
					   .and().logout().permitAll()
					   .and().exceptionHandling().accessDeniedPage("/error/403");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	       )
	       
	      ;
	         
			return http.build();
	    }
	   
		@Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	String passwordToEncode = "123456";
	        
	        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(passwordToEncode);
	        
	        System.out.println("Mật khẩu đã mã hóa: " + encodedPassword);
	        return new BCryptPasswordEncoder();
	    }
		
		
		
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	    
	    @Bean
	    public AuthenticationManager customAuthenticationManager(HttpSecurity http) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .authenticationProvider(authenticationProvider())
	            .build();
	    }
	    

}
