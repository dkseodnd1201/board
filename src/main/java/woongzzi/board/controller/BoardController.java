package woongzzi.board.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.service.BoardService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/board")
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
        boardService.savePost(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/detail/{seq}")
    public String detail(@PathVariable("seq") long seq, Model model) {
        BoardDTO boardEntity = boardService.getPost(seq);
        model.addAttribute("boardEntity", boardEntity);
        return "/board/detail";
    }

    @GetMapping("/detail/edit/{seq}")
    public String edit(@PathVariable("seq") long seq, Model model) {
        BoardDTO boardEntity = boardService.getPost(seq);
        model.addAttribute("boardEntity", boardEntity);
        return "/board/update";
    }

    @PutMapping("/detail/edit/{seq}")
    public String update(BoardDTO boardEntity) {
        boardService.savePost(boardEntity);
        return "redirect:/board/list";
    }

    @DeleteMapping("/detail/{seq}")
    public String delete(@PathVariable("seq") long seq) {
        boardService.deletePost(seq);
        return "redirect:/board/list";
    }
}
