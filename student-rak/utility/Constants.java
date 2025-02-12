package rak.skiply.student.utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
	
	public static final String SOMETHING_WENT_WRONG = "Something went wrong, please try again later";
	public static final String SERVICE_DOWN = "Service is not responding now, please try again later";
	public static final String STUDENT_ALREADY_EXIST =  "Sorry, student with this ID already exists";
	public static final String STUDENT_SERVICE_BASE_URL =  "/student";
	public static final String STUDENT_SERVICE_LIST_URL =  "/list";
	public static final String STUDENT_SERVICE_ADD_STUDENT =  "/addStudent";
	public static final String STUDENT_SERVICE_RETRIEVE_STUDENTBY_STUDENTID =  "/{studentId}";
	public static final String UNEXPECTED_ERROR_MSG = "Unexpected error occurred: {}";
	public static final String STUDENT_NOT_FOUND = "Payment already completed for this student";


}
