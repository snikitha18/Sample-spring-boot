package com.springboot.SpringRest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springboot.SpringRest.Model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
