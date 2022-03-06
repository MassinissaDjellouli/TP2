package Database;

public interface JDBCInterface<T> {
        void save(T toSave);
        void createTable();
        T get(int id);
        void handleException(Exception e);
}
