package employeeInformation;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/*
 * Класс Logger, реализующий интерфейс I_Logger. Реализуются чтение и загрузка данных в файл 
 * через указанный путь. 
 */
public class Logger implements I_Logger<HashSet<Employee>>{
    @Override
    public void save(String path, HashSet<Employee> data) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            for(Employee man : data){
                oos.writeObject(man);
            }
            oos.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }


    @Override
    public HashSet<Employee> load(String path) {
        HashSet<Employee> staff = new HashSet<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolean status = true;
            while (status) {
                try {
                    if(fis.available() != 0){
                    staff.add((Employee) ois.readObject()); 
                    } else {
                        status = false;
                    }  
                } catch (EOFException e) {
                    e.printStackTrace();
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staff;
    }
}
