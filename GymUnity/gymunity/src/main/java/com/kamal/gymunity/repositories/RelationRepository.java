package com.kamal.gymunity.repositories;

import com.kamal.gymunity.entities.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RelationRepository extends JpaRepository<Relation,Integer> {
}
