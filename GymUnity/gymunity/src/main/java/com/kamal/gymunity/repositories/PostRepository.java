package com.kamal.gymunity.repositories;

import com.kamal.gymunity.dto.PostDto;
import com.kamal.gymunity.dto.PostResDto;
import com.kamal.gymunity.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
