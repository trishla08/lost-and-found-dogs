import java.util.List;

public interface FoundDogRepository{

    void create(FoundDog obj);

    FoundDog read(Double uid);

    List<FoundDog> readAll();

    void update(Double uid, FoundDog obj);

    void delete(Double uid);
    
}