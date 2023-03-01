package com.relationMapping.controller;

import com.relationMapping.entity.Course;
import com.relationMapping.entity.Student;
import com.relationMapping.repository.CourseRepository;
import com.relationMapping.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="student/course")
public class StudentCourseController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourses(@RequestBody Student student){
        return  studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{studntId}")
    public Student findStudent(@PathVariable Long studntId){
        return studentRepository.findById(studntId).orElse(null);
    }

    @GetMapping("find/{name}")
    public List<Student> findStudentsContainigByName(@PathVariable String name){
        return studentRepository.findByFullNameContaining(name);
    }

    @GetMapping("search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }
}
