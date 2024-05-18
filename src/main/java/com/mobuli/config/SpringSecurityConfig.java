package com.mobuli.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    //authorize.requestMatchers(HttpMethod.POST, "/movie/**").hasRole("ADMIN");
                    // authorize.requestMatchers(HttpMethod.PUT, "/movie/**").hasRole("ADMIN");
                    //authorize.requestMatchers(HttpMethod.DELETE, "/movie/**").hasRole("ADMIN");
                    //authorize.requestMatchers(HttpMethod.GET, "/movie/**").hasRole("ADMIN");
                    //authorize.requestMatchers(HttpMethod.GET, "/movie/**").hasAnyRole("ADMIN", "USER");
                    //authorize.requestMatchers(HttpMethod.PATCH, "/movie/**").hasAnyRole("ADMIN", "USER");
                    authorize.requestMatchers(HttpMethod.GET, "api/movie/**").permitAll();
                    authorize.requestMatchers("api/movie/auth/**").permitAll(); //Allows all roles to access this end point
                    //authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorize.requestMatchers("/api/auth/**").permitAll();
                    authorize.requestMatchers("/api/movie/user/**").permitAll();
                    //authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails haskell = User.builder()
//                .username("kristen")
//                .password(passwordEncoder().encode("Haskell!15"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(haskell, admin);
//    }

}
