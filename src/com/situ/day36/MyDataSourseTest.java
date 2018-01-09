package com.situ.day36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;

import org.junit.Test;

import com.situ.student.entity.Student;
import com.situ.student.util.JDBCUtil;

public class MyDataSourseTest {

	@Test
	public void testDataSource() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//connection = JDBCUtil.getConnection();//每一次都创建一个新的
		//1.创建自定义数据库连接池对象
		MyDataSource myDataSource = new MyDataSource();
		//2.从池子中取Connection
		try {
			connection = myDataSource.getConnection();
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
			myDataSource.releaseConnection(connection);//将Connection归还数据库连接池
			JDBCUtil.close(null, preparedStatement, resultSet);//其他的资源还是需要释放
		}
	}
}
