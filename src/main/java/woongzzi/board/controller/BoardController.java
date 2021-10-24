package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.service.BoardService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/input")
    public String save() {
        return "/board/input";
    }

    @PostMapping("/input")
    public String save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/detail/{seq}")
    public String detail(@PathVariable("seq") long seq, Model model) {
        BoardDTO boardEntity = boardService.getPost(seq);
        model.addAttribute("boardEntity", boardEntity);
        return "/board/detail";
    }

}
