package com.relationMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="STUDENT_TBL")
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private int age;
    private  String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",
            joinColumns = {
            @JoinColumn(name="student_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
            @JoinColumn(name="course_id", referencedColumnName = "id")
            }
    )
//    @JsonManagedReference
    @JsonIgnore
    private Set<Course> courseSet;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
      return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

}
