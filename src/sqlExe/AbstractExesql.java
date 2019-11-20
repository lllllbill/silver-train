package sqlExe;

import java.sql.ResultSet;

abstract class AbstractExesql {
	abstract ResultSet executeQuery(String Sql);
	abstract int excuteUpdate(String sql);
}
