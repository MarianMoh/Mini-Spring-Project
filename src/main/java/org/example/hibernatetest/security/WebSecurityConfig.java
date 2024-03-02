//package org.example.hibernatetest.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////    @Autowired
////    private WebAuthenticationProvider authenticationProvider;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                .loginPage("/login-form")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login-form?error=true")
//                .permitAll()
//                    .and()
//                .logout()
//                .logoutUrl("/perform-logout")
//                .logoutSuccessUrl("/login-form")
//                .deleteCookies("JSESSIONID")
//                .permitAll();
//    }
//
////    @Bean
////    public DataSource dataSource() {
////        return DataSourceBuilder
////                .create()
////                .driverClassName("org.postgresql.Driver")
////                .url("jdbc:postgresql://localhost:5432/todolist")
////                .username("postgres")
////                .password("2205")
////                .build();
////    }
////
////    /**
////     * З початку презентації
////     */
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
////        auth.jdbcAuthentication().dataSource(dataSource);
////    }
//
////    /**
////     * З середини презентації
////     */
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService)
////            throws Exception {
////        auth.userDetailsService(userDetailsService);
////    }
//
//    /**
//     * З попереднього проекту і з кінця презентації
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider provider) throws Exception {
//        auth.authenticationProvider(provider);
//    }
//
////    @Autowired
////    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider); // Встановлюємо наш власний провайдер автентифікації
////    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
