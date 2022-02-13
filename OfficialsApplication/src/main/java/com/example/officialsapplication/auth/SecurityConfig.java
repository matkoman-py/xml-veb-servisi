package com.example.officialsapplication.auth;

import com.example.officialsapplication.services.UserAuthService;
import com.example.officialsapplication.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public SecurityConfig(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

//    @Override
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and();

//        http = http.exceptionHandling()
//                .authenticationEntryPoint((req, res, ex) -> {
//                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
//                }).and();

        http.authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/employee/**").permitAll()
                .antMatchers("/api/article/**").permitAll()
                .antMatchers("/api/menu/**").permitAll()
                .antMatchers("/api/order/**").permitAll()
                .antMatchers("/api/ingredient").permitAll()
                .antMatchers("/api/privilegedUser/**").permitAll().and().httpBasic().and()
//                .anyRequest().authenticated().and().formLogin().loginProcessingUrl("/api/auth/loging").and()

                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, userAuthService), BasicAuthenticationFilter.class);
        http.cors().and().csrf().disable();

    }

}
