package com.dh.clinicaOdonto.security;

import com.dh.clinicaOdonto.filter.CustomAuthenticationFilter;
import com.dh.clinicaOdonto.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
//        Caso seja de nosso desejo mudar a url de login
//        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Permissão para qualquer usuário
        http.authorizeRequests().antMatchers("/v2/api-docs/**", "/configuration/ui/**", "/swagger-resources/**", "/configuration/security/**", "/swagger-ui/**", "/webjars/**","/swagger-resources/configuration/ui/**","/swagger-ui.html", "/v3/api-docs/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/usuario/token/refresh").permitAll();
        //Permissão no Usuario Controller
        http.authorizeRequests().antMatchers("/usuario/listar", "/role/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/usuario").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/usuario/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/usuario/**").hasRole("ADMIN");
        //Permissão no Paciente
        http.authorizeRequests().antMatchers(GET,"/dentista").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/dentista/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/dentista/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/dentista/**").hasRole("ADMIN");
        //Permissão no Dentista
        http.authorizeRequests().antMatchers(GET,"/dentista").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/dentista/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/dentista/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/dentista/**").hasRole("ADMIN");
        //Permissão no Endereço
        http.authorizeRequests().antMatchers(POST,"/endereco").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(PUT,"/endereco").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/endereco").hasRole("ADMIN");
        //Permissão na agenda
        http.authorizeRequests().antMatchers(GET,"/agenda").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/agenda").hasRole("ADMIN");
        //Permissão para qualquer outro caminho não supracitados - qualquer usuário autenticado
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
