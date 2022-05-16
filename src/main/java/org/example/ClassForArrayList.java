package org.example;

import java.util.ArrayList;


public class ClassForArrayList {
    static ArrayList<City> cities = new ArrayList<City>();
    ClassForArrayList(){}
    public void buildCitiesList() {
        cities.add(new City(3,"Toronto",15.9));
        cities.add(new City(33,"Milan",25.94));
        cities.add(new City(55,"Rome",35.4));
    }
    public  String sorted_By_Name(){
        cities.sort((City c1, City c2)->c1.name.compareTo(c2.name));
        String result="";
        for (int i = 0; i < cities.size(); i++) {
            result=result+"\n"+cities.get(i).toString();
        }
        return result;
    }

    public String hottest(){
        cities.sort((City s1, City s2)-> (int) (s2.temp-s1.temp));
        return cities.get(0).toString();
    }

    public String sorted_By_Temp(){
        cities.sort((City s1, City s2)-> (int) (s1.temp-s2.temp));
        String result="";
        for (int i = 0; i < cities.size(); i++) {
            result=result+"\n"+cities.get(i).toString();
        }

        return result;
    }

    public String all(){
        String result="";
        for (int i = 0; i < cities.size(); i++) {
            result=result+"\n"+cities.get(i).toString();
        }
        System.out.println(result);
        return result;
    }
}
