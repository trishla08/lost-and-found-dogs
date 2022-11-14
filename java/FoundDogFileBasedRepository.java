import java.io.File;
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

    private static File f = new File("foundDog.dat");

    @Override
    public void create(FoundDog obj) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);

            // write object to file
            Object foundObj = (Object) obj;
            if (f.length() == 0) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(foundObj);
                oos.close();
            } else {
                CustomObjectOutputStream oos = null;
                oos = new CustomObjectOutputStream(fos);
                oos.writeObject(foundObj);
                oos.close();
            }

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
            while (fis.available() != 0) {
                obj = ois.readObject();
                dogObject = (FoundDog) obj;

                if (dogObject.getUid().equals(uid)) {
                    ois.close();
                    return dogObject;
                }
            }

            // close reader
            ois.close();
            // return list;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
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
            while (fis.available() != 0) {
                obj = ois.readObject();
                FoundDog item = (FoundDog) obj;
                list.add(item);
            }

            // close reader
            ois.close();
            return list;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return list;
        }
    }

    @Override
    public void update(Double uid, FoundDog obj) {
        try {
            List<FoundDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid().equals(uid)) {
                    list.set(i, obj);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Double uid) {
        try {
            List<FoundDog> list = readAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUid().equals(uid)) {
                    list.remove(i);
                }
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
            for (int i = 0; i < list.size(); i++) {
                create(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
