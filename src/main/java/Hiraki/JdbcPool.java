package Hiraki;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcPool {

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/simpsons");
		config.setUsername("bart");
		config.setPassword("51mp50n");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		//config từ file or Java đều ok
		//HikariConfig config = new HikariConfig("/some/path/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		try {
			Connection con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
