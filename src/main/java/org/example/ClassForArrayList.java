package org.example;

import com.google.gson.Gson;

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
        Gson gson=new Gson();
        result=gson.toJson(cities);
        return result;
    }

    public String hottest(){
        cities.sort((City s1, City s2)-> (int) (s2.temp-s1.temp));
        Gson gson=new Gson();

        return gson.toJson(cities.get(0));
    }

    public String sorted_By_Temp(){
        cities.sort((City s1, City s2)-> (int) (s1.temp-s2.temp));
        String result="";
        Gson gson=new Gson();
        result=gson.toJson(cities);
        return result;
    }

    public String all(){
        String result="";
        Gson gson=new Gson();
        result=gson.toJson(cities);
        return result;
    }
}
