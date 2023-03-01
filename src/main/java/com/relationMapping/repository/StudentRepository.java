package com.relationMapping.repository;

import com.relationMapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFullNameContaining(String name);
}
