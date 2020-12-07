package Functional;

import java.io.*;

public class RWHelper {
    public static void Write(Object obj) {
        try {
            FileOutputStream fos = new FileOutputStream("Shape.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }
        catch (IOException ex){
            System.out.println("File is not found!");
            ex.printStackTrace();
        }
    }

    public static Object Read() {
        try {
            FileInputStream fis = new FileInputStream("Shape.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Object) ois.readObject();
        }
        catch (IOException ex){
            System.out.println("File is not found!");
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
