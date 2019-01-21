package com.packy.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("packy").password("123456").authorities("PRODUCT_ADD", "PRODUCT_LIST");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/product/add")
                .hasAnyAuthority("PRODUCT_ADD")
                .antMatchers("/product/update")
                .hasAnyAuthority("PRODUCT_UPDATE")
                .antMatchers("/product/list")
                .hasAnyAuthority("PRODUCT_LIST")
                .antMatchers("/product/delete")
                .hasAnyAuthority("PRODUCT_DELETE")
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .csrf()
                .disable();
    }
}
