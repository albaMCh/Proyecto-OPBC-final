package com.alba.proyectoobc.repository;

import com.alba.proyectoobc.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findByNameIgnoreCase(String name);


}
