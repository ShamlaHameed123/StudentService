package rak.skiply.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rak.skiply.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findByStudentId(String studentId);

}
