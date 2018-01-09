package com.situ.day36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.situ.student.entity.Student;
import com.situ.student.util.JDBCUtil;

public class C3P0Test {
	@Test
	public void testFindAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = C3P0Util.getConnection();
			String sql = "select * from student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, new java.util.Date(), birthday);
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Util.release(connection, preparedStatement, resultSet);
		}
	}
	
	
	@Test
	public void testFindAll1() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//创建C3P0数据库连接池
		DataSource dataSource = new ComboPooledDataSource();
		try {
			connection = dataSource.getConnection();
			String sql = "select * from student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");// java.sql.Date
				Student student = new Student(id, name, age, gender, address, new java.util.Date(), birthday);
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, preparedStatement, resultSet);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
