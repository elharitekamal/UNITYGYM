package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike,Integer> {
}
