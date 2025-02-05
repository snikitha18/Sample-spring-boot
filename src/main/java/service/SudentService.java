package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import controller.StudentController;
import model.Student;
import repo.StudentDB;
@Service

@ComponentScan(basePackageClasses = StudentDB.class)
public class SudentService {
	@Autowired
	StudentDB db;
	public List<Student> getAllStudents() {
		System.out.println("Fetching All Students");
		return db.getAllStudents();
	}
	public Student getStudent(int id) {
		System.out.println("Fetching Student of id "+id);
		return db.getStudent(id);
	}
	public void updateStudent(Student st) {
		System.out.println("Updating Student "+st.getName());
		if(db.updateStudent(st)==1)
			System.out.println("Updated successfully");
		else
			System.out.println("No student with id "+st.getId()+" found");
		
	}
	public void addStudent(Student st) {
		System.out.println("Adding Student "+st.getName());
		if(db.addStudent(st)==1)
			System.out.println("Added successfully");
		else
			System.out.println("Student with id "+st.getId()+" is already present");				
	}
	public void deleteStudent(int id) {
		System.out.println("Deleting Student of id "+id);
		if(db.deleteStudent(id)==1)
			System.out.println("Deleted successfully");
		else
			System.out.println("No student with id "+id+" found");
	
		
	}

}
