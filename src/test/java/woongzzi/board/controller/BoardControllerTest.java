package woongzzi.board.controller;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;
import woongzzi.board.DTO.BoardDTO;
import woongzzi.board.domain.repository.BoardRepository;
import woongzzi.board.service.BoardService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = BoardController.class)
public class BoardControllerTest {

    @Mock //클래스에 대한 모의 구현을 만들고
    private BoardService boardService;
    private BoardRepository boardRepository;

    @InjectMocks //클래스의 인스턴스를 만들고 @Mock에 표시된 모의 객체를 주입시킨다.
    private BoardController boardController;

    @Autowired
    private MockMvc mvc; //테스트용 MVC환경을 만들어주는 요청,전송,응답을 제공하는 유틸리티클래스

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(boardController)
                .addFilter(new CharacterEncodingFilter("UTF-8")).build();
        //MockMvcBuilders로 테스트 대상을 지정,
        //filter의 경우 스프링 테스트의 설정을 커스텀
    }

    @Test
    public void listTest() throws Exception{
        //given
        BoardDTO testData = new BoardDTO(1L,"test1","test1","test1", LocalDateTime.now(),LocalDateTime.now());
        List<BoardDTO> boardList2 = boardService.getBoardlist();
        //when

        //then
        mvc.perform(get("/board/list"))
                .andExpect(status().is(200))
                .andExpect((forwardedUrl("/board/post")))
                .andExpect(content().string(""));
//        .andExpect(model().attribute("boardList",boardList2));
    }
}