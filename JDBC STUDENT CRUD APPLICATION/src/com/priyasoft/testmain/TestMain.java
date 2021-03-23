package com.priyasoft.testmain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.priyasoft.beans.Student;
import com.priyasoft.factory.StudentServiceFactory;
import com.priyasoft.service.StudentService;

public class TestMain {

	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println();
				System.out.println("1. ADD");
				System.out.println("2. SEARCH");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Your Option[1,2,3,4,5]:");
				int option=Integer.parseInt(br.readLine());
				StudentService studentservice=StudentServiceFactory.getStudentService();
				String sid="";
				String sname="";
				String saddr="";
				switch(option)
				{
				case 1:
					System.out.println("Student Id  :");
					sid=br.readLine();
					System.out.println("Student Name :");
					sname=br.readLine();
					System.out.println("Student Address :");
					saddr=br.readLine();
					Student std=new Student();
					std.setSid(sid);
					std.setSname(sname);
					std.setSaddr(saddr);
					String status= studentservice.addStudent(std);
					System.out.println("Status  :"+status);
				break;
				case 2:
					System.out.println("Student ID:");
					sid =br.readLine();
					std=studentservice.searchStudent(sid);
					if(std==null)
					{
						System.out.println("Student not existed.");
					}else{
						System.out.println("Student Details");
						System.out.println("-----------------------------");
						System.out.println("Student Id:"+std.getSid());
						System.out.println("Student Name:"+std.getSname());
						System.out.println("Student Address:"+std.getSaddr());
					}
			    break;
				case 3:
					System.out.println("Student ID:");
					sid=br.readLine();
				    std=studentservice.searchStudent(sid);
				    if(std==null)
				    {
				    	System.out.println("Status: Student Not Existed");
				    }else{
				    	System.out.println("Student Name[Old Name:"+std.getSname()+"]:");
				    	String sname_New=br.readLine();
				        if(sname_New == null || sname_New.equals("")){
				        	sname_New=std.getSname();
				        }
				        System.out.println("Student Address[Old Address:"+std.getSaddr()+"]:");
				    	String saddr_New=br.readLine();
				        if(saddr_New == null || saddr_New.equals("")){
				        	saddr_New=std.getSaddr();
				        }
				        Student std_new=new Student();
				        std_new.setSid(sid);
				        std_new.setSname(sname_New);
				        std_new.setSaddr(saddr_New);
				        status=studentservice.updateStudent(std_new);
				        System.out.println("Status:"+status);
				    }
					
				break;
				case 4:
					System.out.println("Student ID:");
					sid=br.readLine();
					std=studentservice.searchStudent(sid);
					if(std==null)
					{
						System.out.println("Status: Student Not Existed");
				    }else{
				    	status=studentservice.deleteStudent(sid);
				    	System.out.println("Status:"+status);
				    }
			    break;
				case 5:
					System.out.println("**********************ThankQ for using Student Application***************************************");
					System.exit(0);
				break;
					
			    default:
			    	System.out.println("Provide number from 1,2,3,4,5");
			    break;
					
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
