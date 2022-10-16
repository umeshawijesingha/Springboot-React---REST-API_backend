package com.studentsystem.service;

import java.util.List;
import java.util.Optional;

import com.studentsystem.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

	public Optional<Student> findById(int id);

	public Optional<Student> updateStudent(Student student, Optional<Student> st);

	public String deleteStudent(int id);
}
