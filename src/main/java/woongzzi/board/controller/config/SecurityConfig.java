package woongzzi.board.controller.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import woongzzi.board.service.MemberService;

@Configuration
@EnableWebSecurity //Spring Security 설정할 클래스 정의
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter { //WebSecurityConfigurer 인스턴스를 편리하게 생성하기 위한 클래스
    private MemberService memberService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //Spring Security에서 제공하는 비밀번호 암호화 객체
    }

    // 이하 configure() 는 security 설정
    @Override
    public void configure(WebSecurity web) throws Exception //WebSecurity : FilterChainProxy를 생성하는 필터
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        // resource/static 기준
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //HttpSecurity를 통해 HTTP 요청에 대한 웹 기반 보안을 구성
        http.authorizeRequests() //HttpServletRequest에 따라 접근(access)을 제한
//                 페이지 권한 설정 왼쪽 uri는 지정된 Role만 접근 가능
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/myinfo").hasRole("MEMBER")
                .antMatchers("/").permitAll()
                //.anyRequest().authenticated() 인증된 사용자만 접근 가능
                .and() // 로그인 설정
                .formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/board/list")
                .usernameParameter("id")
                .passwordParameter("password")
                .permitAll()
                .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/logout/result")
                .invalidateHttpSession(true)
                .and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}