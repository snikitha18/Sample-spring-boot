package com.springboot.SpringRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.springboot.SpringRest.Model.Student;
import com.springboot.SpringRest.Repo.StudentRepo;
@Service
@ComponentScan(basePackageClasses = StudentRepo.class)
public class SudentService {
	@Autowired
	StudentRepo db;
	public List<Student> getAllStudents() {
		try {
			System.out.println("Fetching All Students");
			return db.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}
	public Student getStudent(int id) {
		System.out.println("Fetching Student of id "+id);
		return db.findById(id).orElse(null);
	}
	public void updateStudent(Student st) {
		try {
			System.out.println("Updating Student "+st.getName());
			db.save(st);
			System.out.println("Updated successfully");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		
	}
	public void addStudent(Student st) {
		
		try {
			System.out.println("Adding Student "+st.getName());
			db.save(st);
		    System.out.println("Added successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		}
	public void deleteStudent(int id) {
		try {
			System.out.println("Deleting Student of id "+id);
			db.deleteById(id);
			System.out.println("Deleted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
