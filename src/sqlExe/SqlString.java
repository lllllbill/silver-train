package sqlExe;

import java.lang.reflect.Field;
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
	
	private Schame schame;
	private String[] list1 = {UPDATA,SELECT,INSERT,DELETE};
	private String[] list2 = {INTO,FROM};
	private String[] list3 = {WHERE};
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
		switch(type){
		case("UPDATA"):;
		case("SELECT"):
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
			return list1[1] + str1 + list2[2] + schame.getTable() + list3[0] + str2;
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
				str2.append(fieldName).append("=");
				getValueByType(fieldName);
				if(iterator.hasNext()){
					str2.append(",");
				}
			}
		}
	}
	
	private void getValueByType(String key) throws ReflectiveOperationException{
		str2.append("'");
		String type = schame.getFieldType(key);
		switch(type){
			case("int"):str2.append(String.valueOf((int)schame.getFieldValue(key))).append("'");break;
			case("class java.lang.String"):str2.append(schame.getFieldValue(key)).append("'");break;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException{
		Class c = new test().getClass();
		Field[] f=c.getFields();
		for(Field t:f){
			System.out.println(t.getType());
		}
	}
}

class test{
	public int j;
	public String i ;
}
