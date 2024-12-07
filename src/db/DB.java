package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private Connection conn;

	public Connection getConnection() {
		if (conn == null) {
			try {

				Properties props = loadConnection();
				String url = props.getProperty("jdbc:mysql://localhost:3306/coursejdbc");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;

	}

	public Properties loadConnection() {

		try (FileInputStream fl = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fl);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public void closeStatement(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
