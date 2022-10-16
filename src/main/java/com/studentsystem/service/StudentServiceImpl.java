package com.studentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsystem.model.Student;
import com.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public Optional<Student> updateStudent(Student student, Optional<Student> s) {

		Student st =s.get();
		    st.setName(student.getName());
		    st.setAddress(student.getAddress());
		studentRepository.save(st);
		return null;
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return null;
	}
	
	

}
