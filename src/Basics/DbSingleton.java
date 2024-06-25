package Basics;

import java.io.*;
import java.lang.reflect.Constructor;

public class DbSingleton {

    public static void main(String args[]) throws Exception {
        DbFile dbFile = DbFile.getInstance();
        System.out.println("Singleton "+dbFile.hashCode());

//        Reflection Api
        /*
        Constructor<DbFile> constructor = DbFile.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DbFile dbFile2 = constructor.newInstance();
        System.out.println("Reflection "+dbFile2.hashCode());*/

//        Deserialization
        /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ob"));
        oos.writeObject(dbFile);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.ob"));
        DbFile dbFile2 = (DbFile) ois.readObject();
        System.out.println("Deserialization "+dbFile2.hashCode());*/

//        Cloning
        DbFile dbFile2 = (DbFile) dbFile.clone();
        System.out.println("Cloning "+dbFile2.hashCode());
    }
}


class DbFile implements Serializable, Cloneable{
    private static DbFile dbFile;
    private DbFile(){
//        Solution - Reflection -> throw the exception or use enum
        if(dbFile != null)
            throw new RuntimeException("Can not create object of DbFile");
    }

    public synchronized static DbFile getInstance(){
        if(dbFile == null)
            dbFile = new DbFile();
        return dbFile;
    }

//    Solution - Deserialization -> implement readResolve
    public Object readResolve(){
        return dbFile;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); // To get the different object
//        Solution - Cloning -> return static instance
        return dbFile;
    }
}