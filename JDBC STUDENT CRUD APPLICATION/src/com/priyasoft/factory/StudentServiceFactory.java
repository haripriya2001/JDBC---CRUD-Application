package com.priyasoft.factory;

import com.priyasoft.service.StudentService;
import com.priyasoft.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	static{
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService()
	{
		return studentService;
	}

}
