package com.priyasoft.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.priyasoft.beans.Student;
import com.priyasoft.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
		String status="";
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where SID ='"+std.getSid()+"'");
			boolean b = rs.next();
			if(b==true)
			{
				status="Student Existed Already";
			}else{
				int rowCount=st.executeUpdate("insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
			    if (rowCount == 1)
			    {
			    	status="Student insertion success";
			    }else{
			    	status="student insertion failure";
			    }
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std=null;
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where SID ='"+sid+"'");
			boolean b=rs.next();
			if(b==true)
			{
				std=new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
				
			}else{
				std=null;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return std;
		
	}

	@Override
	public String update(Student std) {
		String status="";
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			int rowCount=st.executeUpdate("update student set SNAME='"+std.getSname()+"', SADDR='"+std.getSaddr()+"' where SID='"+std.getSid()+"'");
			if(rowCount==1)
			{
				status="Student Updation Success";
				
			}
			else{
				status="Student Updation Failure";
			}
			
		}catch(Exception e)
		{
			status="Student Updation failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String delete(String sid) {
		String status="";
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			int rowCount=st.executeUpdate("delete from student where SID='"+sid+"'");
			if(rowCount==1)
			{
				status="Student Deletion Success";
			}
			else{
				status="Student Deletion Failure";
			}
		}catch(Exception e)
		{
			status="Student Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
