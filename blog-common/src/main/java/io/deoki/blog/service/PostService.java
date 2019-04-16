package io.deoki.blog.service;

import io.deoki.blog.entity.Comment;
import io.deoki.blog.entity.Post;
import io.deoki.blog.repository.CommentRepository;
import io.deoki.blog.repository.PostRepository;
import io.deoki.blog.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    PostRepository posts;
    CommentRepository comments;
    TagRepository tags;

    /**
     * Use the id to find one Post.
     * Returns null in case the Post does not exist
     * @param id
     * @return post
     */
    public Post findPostById(Long id){
        return posts.findById(id).orElse(null);
    }

    /**
     * Finds all existing Post(s).
     * @return posts
     */
    public List<Post> findPostAll(){
        return posts.findAll();
    }

    /**
     * Find one Comment by comment id.
     * @return comment
     */
    public Comment findCommentById(Long id){
        return comments.findById(id).orElse(null);
    }

    /**
     * Finds all existing Comment(s) by post id.
     * @param id
     * @return comments
     */
    public List<Comment> findCommentsByPost(Long id){
        return comments.findCommentsByPostId(id);
    }

    /**
     * Find five comments that have been recently created.
     * @return comments
     */
    public List<Comment> findTop5CommentByCreatedOrderByCreatedDesc(){
        return comments.findTop5CommentsByOrderByCreatedDesc();
    }

    public Post savePost (Post post) {
        Post savedPost = posts.save(post);
        return savedPost;
    }

    public List<Comment> saveComments(Iterable<Comment> commentIterable){
        List<Comment> savedComments = this.comments.saveAll(commentIterable);

        return savedComments;
    }

}
