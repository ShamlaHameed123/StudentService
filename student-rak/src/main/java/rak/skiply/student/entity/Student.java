package rak.skiply.student.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    private String studentId;

    @Column(name = "STUDENT_NAME", nullable = false)
    private String studentName;

    @Column(name = "GRADE", nullable = false)
    private int grade;

    @Column(name = "MOBILE_NUMBER", nullable = false)
    private String mobileNumber;

    @Column(name= "SCHOOL_NAME", nullable = false)
    private String schoolName;

}
