package io.deoki.blog.service;

import io.deoki.blog.entity.Comment;
import io.deoki.blog.entity.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Before
    public void createPost() {
        Post post = new Post();
        post.setTitle("test");

        Comment comment1 = new Comment();
        comment1.setContent("testComment1");

        Comment comment2 = new Comment();
        comment2.setContent("testComment2");

        Comment comment3 = new Comment();
        comment3.setContent("testComment3");

        Comment comment4 = new Comment();
        comment4.setContent("testComment4");

        Comment comment5 = new Comment();
        comment5.setContent("testComment5");

        Comment comment6 = new Comment();
        comment6.setContent("testComment6");

        post.addComment(comment1);
        post.addComment(comment2);
        post.addComment(comment3);
        post.addComment(comment4);
        post.addComment(comment5);
        post.addComment(comment6);

        Post post1 = postService.savePost(post);
        postService.saveComments(post1.getComments());


    }

    @Test
    public void getComments(){

        List<Comment> commentsByPost = postService.findTop5CommentByCreatedOrderByCreatedDesc();

        commentsByPost.forEach(comment -> System.out.println(comment.getContent()));
    }

}