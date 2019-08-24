package com.philcoding.blog.controller;

import com.philcoding.blog.model.blog.BlogDTO;
import com.philcoding.blog.model.blog.BlogDetailVO;
import com.philcoding.blog.model.blog.BlogListVO;
import com.philcoding.blog.model.blog.BlogPageDTO;
import com.philcoding.blog.model.blog.CreateQuery;
import com.philcoding.blog.model.pageable.PageDTO;
import com.philcoding.blog.model.pageable.PageQuery;
import com.philcoding.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/blogs")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(path = "")
    public ModelAndView list(@Validated PageQuery pageQuery) {

        PageDTO pageDTO = PageDTO.of(pageQuery);
        BlogPageDTO blogList = blogService.findByPage(pageDTO);

        ModelAndView view = new ModelAndView("blog/index");
        view.addObject("blogList", BlogListVO.from(blogList.getBlogList()));
        view.addObject("pageable", blogList.getPageable());

        return view;
    }

    @GetMapping(path = "/{blog_id}")
    public ModelAndView detail(@PathVariable("blog_id") Long blogId) {

        BlogDTO blogDTO = blogService.findById(blogId);

        ModelAndView view = new ModelAndView("blog/detail");
        view.addObject("blog", BlogDetailVO.from(blogDTO));

        return view;
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
