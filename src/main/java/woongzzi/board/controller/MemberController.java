package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import woongzzi.board.DTO.MemberDTO;
import woongzzi.board.service.MemberService;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    //로그인 페이지
    @GetMapping("/")
    public String login() {
        return "/member/login";
    }

    //회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "/member/register";
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        memberService.joinUser(memberDTO);
        return "redirect:/board/list";
    }

    //비밀번호 분실 페이지
    @GetMapping("/forgot-password")
    public String forgetRegister() {
        return "/member/forgot-password";
    }
}
