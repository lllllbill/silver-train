package sqlExe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExeSql extends AbstractExesql{
	@Override
	ResultSet executeQuery(String sql){
		ResultSet result = null;
		Connection conn = null;
		PreparedStatement  statement = null;
		try {
			conn = DBPool.getConnection();
			statement = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY
                    , ResultSet.CONCUR_READ_ONLY);
			result = statement.executeQuery();
		} catch (SQLException e) {
			//记录错误 执行sql出错
			//返回值做好
			e.printStackTrace();
			result=null;
			return result;
		}finally{
			try {
				conn.close();
				result.close();
				try{
					statement.close();
				}catch(SQLException e2){
					//记录错误 资源关闭出错
					e2.printStackTrace();
				}
			} catch (SQLException e1) {
				//记录错误 资源关闭出错
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int excuteUpdate(String sql){
		int result;
		Connection conn = null;
		PreparedStatement  statement = null;
		try {
			conn = DBPool.getConnection();
			statement = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY
                    , ResultSet.CONCUR_READ_ONLY);
			result = statement.executeUpdate();
		}catch (SQLException e) {
			//记录错误 执行sql出错
			//返回值做好
			e.printStackTrace();
			result=-1;
			return result;
		}finally{
			try {
				conn.close();
				try{
					statement.close();
				}catch(SQLException e2){
					//记录错误 资源关闭出错
					e2.printStackTrace();
				}
			} catch (SQLException e1) {
				//记录错误 资源关闭出错
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	public <T>T queryByClassNameOne(Class<?extends AbstractSchame> className,String sql){
		AbstractSchame schame = null ;
		ResultSet result;
		
		try {
			schame = className.newInstance();
			result = this.executeQuery(sql);
			//返回第一个值
			schame.newInstance(result);
		} catch (InstantiationException e) {
			//记录错误 
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//记录错误
			e.printStackTrace();
		}
		return (T) schame;
	}
	
	public List<AbstractSchame> queryByClassNameList(Class<?extends AbstractSchame> className,String sql){
		List<AbstractSchame> schameList = new ArrayList<>();
		ResultSet resultSet;
		AbstractSchame schame = null ;
		try {
			resultSet = this.executeQuery(sql);
			//返回第一个值
			try {
				while(resultSet.next()){
					schame = className.newInstance();
					schame.newInstance(resultSet);
					schameList.add(schame);
				}
			} catch (SQLException e) {
				//记录错误
				//设置返回值
				schameList=null;
				e.printStackTrace();
				return schameList;
			}
		} catch (InstantiationException e) {
			//记录错误 
			schameList=null;
			e.printStackTrace();
			return schameList;
		} catch (IllegalAccessException e) {
			//记录错误
			schameList=null;
			e.printStackTrace();
			return schameList;
		}
		return schameList;
	}
	
}
