//package woongzzi.board.controller.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import woongzzi.board.service.MemberService;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private MemberService memberService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); //Spring Security에서 제공하는 비밀번호 암호화 객체
//    }
//
//    // 이하 configure() 는 security 설정
//    @Override
//    public void configure(WebSecurity web) throws Exception //WebSecurity : FilterChainProxy를 생성하는 필터
//    {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 페이지 권한 설정
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/myinfo").hasRole("MEMBER")
//                .antMatchers("/**").permitAll()
//                .and() // 로그인 설정
//                .formLogin()
//                .loginPage("/user/login")
//                .defaultSuccessUrl("/user/login/result")
//                .permitAll()
//                .and() // 로그아웃 설정
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .logoutSuccessUrl("/user/logout/result")
//                .invalidateHttpSession(true)
//                .and()
//                // 403 예외처리 핸들링
//                .exceptionHandling().accessDeniedPage("/user/denied");
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
//}