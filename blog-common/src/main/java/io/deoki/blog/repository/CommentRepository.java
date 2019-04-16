package io.deoki.blog.repository;

import io.deoki.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment> {
    List<Comment> findCommentsByPostId(Long id);
    List<Comment> findTop5CommentsByOrderByCreatedDesc();
}
