package io.deoki.blog.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import io.deoki.blog.entity.Comment;
import io.deoki.blog.entity.QComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void crud(){
        JPAQuery<Comment> query = new JPAQuery<Comment>(entityManager);
        //Predicate predicate = QComment.
        QComment qComment = QComment.comment;
        Comment comment = query.from(qComment).orderBy(qComment.created.desc()).fetchOne();

    }

}