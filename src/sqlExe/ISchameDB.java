package sqlExe;

public interface ISchameDB<T> {
	T query();
	int delete();
	int updata();
	int insert();
}
