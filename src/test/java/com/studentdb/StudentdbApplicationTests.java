package com.studentdb;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentdb.entity.Student;
import com.studentdb.repository.StudentRepository;

@SpringBootTest
class StudentdbApplicationTests {

	@Autowired
	private StudentRepository studentRepo ;
	
	@Test
	void SaveOneStudent() {
		Student s1 = new Student ();
		s1.setName("safi");
		s1.setCourse("devops");
		s1.setFee(15000);
		
		studentRepo.save(s1);
	}
    
	@Test
	void deletOneStudent() {
		studentRepo.deleteById(2L);
	}
	@Test
	void getOneStudent( ) {
		Optional<Student> findById = studentRepo.findById(4L);
		 Student s = findById.get();
		
		 System.out.println(s.getId());
		 System.out.println(s.getName());
		 System.out.println(s.getCourse());
		 System.out.println(s.getFee());
		
		
	}
	@Test
	void updateOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student s = findById.get();
		s.setCourse("full stack");
		s.setFee(1245);
		
		studentRepo.save(s);
		
		
		
	}
}
 