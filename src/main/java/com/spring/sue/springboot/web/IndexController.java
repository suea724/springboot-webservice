package com.spring.sue.springboot.web;

import com.spring.sue.springboot.config.auth.dto.SessionUser;
import com.spring.sue.springboot.service.post.PostsService;
import com.spring.sue.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        // Model에 게시글 조회 결과 전달
        model.addAttribute("posts", postsService.findAllDesc());

        // 로그인 성공 시 저장된 세션으로부터 userName 가져와서 Model에 전달
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") // 수정 화면에서 보여줄 데이터를 모델에 전달
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
