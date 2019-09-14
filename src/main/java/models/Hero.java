package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String SpecialPower;
    private String weakness;
    private int heroId;
    private static ArrayList<Hero>instances =new ArrayList<>();


    public Hero(String name,int age,String SpecialPower,String weakness){
        this.name=name;
        this.age=age;
        this.weakness=weakness;
        this.SpecialPower=SpecialPower;
        this.heroId=instances.size();


    }

    public  String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public  String getSpecialPower(){
        return SpecialPower;
    }
    public void setSpecialPower(String SpecialPower){
        this.SpecialPower=SpecialPower;
    }
    public String getWeakness(){
        return weakness;
    }
    public void setWeakness(String weakness){
        this.weakness=weakness;
    }
    public  int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public static ArrayList<Hero>getAll(){
        return instances;
    }
}
