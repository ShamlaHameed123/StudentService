package rak.skiply.student.service;

import java.util.List;

import rak.skiply.common_services.dto.StudentDto;
import rak.skiply.student.entity.Student;
import rak.skiply.student.exception.StudentAlreadyExistsException;


public interface StudentService {
	
    public List<Student> getAllStudents() ;

    public StudentDto saveStudent(StudentDto studentDetails) throws StudentAlreadyExistsException;

	public StudentDto getStudentById(String studentId) ;

}
