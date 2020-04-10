package csi.master.gestion_des_formations.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
	
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().
//        disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//            .antMatchers("/user/registration").permitAll()
//            .anyRequest() 
//            .authenticated()
//            .and()
//            .httpBasic();
        
        http.authorizeRequests()
        .antMatchers("/oauth_login","/user/loginFailure","/user/registrationOauth","/user/loginOauth","/user/registration").permitAll()
        //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .antMatchers("/user/registration").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login()
        .loginPage("/oauth_login")
        .authorizationEndpoint()
        .baseUri("/oauth2/authorize-client")
        .authorizationRequestRepository(authorizationRequestRepository())
        .and()
        .tokenEndpoint()
        .accessTokenResponseClient(accessTokenResponseClient())
        .and()
        .defaultSuccessUrl("/user/loginOauth")
        .failureUrl("/user/loginFailure");

    }

    

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository() {
	        return new HttpSessionOAuth2AuthorizationRequestRepository();
	    }
	    
    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        return accessTokenResponseClient;
    }

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

}
