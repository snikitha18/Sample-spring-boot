package com.springboot.SpringRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringRest.Model.Student;
import com.springboot.SpringRest.service.SudentService;

@RestController
@ComponentScan(basePackageClasses = SudentService.class)
@RequestMapping("/Students")
public class StudentController {
	@Autowired
	SudentService ser;
	@GetMapping("/All")
	public List<Student> getAllStudent()
	{
	
		return ser.getAllStudents();
		 
		
	}
	@GetMapping("/oneSt/{id}")
	public Student getStudent(@PathVariable("id") int id)
	{
		
		return ser.getStudent( id);
		
	}
	@PutMapping("/update")
	public void putStudent(@RequestBody Student st)
	{
		ser.updateStudent(st);
		
	}
	@PostMapping("/add")
	public void postStudent(@RequestBody Student sd)
	{
		
		ser.addStudent(sd);
		
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id)
	{
		
		ser.deleteStudent(id);
	}
}
