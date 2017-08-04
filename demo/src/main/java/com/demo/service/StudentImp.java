package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

/**
 * 
 * @author BangNX1
 *
 */
@Service
public class StudentImp implements StudentDAO {
	/**
	 * Create student repository
	 */
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Method insert student to SQL
	 */
	@Override
	public Student insertStudent(StudentDTO dto) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setName(dto.getName());
		student.setMark(dto.getMark());
		return studentRepository.save(student);
	}

	/**
	 * Method find all student
	 */
	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	/**
	 * Method find student by id
	 */
	@Override
	public Student findStudentById(Long id) {
		return studentRepository.findOne(id);
	}

	/**
	 * Method update student
	 */
	@Override
	public Student updateStudent(Long id, StudentDTO dto) {
		Student student = new Student();
		student.setId(id);
		student.setName(dto.getName());
		student.setName(dto.getName());
		student.setMark(dto.getMark());
		return studentRepository.save(student);
	}

	/**
	 * Method delete student
	 */
	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
	}

	/**
	 * Method find student by name
	 */
	@Override
	public List<Student> findStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	/**
	 * Method find student by mark
	 */
	@Override
	public List<Student> findStudentByMark(double mark) {
		return studentRepository.findByMark(mark);
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentRepository.findAll(new PageRequest(1, 20));
	}
}
