package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query("SELECT m FROM Message m JOIN FETCH m.id.sender JOIN FETCH m.id.recipient")
    List<Message> findAllMessagesWithUsers();
}
