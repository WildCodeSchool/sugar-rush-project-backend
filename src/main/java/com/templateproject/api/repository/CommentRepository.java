package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
