import java.util.List;

public interface LostDogRepository {

    void create(LostDog obj);

    LostDog read(Double uid);

    List<LostDog> readAll();

    void update(Double uid, LostDog obj);

    void delete(Double uid);
    
}