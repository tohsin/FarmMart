package com.farmmart.security.securityconfig;


import com.farmmart.jwt.JwtTokenVerifier;
import com.farmmart.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.farmmart.service.appuser.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AppUserDetailService userDetailService;

    private final PasswordEncoder passwordEncode;

    @Autowired
    public SecurityConfiguration(AppUserDetailService userDetailService, PasswordEncoder passwordEncode) {
        this.userDetailService = userDetailService;
        this.passwordEncode = passwordEncode;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService).passwordEncoder(passwordEncode);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtUsernameAndPasswordAuthenticationFilter jwtUsernameAndPasswordAuthenticationFilter=
                new JwtUsernameAndPasswordAuthenticationFilter(authenticationManagerBean());

        jwtUsernameAndPasswordAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/", "/api/login/**", "/api/appUser/registerUser/**",
                        "/api/appUser//updateUserById/**", "api/address/saveAddress", "api/address/updateAddressById/**",
                        "/api/customer/registerCustomer/**","/api/vendor/registerVendor/**","/api/product/findProductByName/**",
                        "/api/product/findProductByType/**","/api/product/findProductByBrand/**",
                        "/api/product/findProductByPriceLessThan/**","/api/product/findProductByPriceGreaterThan/**",
                        "api/product/findProductByPriceRange/**","/api/product/findProductByPartNumber/**",
                        "/api/product/findProductByCategory/**","/api/product/findProductByVendor/**",
                        "/api/service/findServiceByName/**", "/api/service/findAllServices/**","/api/service/findServiceByCategory/**",
                        "/api/service/findServiceByVendor/**","/api/product/findAllProducts/**","/hello", "/index", "/css/*","/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(jwtUsernameAndPasswordAuthenticationFilter)
                .addFilterBefore(new JwtTokenVerifier(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }
}
