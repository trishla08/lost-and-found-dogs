import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FoundDogFileBasedRepository implements FoundDogRepository {

    private final String fileName = "foundDog.dat";

    @Override
    public void create(FoundDog obj) {
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
    public FoundDog read(Double uid) {
        FoundDog dogObject = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                dogObject = (FoundDog) obj;

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
    public List<FoundDog> readAll() {
        List<FoundDog> list = new ArrayList<FoundDog>();
        ;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // read object from file
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                FoundDog item = (FoundDog) obj;
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
    public void update(Double uid, FoundDog obj) {
        try {
            List<FoundDog> list = readAll();
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
            List<FoundDog> list = readAll();
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
