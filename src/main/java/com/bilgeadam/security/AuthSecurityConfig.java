package com.bilgeadam.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AuthSecurityConfig {


    @Bean
    JwtTokenFilter getJwtTokenFilter(){
        return new JwtTokenFilter();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{


        httpSecurity.csrf().disable();

/*        httpSecurity.authorizeRequests()
               .antMatchers("/personal/**","/swagger-ui/**").permitAll()
                        .anyRequest().authenticated();*/
        httpSecurity.authorizeRequests().antMatchers("/personal/**","swagger-ui/**").permitAll();

        httpSecurity.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //httpSecurity.formLogin();

        return httpSecurity.build();



    }

}
