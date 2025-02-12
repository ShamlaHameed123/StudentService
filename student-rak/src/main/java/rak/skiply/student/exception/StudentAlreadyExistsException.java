package rak.skiply.student.exception;

import lombok.Data;

@Data
public class StudentAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;

    public StudentAlreadyExistsException() {}

    public StudentAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}
