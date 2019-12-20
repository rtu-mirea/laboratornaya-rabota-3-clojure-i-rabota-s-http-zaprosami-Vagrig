package com.company;

import java.util.List;
import java.util.ArrayList;


class Map {
    private static List<Edge> edge = new ArrayList<>();

    static void addEdge(String place1, String place2, int backup){//Добавить связь между двумя районами
        backup = -1;
        edge.add(new Edge(place1, place2, backup));
    }

    static void addBackup(String place1, String place2, int backup){//Добавить информацию о пробке
        for(Edge u : edge){
            if(u.getPoint1().equals(place1) && u.getPoin2().equals(place2)){
                if (backup > 10){
                    System.out.println("Максимальный бал пробки составляет 10");
                    break;
                }
                u.setBackup(backup);
            }
        }
    }

    static int AverageBackup(){
        int a = edge.size();
        int sum =0;
        for(Edge u: edge){
            sum +=u.getBackup();
        }
        return sum/a;
    }

    static void generatePath(String place1, String place2){
        List<Edge> Path = new ArrayList<>();
        for(Edge u : edge) {
            if (u.getPoint1().equals(place1) && u.getPoin2().equals(place2)) {
                System.out.println(u.getBackup());
            }
        }
    }
}
