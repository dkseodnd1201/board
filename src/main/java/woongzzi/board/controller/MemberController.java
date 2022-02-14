package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import woongzzi.board.DTO.MemberDTO;
import woongzzi.board.service.MemberService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
    private MemberService memberService;
    //로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    //회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "/member/register";
    }

    //회원가입 처리
    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        memberService.joinUser(memberDTO);
        return "redirect:/member/login";
    }

    //비밀번호 분실 페이지
    @GetMapping("/forgot-password")
    public String forgetRegister() {
        return "/member/forgot-password";
    }
}
