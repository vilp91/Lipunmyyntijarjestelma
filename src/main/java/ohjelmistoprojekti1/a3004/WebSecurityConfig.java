package ohjelmistoprojekti1.a3004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import ohjelmistoprojekti1.a3004.web.DetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    DetailsService detailsService;

    @SuppressWarnings("deprecation")
    @Bean
    @Profile("dev")
    public SecurityFilterChain securityFilterChainDev(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .anyRequest().authenticated())
                .httpBasic(withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
        return http.build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    @Profile("rahti")
    public SecurityFilterChain securityFilterChainRahti(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                .anyRequest().authenticated())
                .httpBasic(withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
            // "http://localhost:8080",
            "*"
            // "http://127.0.0.1:8080",
            // "http://lipunmyyntijarjestelma-ohjelmistoprojekti-1.rahtiapp.fi"
        ));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder((new BCryptPasswordEncoder()));
    }
}
