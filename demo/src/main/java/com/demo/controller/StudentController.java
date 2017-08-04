package com.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.service.StudentDAO;

/**
 * 
 * @author BangNX1
 *
 */
@Controller
@RequestMapping("neopost")
public class StudentController {
	
	/**
	 * Create student DAO
	 */
	@Autowired
	private StudentDAO studentService;

	/**
	 * Method find all student
	 * @return
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> findAllStudent() {
		List<Student> listStudent = studentService.findAllStudent();
		return ResponseEntity.ok().body(listStudent);
	}

	/**
	 * Method find Student by ID
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id) {
		Student student = studentService.findStudentById(id);
		return ResponseEntity.ok().body(student);
	}

	/**
	 * Method insert student
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ResponseEntity<Void> insertStudent(@RequestBody StudentDTO dto) {
		studentService.insertStudent(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Method update Student
	 * @param id
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateStudent(@PathVariable("id") Long id,
			@RequestBody StudentDTO dto) {
		Student student = studentService.findStudentById(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		studentService.updateStudent(id,dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Method delete student
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
		Student student = studentService.findStudentById(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Method find by name
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/student/search/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Student>>findByName(@PathVariable("name")String name){
		List<Student> listStudent = studentService.findStudentByName(name);
		return new ResponseEntity<>(listStudent,HttpStatus.OK);
	}
	
	/**
	 * Method find by name
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/student/find/{mark}", method=RequestMethod.GET)
	public ResponseEntity<List<Student>>findByMark(@PathVariable("mark")double mark){
		List<Student> listStudent = studentService.findStudentByMark(mark);
		return new ResponseEntity<>(listStudent,HttpStatus.OK);
	}

}
