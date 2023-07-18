package com.springjdbc.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student stud) {
		String query = "insert into student values(?,?,?)";
        int row = this.jdbcTemplate.update(query,stud.getId(),stud.getName(),stud.getCity());
		return row;
	}

	@Override
	public int change(Student stud) {
		String query = "update student set name=?,city=? where id=?";
        int row = this.jdbcTemplate.update(query,stud.getName(),stud.getCity(),stud.getId());
		return row;
	}

	@Override
	public int delete(int id) {
		String query = "delete from student where id =?";
        int row = this.jdbcTemplate.update(query,id);
		return row;
	}


}
