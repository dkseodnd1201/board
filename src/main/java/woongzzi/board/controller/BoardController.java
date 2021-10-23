package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.service.BoardService;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/board/list")
    public String boardlist(Model model) {
        List<BoardDTO> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/board/input")
    public String boardSave() {
        return "/board/input";
    }

    @PostMapping("/board/input")
    public String boardSave(BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "redirect:/board/list";
    }
}
