package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import enums.Props;
import lombok.Data;
@Data
public class Oracle implements Database{
	private Connection conn;
	private String driver, url, user, password;
	private Props prop;
	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Props.ORA_DRIVER.getValue());
			conn = DriverManager.getConnection(
					Props.DB_URL.getValue(), 
					Props.DB_USER.getValue(),
					Props.DB_PASS.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
