package sqlExe;

public class SchameImpl<T extends Schame> implements ISchameDB<T>{
	private ExeSql exeSql;
	private T t;
	private SqlString sqlString;
	@SuppressWarnings("unchecked")
	SchameImpl(){
		exeSql = new ExeSql();
		t = (T)new Object();
		sqlString = new SqlString(t);
	}
	
	@Override
	public T query() {
		//根据T里的成员结构来构建sql
		String sql = sqlString.getSql("SELECT");
		@SuppressWarnings("unchecked")
		T t=(T) exeSql.queryByClassNameOne(graph(),sql);
		return t;
	}	
	@Override
	public int delete() {
		return exeSql.excuteUpdate(null);
	}
	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Class<? extends AbstractSchame> graph(){
		 @SuppressWarnings("unchecked")
		T t = (T) new Object();
	     return (Class<? extends AbstractSchame>) t.getClass();
    } 
}
