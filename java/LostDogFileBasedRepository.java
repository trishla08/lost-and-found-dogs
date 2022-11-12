import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LostDogFileBasedRepository implements LostDogRepository {

    private final String fileName = "lostDog.dat";

    @Override
    public void create(LostDog obj) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // write object to file
            oos.writeObject(obj);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public LostDog read(Double uid) {
        LostDog dogObject = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                dogObject = (LostDog) obj;

                if (dogObject.getUid() == uid) {
                    return dogObject;

                }
            }

            // close reader
            ois.close();
            // return list;

        } catch (IOException | ClassNotFoundException ex) {

        }
        return dogObject;
    }

    @Override
    public List<LostDog> readAll() {
        List<LostDog> list = new ArrayList<LostDog>();
        ;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                LostDog item = (LostDog) obj;
                list.add(item);
            }

            // close reader
            ois.close();
            return list;

        } catch (IOException | ClassNotFoundException ex) {
            return list;
        }
    }

    @Override
    public void update(Double uid, LostDog obj) {
        try {
            List<LostDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid() == uid) {
                    list.set(i, obj);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {

        }
    }

    @Override
    public void delete(Double uid) {
        try {
            List<LostDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid() == uid) {
                    list.remove(i);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {

        }
    }

}
