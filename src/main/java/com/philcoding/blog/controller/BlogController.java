package com.philcoding.blog.controller;

import com.philcoding.blog.model.blog.BlogDTO;
import com.philcoding.blog.model.blog.CreateQuery;
import com.philcoding.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/blogs")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(path = "")
    public String getList(Model model) {
        model.addAttribute("content", "blog content");
        return "blog/index";
    }

    @PostMapping(path = "")
    @ResponseBody
    public ResponseEntity<BlogDTO> create(@RequestBody @Validated CreateQuery createQuery) {

        BlogDTO blogDTO = BlogDTO.from(createQuery);

        blogDTO = blogService.create(blogDTO);

        return ResponseEntity.ok(blogDTO);
    }

    @PutMapping(path = "/{blog_id}")
    @ResponseBody
    public ResponseEntity<BlogDTO> update(@PathVariable("blog_id") Long blogId,
                                          @RequestBody @Validated CreateQuery createQuery) {

        BlogDTO blogDTO = BlogDTO.from(createQuery);
        blogDTO.setBlogId(blogId);

        blogDTO = blogService.update(blogDTO);

        return ResponseEntity.ok(blogDTO);
    }

    @DeleteMapping(path = "/{blog_id}")
    @ResponseBody
    public ResponseEntity<BlogDTO> delete(@PathVariable("blog_id") Long blogId) {

        blogService.delete(blogId);

        return ResponseEntity.noContent().build();
    }
}
