package sqlExe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Schame extends AbstractSchame{
	private Field[] fields = this.getClass().getDeclaredFields();
	private List<String> fieldNameList = null;
	public int getFieldCount(){
		return fields.length;
	}
	
	public List<String> getFieldNameList(){
		return fieldNameList;
	}
	
	public String getFieldType(String key){
		if(fieldNameList==null){
			SetFieldNameSet();
		}
		if(fieldNameList.contains(key)){
			int i =fieldNameList.indexOf(key);
			Field f = fields[i];
			return f.getType().toString();
		}else{
			throw new RuntimeException("key is not contains");
		}
	}
	
	public Object getFieldValue(String key) throws ReflectiveOperationException{
		//知道key调用get方法去取值
		Object o = null;
		if(fieldNameList==null){
			SetFieldNameSet();
		}
		if(fieldNameList.contains(key)){
			Class<? extends Schame> c = this.getClass();
			Method m = c.getMethod("get"+key, null);
			o = m.invoke(c.newInstance());
		}else{
			throw new RuntimeException("key is not contains");
		}
		return o;
	}
	
	private void SetFieldNameSet(){
		fieldNameList = new ArrayList<String>();
		for(Field f:fields){
			String temp = f.toString();
			fieldNameList.add(temp.substring(temp.lastIndexOf("."),temp.length()));
		}
	}
	
}