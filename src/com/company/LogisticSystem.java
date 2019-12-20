package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class LogisticSystem {
    private static List<User> users = new ArrayList<>(); //список пользователей
    private static List<String> lockfile = new ArrayList<>();

    static void addUser(String name, String login, String password){ //Добавление пользователя
            users.add(new User(name, login, password));

    }

    static boolean FindUser(String login, String password){ //Поиск пользователя по массиву пользователей
        for(User u: users){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    static boolean FindLoadUser(String login, String password){//Поиск пользователей по загруженному файлу
        int indexA = lockfile.indexOf(login);
        int indexB = lockfile.indexOf(password);
        for(int i = 0; i < lockfile.size(); i++){
            if(indexA == i && indexB == i+1){
                return true;
            }
        }
        return false;
    }

/*
    static void save() throws IOException { //Сохранение данных пользователя в файл
//        try {
//            FileWriter out = new FileWriter("Ussers.txt", true);
//            for (User u : users) {
//                out.append(u.getLogin()).append(" ");
//                out.append(u.getLogin()).append(" ");
//                out.append(u.getPassword()).append(" ");
//                out.append("\n");
//            }
//            out.close();
//        }
//        catch (IOException e){
//            System.out.println("Error: File already exists");
//        }
//    }
//
//    static void load() throws FileNotFoundException {//Чтение данных пользователя из файл
//        try {
//
//            Scanner in = new Scanner(new File("Ussers.txt"));
//            while (in.hasNext()) {
//                lockfile.add(in.next());
//            }
//        }
//        catch (FileNotFoundException e){
//            System.out.println("Error: File not found");
//        }
//    }
*/

    static void SaveSerializable() {//Сериализация файла - сохранение
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ListUssers"));
            oos.writeObject(users);
            oos.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: File not found");
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    static void LoadSerializable(){//Сериализация файла - загрузка
        try {
            FileInputStream fis = new FileInputStream("ListUssers");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        for(User ussers: users){
            System.out.println(ussers);
        }
    }
}



