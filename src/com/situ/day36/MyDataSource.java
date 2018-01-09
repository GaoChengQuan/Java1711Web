package com.situ.day36;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.situ.student.util.JDBCUtil;

/**
 * 自定义数据库连接池
 */
public class MyDataSource implements DataSource{
	private static final int INITIAL_POOL_SIZE = 5;
	//1.创建容器，用来存放Connection对象
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//2.创建5个Connection放到容器里面
	static {
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			try {
				Connection connection = JDBCUtil.getConnection();
				pool.add(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		//使用前先判断
		if (pool.isEmpty()) {// pool.size() == 0
			for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
				try {
					pool.add(JDBCUtil.getConnection());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//从池子里面获取一个Connection
		return pool.removeFirst();//pool.remove(0)
	}
	
	/**
	 * 使用完后不是close这个Connection，而是归还给连接池
	 * @param connection
	 */
	public void	releaseConnection(Connection connection) {
		if (connection != null) {
			pool.add(connection);//使用完后归还到连接池
		}
	}
	

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
