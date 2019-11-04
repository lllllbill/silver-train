package sqlExe;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import util.PropertiesConfig;

public class DBPool {
	private static BasicDataSource DATASOURCE = new BasicDataSource();
	
	private static final String CLASS_NAME="";
	private static final String URL="";
	private static final String USER_NAME="";
	private static final String PASSWORD="";
	private static final String INITIAL_SIZE="";
	private static final String MAX_TOTAL="";
	private static final String MAX_IDLE="";
	private static final String AUTO_COMMIT="";
	
	static{
		//1、设置四个属性
		DATASOURCE.setDriverClassName(PropertiesConfig.getStr(CLASS_NAME));
		DATASOURCE.setUrl(PropertiesConfig.getStr(URL));
		DATASOURCE.setUsername(PropertiesConfig.getStr(USER_NAME));
		DATASOURCE.setPassword(PropertiesConfig.getStr(PASSWORD));
		//2、设置连接是否默认自动提交
		DATASOURCE.setDefaultAutoCommit(PropertiesConfig.getBoolean(AUTO_COMMIT));
		//3、设置初始后连接数
		DATASOURCE.setInitialSize(PropertiesConfig.getInt(INITIAL_SIZE));
		//4、设置最大的连接数
		DATASOURCE.setMaxTotal(PropertiesConfig.getInt(MAX_TOTAL));
		//5、设置空闲等待时间，获取连接后没有操作开始计时，到达时间后没有操作回收链接
		DATASOURCE.setMaxIdle(PropertiesConfig.getInt(MAX_IDLE));
	}
	
	
	public static Connection getConnection() throws SQLException{
		try{
			return DATASOURCE.getConnection();
		}catch(SQLException e){
			//要不要抛出？
			return null;
		}
	}
}
