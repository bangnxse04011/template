package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;

public interface StudentDAO {
	
	
	public Student insertStudent(StudentDTO dto);

	public List<Student> findAllStudent();
	
	public List<Student> findStudentByName(String name);
	
	public List<Student> findStudentByMark(double mark);

	public Student findStudentById(Long id);

	public Student updateStudent(Long id,StudentDTO dto);

	public void deleteStudent(Long id);

	public Page<Student> findAll(Pageable pageable);

}
