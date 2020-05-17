package com.application.aled.configWebSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // La méthode configure() permet de préciser les règles d’accès aux différentes URI de l’application ainsi que la configuration générale de Spring Security.
    // Chaque règle est appliquée à partir de l’objet HttpSecurity passé en paramètre de la méthode.
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //les filtres

        // @formatter:off
        http
                .cors()
                .and()
                .headers()
                .frameOptions().disable()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/stomp").permitAll()
                .anyRequest()
                .permitAll();
        // @formatter:on
    }

        /**
         * Apply CORS configuration before Spring Security.
         * By default, "http.cors" take a bean called corsConfigurationSource.
         * @implNote https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#cors
         * @return a CORS configuration source.
         **/
        @Bean
        public CorsConfigurationSource corsConfigurationSource() {

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.addAllowedOrigin("*");
            config.addAllowedHeader("*");
            config.addAllowedMethod("*");
            //source.registerCorsConfiguration("/**", config);

            //Par défaut, une CorsConfiguration nouvellement créée ne permet aucune demande d'origine croisée
            // et doit être configurée explicitement pour indiquer ce qui doit être autorisé.
            source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

            return source;

        }

    }

