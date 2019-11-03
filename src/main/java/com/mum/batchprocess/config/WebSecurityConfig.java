package com.mum.batchprocess.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    //认证配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser(
//                        User.withUsername("user")
//                        .password("user")
//                        .roles("USER")
//                )
//                .withUser(
//                        User.withUsername("admin")
//                        .password("admin")
//                        .roles("ADMIN")
//                );

        /**
         * When the schema is the default, match Spring Security doc
         */
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);

        /**
         * If your schema isn't default, override query
         */
        auth.jdbcAuthentication()
                //配置数据源
                .dataSource(dataSource)
                //配置获取User用户名密码信息的语句，返回必须是username, password, enabled
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                //配置获取权限的语句，返回必须是：username，authority
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");

    }


    //授权配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
                //配置角色权限
                .antMatchers("/","/upload/*").hasRole("USER")
                .antMatchers( "/h2-console/**").permitAll()
                .and()
                //配置自定义登录页面
                .formLogin()
                .loginPage("/login")
                //    .defaultSuccessUrl("/upload/")
                .failureUrl("/login?error=true")
                //自定义用户名，密码名称
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
        ;

        //Those two settings below is to enable access h2 database via browser
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //静态资源放通
    @Override
    public void configure(WebSecurity web)  {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
