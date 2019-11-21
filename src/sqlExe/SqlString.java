package sqlExe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class SqlString {
	public static final String UPDATA="UPDATA";
	public static final String SELECT="SELECT";
	public static final String INSERT="INSERT";
	public static final String DELETE="DELETE";
	
	private static final String INTO="INTO";
	private static final String FROM="FROM";
	private static final String WHERE="WHERE";
	private static final String VALUES="VALUES";
	private static final String SET="SET";
		
	private Schame schame;
	private String[] list1 = {UPDATA,SELECT,INSERT,DELETE};
	private String[] list2 = {INTO,FROM,SET};
	private String[] list3 = {WHERE,VALUES};
	private StringBuffer str =null;
	private StringBuffer str1=null;
	private StringBuffer str2=null;
	
	private List<String> fieldNameList=null;
	SqlString(Schame schame){
		this.schame=schame;
		str=new StringBuffer();
		str1=new StringBuffer();
		str2=new StringBuffer();
		fieldNameList=schame.getFieldNameList();
	}
	
	public String getSql(String type){
		if(str1.length()==0){
			setStr1();
		}
		if(str2.length()==0){
			try {
				setStr2();
			} catch (ReflectiveOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch(type){
		case("UPDATA"):
			return list1[0] + schame.getTable()+list2[2]+str+list3[0]+str2;
		case("SELECT"):
			return list1[1] + str1 + list2[1] + schame.getTable() + list3[0] + str2;
		case("INSERT"):
			return list1[2]+list2[0]+schame.getTable()+list3[1]+str;
		case("DELETE"):
			return list1[3]+list2[1]+schame.getTable()+str2;
		//要自建一个错误类
		default:throw new RuntimeException("type wrong");
		}
	}
	
	private void setStr1(){
		str1.append("(");
		Iterator iterator = fieldNameList.iterator();
		while(iterator.hasNext()){
			str1.append(iterator.next());
			if(iterator.hasNext()){
				str1.append(",");
			}
		}
		str1.append(")");
	}
	
	private void setStr2() throws ReflectiveOperationException{
		str2.append("(");
		str.append("(");
		String[] primkeys=schame.getprimKey();
		if(primkeys!=null){
			for(int i =0;i<primkeys.length-1;i++){
				str2.append(primkeys[i]).append(",");
			}
			str2.append(primkeys[primkeys.length]).append(")");
		}else{
			Iterator<String> iterator = fieldNameList.iterator();
			while(iterator.hasNext()){
				String fieldName = iterator.next();
				String temp = getValueByType(fieldName);
				if(temp!=null){
					str2.append(fieldName).append("=");
					str.append(fieldName).append("=");
					if(iterator.hasNext()){
						str2.append(",");
						str.append(",");
					}
				}
			}
		}
		str2.append(")");
		str.append(")");
	}
	
	private String getValueByType(String key) throws ReflectiveOperationException{
		str2.append("'");
		String type = schame.getFieldType(key);
		Object o = schame.getFieldValue(key);
		if(o!=null){
			//值为空怎么办？
			switch(type){
				case("int"):return String.valueOf((int)o);
				case("class java.lang.String"):return String.valueOf(o);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		/*Class c = new test().getClass();
		Field[] f=c.getFields();
		for(Field t:f){
			System.out.println(t.getType());
		}*/
		Class c = new test().getClass();
		Method m = c.getMethod("getj", null);
		Object o = m.invoke(new test());
		if(o==null){
			System.out.println("null");
		}else{
			System.out.println((int)o);
		}
	}
}

class test{
	public int j;
	public String i ;
	
	public int getj(){
		return j;
	}
}
