package models;

import java.util.ArrayList;

public class Squad {
    private String Sname;
    private int maxsize;
    private String reason;
    private int squadId;
    private static ArrayList<Squad> instances =new ArrayList<>();


    public Squad(String Sname,String reason){
        this.Sname=Sname;
        instances.add(this);
        this.maxsize=maxsize;
        this.reason=reason;
        this.squadId=instances.size();
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
    public int getSquadId(){return squadId;}

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }
    public static ArrayList<Squad>getAll(){
        return instances;
    }
    public static Squad findSquadId(int squadId){return instances.get(squadId-1);}
}
