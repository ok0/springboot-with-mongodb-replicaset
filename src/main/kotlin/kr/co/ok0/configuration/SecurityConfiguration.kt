package kr.co.ok0.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = [
  UserDetailsServiceAutoConfiguration::class
])
class SecurityConfiguration: WebSecurityConfigurerAdapter() {
  override fun configure(http: HttpSecurity?) {
    http?.csrf()?.disable()
        ?.headers()?.frameOptions()?.sameOrigin()
        ?.and()
        ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ?.and()
        ?.authorizeRequests()?.anyRequest()?.permitAll()
  }
}