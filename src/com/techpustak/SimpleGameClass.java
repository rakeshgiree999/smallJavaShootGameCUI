package com.techpustak;
class User{
    String name;
    String gunInHand = "Akm";
    boolean alive=true;
    int health = 100;
    int morePower = 0;
    int totalShots = 0;
    
    public void addUser(String name, int morePower){
        this.name = name;
        this.morePower = morePower;
    }

    public void addUser(String name){
        this.name = name;
    }

    public int getHealthStatus(){
        return health;
    }

    public int getMorePowerStatus(String name){
        return morePower;
    }

    public void decreaseHealth(String gunName){
        int n = getGunDamage(gunName);
        health = health -n;
    }

    public boolean isUserAlive(){
        if(health<=0){
            return false;
        }
        else{
            return true;
        }
    }

    public String getGunName(){
        return gunInHand;
    }

    public void changeGun(String gunName){
        this.gunInHand = gunName;
    }

    public int getGunDamage(String gunName){
        if(gunName=="Akm"){
            return 20;
        }
        else if(gunName=="M14"){
            return 25;
        }
        else{
            return 0;
        }
    }

    public int countShot(){
        totalShots++;
        return totalShots;
    }
    
}