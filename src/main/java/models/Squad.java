package models;

import java.util.ArrayList;

public class Squad {
    private String Sname;
    private int maxsize;
    private String reason;
    private int squadId;
    private static ArrayList<Squad> sInstances =new ArrayList<>();


    public Squad(String sname,int maxsize,String reason){
        this.Sname=Sname;
        this.maxsize=maxsize;
        this.reason=reason;
        sInstances.add(this);
        this.squadId=sInstances.size();
    }

    public String getSname(){
        return Sname;
    }
    public int getMaxsize(){
        return maxsize;
    }
    public String getReason(){
        return reason;
    }

    public void setSname(String Sname){
        this.Sname=Sname;
    }
    public void setMaxsize(int maxsize){
        this.maxsize=maxsize;
    }
    public void setReason(String reason){
        this.reason=reason;
    }
    public int getHeroId(){return squadId;}

    public void setHeroId(int squadId) {
        this.squadId = squadId;
    }
    public static ArrayList<Squad>getAll(){
        return sInstances;
    }
    public static Squad findHeroId(int squadId){return sInstances.get(squadId-1);}
}
