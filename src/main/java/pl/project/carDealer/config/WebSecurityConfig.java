package pl.project.carDealer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.project.carDealer.Services.UserDetailsServiceImp;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()//wyłączone zabezpieczenie csrf https://pl.wikipedia.org/wiki/Cross-site_request_forgery
                .authorizeRequests() //autoryzuj żądania wg następujacych reguł:
                .antMatchers("/css/**", "/js/**").permitAll() //dla requestóww /css/**", "/js/**" pozwalaj wszystkim bez wyjątku
                .anyRequest().authenticated()// wymagaj by wszystkie żądania były poddane autentykacji
                .and() // i...
                .formLogin() //
                .loginPage("/user/login").permitAll() //wyświetl formę logowania pod adresem /user/login
                .and().logout().logoutUrl("user/logout").permitAll();

    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());


    }


}
