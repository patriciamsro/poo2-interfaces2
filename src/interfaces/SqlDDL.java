package interfaces;

public interface SqlDDL {
	
	void create(String dado);
	void drop(String dado);
	void alter(String dado);
}
