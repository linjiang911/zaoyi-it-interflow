package com.zaoyi.it.interflow.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Translate {

	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=fanyi";
	private static final String DATABASE_USRE = "sa";
	private static final String DATABASE_PASSWORD = "sa";

	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USRE, DATABASE_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
