package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String SpecialPower;
    private String weakness;
    private int heroId;
    private String league;
    private static ArrayList<Hero>instances =new ArrayList<>();


    public Hero(String name,int age,String weakness,String SpecialPower,String league){
        this.name=name;
        this.age=age;
        this.weakness=weakness;
        this.SpecialPower=SpecialPower;
        this.league=league;
        instances.add(this);

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
    public int getHeroId(){return heroId;}

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }
    public String getLeague(){
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public static ArrayList<Hero>All(){
        return instances;
    }
    public static Hero findId(int heroId){return instances.get(heroId-1);}
    public void delHero(){
        instances.remove(heroId-1);

    }
}
