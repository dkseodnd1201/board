package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.service.BoardService;

import java.util.List;


@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> boardList = boardService.findMember();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }



}
