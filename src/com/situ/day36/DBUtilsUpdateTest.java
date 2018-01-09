package com.situ.day36;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class DBUtilsUpdateTest {
	@Test
	public void testAddStudent() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			// 2.编写sql
			String sql = "insert into student(name,age) values(?,?)";
			// 3.位占位符设置值
			Object[] params = { "java1711", 20 };
			// 4.执行添加（update）
			int count = queryRunner.update(sql, params);
			if (count > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateStudent() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "update student set name=? where id=?";
			Object[] params = { "JAVA1711", 15 };
			int count = queryRunner.update(sql, params);
			if (count > 0) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteStudentById() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "delete from student where id=?";
			Object[] params = {15};
			int count = queryRunner.update(sql, params);
			if (count > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
