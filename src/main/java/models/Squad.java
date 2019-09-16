package models;

import java.util.ArrayList;

public class Squad {
    private String Sname;
    private int maxsize;
    private String reason;
    private int squadId;
    private static ArrayList<Squad>instances =new ArrayList<>();

    public Squad(String sname, int maxsize, String reason) {
        Sname = sname;
        this.maxsize = maxsize;
        this.reason = reason;
        this.squadId = squadId;
        instances.add(this);

        this.squadId=instances.size();
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Squad> instances) {
        Squad.instances = instances;
    }
    public static ArrayList<Squad>All(){
        return instances;
    }
    public static Squad findId(int heroId){return instances.get(heroId-1);}
    public void delHero(){
        instances.remove(squadId-1);

    }
}
