package com.situ.day36;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.situ.student.entity.Student;

public class DBUtilsQueryTest {
	@Test
	public void testQueryAll() {
		try {
			// 1.获取核心类QueryRunner
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			// 2.写sql
			String sql = "select id,name,age,gender,address from student";
			// 3.执行查询操作(query)
			List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
			for (Student student : list) {
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryAllById() {
		try {
			// 1.获取核心类QueryRunner
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			// 2.写sql
			String sql = "select id,name,age,gender,address from student where id=?";
			// 3.为占位符设置值
			Object[] params = {2};
			// 4.执行查询操作(query)
			Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class), params);
			System.out.println(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryCount() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select count(*) from student";
			Long count = (Long) queryRunner.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testQueryByMapListHander() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select id ,name,age,gender,address from student";
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler());
			for (Map<String, Object> map : list) {
				for (String key : map.keySet()) {//打印一个map
					System.out.print(key + " : " + map.get(key) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testQueryByColumListHander() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select id ,name,age,gender,address from student";
			List<Object> list = queryRunner.query(sql, new ColumnListHandler("name"));
			for (Object object : list) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
