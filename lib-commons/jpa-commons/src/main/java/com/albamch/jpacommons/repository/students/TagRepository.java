package com.albamch.jpacommons.repository.students;

import com.albamch.modelcommons.models.students.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    List<Tag> findByNameContainingIgnoreCase(String name);

    boolean deleteTagByNameIgnoreCase (String name);

    @Query(value = "INSERT INTO students_to_tags VALUES (?1,?2) ", nativeQuery = true)
    boolean assignTagToStudent (Integer studentId, Integer tagId);

    @Query(value = "DELETE FROM students_to_tags WHERE users_id = ?1 and roles_id = ?2", nativeQuery = true)
    boolean unAssignTagToStundent (Integer studentId, Integer tagId);
}
