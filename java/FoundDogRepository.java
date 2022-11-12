import java.util.List;

public interface DogRepository<T> {

    void create(T obj);

    T read(Integer uid);

    List<T> readAll();

    T update(Integer uid, T obj);

    void delete(Integer uid);
    
}