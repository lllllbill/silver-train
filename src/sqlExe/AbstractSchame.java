package sqlExe;

import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractSchame {
	abstract void newInstance(ResultSet result);
	abstract int getFieldCount();
	abstract String getFieldType(String key);
	abstract Object getFieldValue(String key) throws ReflectiveOperationException;
	abstract List<String> getFieldNameSet();
	abstract String[] getprimKey();
	abstract String getTable();
}
