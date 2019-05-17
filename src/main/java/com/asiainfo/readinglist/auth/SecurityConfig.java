package com.asiainfo.readinglist.auth;

import com.asiainfo.readinglist.dao.ReaderRepository;
import com.asiainfo.readinglist.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            //.antMatchers("/*").access("hasRole('READER')")
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").access("hasRole('READER')")
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .failureUrl("/error");

        http.authorizeRequests()
                .antMatchers("/**", "/index.html").permitAll()
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin()
                .loginPage("/login.html")   //  登录页
                .failureUrl("/login-error.html").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }

    //@Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(new MyUserDetailsService());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
