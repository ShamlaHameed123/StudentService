package rak.skiply.student.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rak.skiply.common_services.dto.StudentDto;
import rak.skiply.student.entity.Student;
import rak.skiply.student.exception.NoSuchStudentExistsException;
import rak.skiply.student.exception.StudentAlreadyExistsException;
import rak.skiply.student.repository.StudentRepository;
import rak.skiply.student.service.StudentService;
import rak.skiply.student.utility.Constants;


@Slf4j
@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ModelMapper mapper;

    public List<Student> getAllStudents() {	
    	try {
    		return studentRepository.findAll();
    	}
    	catch(Exception ex) {
    		logger.error(Constants.SOMETHING_WENT_WRONG, ex.getMessage(), ex);
    	}
    	return null;
    }

    public StudentDto saveStudent(StudentDto studentDetails) throws StudentAlreadyExistsException{
    	Student student = mapper.map(studentDetails, Student.class);
    	try {
         studentRepository.save(student);
    	}
    	catch(DataIntegrityViolationException ex) {
    		logger.error(Constants.STUDENT_ALREADY_EXIST, ex.getMessage(), ex);
    		throw new StudentAlreadyExistsException(Constants.STUDENT_ALREADY_EXIST);
    	}
    	return studentDetails;
    	
    }

	public StudentDto getStudentById(String studentId) {
		Student student = studentRepository.findByStudentId(studentId).orElseThrow(() -> 
	            new NoSuchStudentExistsException(Constants.STUDENT_NOT_FOUND + studentId));		
		StudentDto studentDetails = mapper.map(student, StudentDto.class);
		return studentDetails;
	
		
		
	}

}
