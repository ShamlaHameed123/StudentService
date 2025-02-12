package rak.skiply.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import rak.skiply.common_services.dto.StudentDto;
import rak.skiply.student.entity.Student;
import rak.skiply.student.service.StudentService;
import rak.skiply.student.utility.*;

@Slf4j
@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
    private StudentService studentService;
	
	@GetMapping(Constants.LIST_STUDENTS_URL)
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping(Constants.FETCH_STUDENT_DETAILS_URL)
    public ResponseEntity<StudentDto> getStudentDetails(@Valid @PathVariable(Constants.STUDENT_ID) String studentId) {
        StudentDto studentDetails = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(studentDetails);
    }
    
    @PostMapping(Constants.ADD_STUDENT_URL)
    public StudentDto addStudent(@Valid @RequestBody StudentDto studentDetails){
        return studentService.saveStudent(studentDetails);
        
    }
}
