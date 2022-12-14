/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Seguridad;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduwin Tibata
 */
@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests(a -> a
               .antMatchers("/", "/index.html","/categorias.html","/clientes.html","/disfraz.html","/mensajes.html","/reservas.html","/error", "/webjars/**",
                       "/api/**", "/css/**", "/js/**").permitAll()
               .anyRequest().authenticated()
       ).exceptionHandling(e -> e
               .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
       ).oauth2Login().defaultSuccessUrl("/categorias.html", true);
       
       http.cors().and().csrf().disable();
   } 
}
