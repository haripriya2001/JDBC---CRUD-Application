package com.priyasoft.service;
import com.priyasoft.beans.Student;
public interface StudentService {
	public String addStudent(Student sid);
	public Student searchStudent(String sid);
	public String updateStudent(Student sid);
	public String deleteStudent(String sid);

}
