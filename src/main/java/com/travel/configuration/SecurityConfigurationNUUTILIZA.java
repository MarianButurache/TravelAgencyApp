/*package com.travel.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurationNUUTILIZA extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/hotels", "/trip")
               // .antMatchers("/tripPurchase") nu am ruta momentan
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/trip/{id}")
                .antMatchers(HttpMethod.PUT, "/trip")
                .antMatchers(HttpMethod.POST, "/trip")
                .antMatchers(HttpMethod.DELETE, "/hotels/{id}")
                .antMatchers(HttpMethod.PUT, "/hotels")
                .antMatchers(HttpMethod.POST, "/hotels")
               // .antMatchers(HttpMethod.DELETE, "/tripPurchase/{id}")
               // .antMatchers(HttpMethod.PUT, "/tripPurchase")
               // .antMatchers(HttpMethod.POST, "/tripPurchase")
                .hasAnyAuthority("ADMIN")
                .and()
                .httpBasic();
    }
}*/
