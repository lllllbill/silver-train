package sqlExe;

public interface ISchameDB<T> {
	T query();
	int delete();
	int update();
	int insert();
}
