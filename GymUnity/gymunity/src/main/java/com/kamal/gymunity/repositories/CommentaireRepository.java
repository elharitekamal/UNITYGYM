package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
    @Query("SELECT c FROM Commentaire c WHERE c.post.id = :postId")
    List<Commentaire> findByPostId(@Param("postId") Integer postId);
}
