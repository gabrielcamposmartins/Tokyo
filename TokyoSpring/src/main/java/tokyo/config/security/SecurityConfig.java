package tokyo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests(requests -> requests
                        .antMatchers("/h2-console/**").permitAll()
                        .antMatchers("/conta/**").permitAll()
                        .antMatchers("/test/**").permitAll()
                        .anyRequest().permitAll());
        return http.build();
    }
}
