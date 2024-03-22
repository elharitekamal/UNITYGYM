package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Integer> {
}
