package com.springjdbc.springjdbcpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.Dao.StudentDao;
import com.springjdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Initilizing database for you..." );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/springjdbcpractice/config.xml");
        StudentDao studentDao =context.getBean("studentDao", StudentDao.class);
        
        Student stud = new Student();
        stud.setId(105);
        stud.setCity("Bhopal");
        stud.setName("Bhola Pandit");
        
        int row = studentDao.insert(stud);
        
        System.out.println(row + " row inserted into Student");
    }
}
