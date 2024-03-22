package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface TokenRepository extends JpaRepository<Token, UUID>{
    @Query(value = """
      select t from Token t inner join Utilisateur u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUtilisateur(UUID id);

    Optional<Token> findByToken(String token);
}
