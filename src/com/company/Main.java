package com.company;
import java.util.Scanner;
import static com.company.LogisticSystem.addUser;
import static com.company.LogisticSystem.FindUser;
import static com.company.LogisticSystem.FindLoadUser;
import static com.company.LogisticSystem.SaveSerializable;
import static com.company.LogisticSystem.LoadSerializable;
import static com.company.Map.addBackup;
import static com.company.Map.addEdge;
import static com.company.Map.generatePath;



public class Main {
    public static void main(String[] args){

	System.out.println("Добро пожаловать в интерфейс для входа в систему. Выберите дальнейшее действие:");
	Scanner in = new Scanner(System.in);
	Scanner case1 = new Scanner(System.in);
	Scanner case2 = new Scanner(System.in);
	Scanner casemap1 = new Scanner(System.in);
	Scanner casemap2 = new Scanner(System.in);
	int y;
	while(true){//Основное меню'
        System.out.println("1. Войти в систему");
        System.out.println("2. Регистрация");
        System.out.println("3. Выйти из системы");
        User.Admin admin = new User.Admin(" ", " ");
	    y = in.nextInt();
        boolean d = true;
	    switch(y){
	        case 1: //Авторизация пользователя
	                System.out.println("Введите ваш логин и пароль:");
                    System.out.println("Логин: "); String login1 = case1.nextLine();
                    System.out.println("Пароль: "); String password1 = case1.nextLine();
                        if(admin.getLogin().equals(login1) && admin.getPassword().equals(password1)){//авторизация для администратора
                            while(d){
                                System.out.println("1. Добавить инфомрацию о пробке");
                                System.out.println("2. Добавь связь между двумя районами");
                                System.out.println("3. Поиск подходящего маршрута");
                                System.out.println("4. Вернутся назад");
                                y = in.nextInt();
                                switch(y) {
                                    case 1:
                                        System.out.println("Точка№1: "); String place3 = casemap1.next();
                                        System.out.println("Точка№2: "); String place4 = casemap1.next();
                                        System.out.println("Бал загруженности"); int backup = casemap1.nextInt();
                                        addBackup(place3, place4, backup);
                                        break;
                                    case 2:
                                        System.out.println("Точка№1: "); String place1 = casemap2.next();
                                        System.out.println("Точка№2: "); String place2 = casemap2.next();
                                        addEdge(place1, place2, -1);
                                        break;
                                    case 3:
                                        System.out.println("Откуда вы хотите отправиться?"); String place5 = casemap2.next();
                                        System.out.println("Куда вы хотите отправится?"); String place6 = casemap2.next();
                                        generatePath(place5, place6);
                                        break;
                                    case 4: d = false;
                                        break;
                                }
                            }
                        }
                        else if (!FindUser(login1, password1)){
                            System.out.println("Вы ввели не правильный логин и пароль, повторите попытку");
                        }
                        else{ //обычный пользваотелей
                            while(d){
                                System.out.println("1. Добавить инфомрацию о пробке");
                                System.out.println("2. Поиск подходящего маршрута");
                                System.out.println("3. Вернутся назад");
                                y = in.nextInt();
                                switch(y) {
                                    case 1:
                                        System.out.println("Точка№1: "); String place3 = casemap1.next();
                                        System.out.println("Точка№2: "); String place4 = casemap1.next();
                                        System.out.println("Бал загруженности"); int backup = casemap1.nextInt();
                                        addBackup(place3, place4, backup);
                                        break;
                                    case 2:
                                        System.out.println("Откуда вы хотите отправиться?"); String place5 = casemap2.next();
                                        System.out.println("Куда вы хотите отправится?"); String place6 = casemap2.next();
                                        generatePath(place5, place6);
                                        break;
                                    case 3:
                                        d = false;
                                        break;
                                }
                            }
                        }
	            break;
            case 2: //Регистрация пользователя
                    System.out.println("Добро пожаловать в интерфейс регистрации пользователя. Введите ваше Имя, логин и пароль");
                    System.out.println("Имя: "); String name = case2.nextLine();
                    System.out.println("Логин: "); String login2 = case2.nextLine();
                        if(name.equals(login2)){
                            System.out.println("Имя не может быть такое же как и логин, попробуйте в следующий раз");
                            break;
                        }
                    System.out.println("Пароль: "); String passowd2 = case2.nextLine();
                        if (FindLoadUser(login2, passowd2)) {
                            System.out.println("Пользователь с таким логином или паролем уже существует");
                            break;
                        }
                    addUser(name, login2, passowd2); //Добавление пользователя
                    SaveSerializable(); //Запись сериализованного файла
                    LoadSerializable();//Загрузка секриализованного файла
                break;
            case 3: //Выход из программы
                    System.exit(0);
                break;
        }
	}
    }


}
