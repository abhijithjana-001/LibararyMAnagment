//package com.example.LibraryManagement.security;
//
//import com.example.LibraryManagement.security.jwt.JwtAuthFilter;
//import com.example.LibraryManagement.security.jwt.JwtAuthenticationEntryPoint;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class securityconfig {
////@Autowired
////    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
////@Autowired
////private JwtAuthFilter jwtAuthFilter;
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////    return http.csrf(csrf -> csrf.disable())
////            .authorizeHttpRequests(request->
////                    request.requestMatchers("/api/**").permitAll()
////
//////
//////                            .requestMatchers("/api/test","/api/addbook","/api/update/**","/api/delete/**").hasRole("ADMIN")
//////                            .anyRequest().authenticated()
////            )
////            .exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
////            .sessionManagement(sesssion->sesssion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////            .build();
////}
////
//}
//
