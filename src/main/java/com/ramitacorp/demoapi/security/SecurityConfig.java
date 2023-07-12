//package com.ramitacorp.demoapi.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT id, psw, active FROM teacher WHERE id=?");
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT id_teacher, role FROM roles WHERE id_teacher=?");
//
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/hello").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/**").hasAnyRole("MANAGER","ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("MANAGER","ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
//        );
//        http.httpBasic();
//
//        // disable Cross Site Request Forgery (CSRF)
//        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
//        http.csrf().disable();
//
//        return http.build();
//    }
//}
