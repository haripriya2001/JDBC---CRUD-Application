package com.priyasoft.factory;

import com.priyasoft.dao.StudentDao;
import com.priyasoft.dao.StudentDaoImpl;

public class StudentDaoFactory {
private static StudentDao studentDao;
static{
	studentDao=new StudentDaoImpl();
}
public static StudentDao getStudentDao()
{
	return studentDao;
}
}
