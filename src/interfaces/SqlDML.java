package interfaces;

public interface SqlDML {

	void insert(String dado);
	void update(String dado);
	void delete(String dado);
	String select(String dado);
}
