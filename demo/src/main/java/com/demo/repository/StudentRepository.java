package com.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByName(String name);
	
	public List<Student> findByMark(double mark);
	
	public Page<Student> findAll(Pageable pageable);
}
