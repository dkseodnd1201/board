package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class BoardController {

    @GetMapping("/list")
    public String main() {
        return "/board/list";
    }

    @GetMapping ("/")
    public String test(){
        return "test";
    }

}
