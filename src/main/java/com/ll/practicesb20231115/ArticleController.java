package com.ll.practicesb20231115;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    @GetMapping("/article/write")
    String showWrite() {

        return "article/write";
    }

    Article lastArticle;
    @GetMapping("/article/dowrite")
    @ResponseBody
    Map<String, Object> doWrite(String title, String body){
        lastArticle = new Article(1, title, body);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg", "1번 게시물이 작성되었습니다.");
        rs.put("data", lastArticle);


        return rs;
    }

    @GetMapping("/article/getLastArticles")
    @ResponseBody
    Article getLastArticles(){

        return lastArticle;
    }
}

@AllArgsConstructor
@Getter
class Article{
    private long id;
    private String title;
    private String body;
}
