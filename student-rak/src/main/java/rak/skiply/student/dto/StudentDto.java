package rak.skiply.student.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;




@Data
public class StudentDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
    @NotBlank(message = "Student id number should not be empty")
	private String studentId;
    
    @NotBlank(message = "Student name should not be empty")
    private String studentName;
    
    @NotNull(message = "Student's grade should not be empty")
    private int grade;
    
    @NotBlank(message = "Student's mobile number should not be empty")
    private String mobileNumber;
    
    @NotBlank(message = "Student's school name should not be empty")
    private String schoolName;
}
