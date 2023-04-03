package config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config <T>{
    // Tạo Scanner để tái sử dung
    public static Scanner scanner(){
         Scanner scanner = new Scanner(System.in);
         return scanner;
    }
    // Tạo ra đường dẫn
    public static final String PATH_CATEGORY ="src/database/category.txt";
    //Đọc file với tham số generic
    public List<T> readFromFile(String pathFile){
        List<T> tList= new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            if (fileInputStream.available()!=0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList= (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        }catch (FileNotFoundException e){
            System.err.println("FileNotFoundException");
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("IOException");
        }catch (ClassNotFoundException e){
            System.err.println("ClassNotFoundException");
        }
        return tList;
    }
    //Ghi File với tham số generic--> cần truyền đường dẫn, và 1 danh sách để ghi ra
    public void writeToFile(String pathFile, List<T> tList){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (FileNotFoundException e){
            System.err.println("FileNotFoundException");
        }catch (IOException e){
            System.err.println("IOException");
        }
    }
}
