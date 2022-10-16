package com.studentsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentsystem.model.Student;
import com.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		
		return "New student is added";
	}
	
	@GetMapping("/get/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	@PutMapping("/get/{id}")
	public Optional<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
		Optional<Student> st= studentService.findById(id);
		
		System.out.println(student);
		studentService.updateStudent(student,st);
		return null;
	}
	
	
	@GetMapping("/getAll")
	public List<Student> getAllSudent(){
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
	//	Optional<Student> st= studentService.findById(id);
		return studentService.deleteStudent(id);
		
	}
	
}
