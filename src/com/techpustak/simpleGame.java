package com.techpustak;
import java.util.Random;
import java.util.Scanner;

// Creating class for all users with same properties
class simpleGame{

    private static int displayOptions(){
        System.out.println("Press 1 to shoot. ");
        System.out.println("Press 2 to get AKM in hand");
        System.out.println("Press 3 to get M14 in hand");
        Scanner ch1 =new Scanner(System.in);
        return ch1.nextInt();
    }

    private static boolean check(User u1, User u2){
        if(u1.isUserAlive()==false || u2.isUserAlive()==false){
            return false;
        }
        else{
             return true;
        }
    }

    private static void initiateGame(User u1, User u2){
        int chs = displayOptions();
        if(chs<1 || chs>4){
            System.out.println("Please Enter correct choice");
            chs = displayOptions();
        }

        if(chs==2 || chs==3){
            //SETTING GUN CHOOSEN BY USER
            if(chs==2){
                u1.changeGun("Akm"); 
                System.out.println(u1.getGunName() + "is in hand now.");
            }
            
            else if(chs==3){
                u1.changeGun("M14");
                System.out.println(u1.getGunName() + "is in hand now.");
            }
            else{}

            //RANDOM GUN FOR COMPUTER
            Random r = new Random();
            if(r.nextBoolean()==true) u2.changeGun("Akm");
            else u2.changeGun("M14");
        }

        if(chs==1){
            String gunName = u1.getGunName();
            u1.countShot();
            u2.decreaseHealth(gunName);
            if(check(u1, u2)==false){
                return;
            }
            else{

            }
            
            String gunName2 = u2.getGunName();
            u2.countShot();
            u1.decreaseHealth(gunName);
            if(check(u1, u2)==false){
                return;
            }
            else{

            }
            }
    }


    public static void main(String[] args) {

        int start=0;
while(start==0){
            Scanner sc = new Scanner(System.in);
            System.out.println("***************************************************************************");
            System.out.println("***                                                                     ***");
            System.out.println("***                            Press 1 to start                         ***");
            System.out.println("***                                                                     ***");
            System.out.println("***************************************************************************");
            start = sc.nextInt();
        }

        if(start==1){
            User user = new User();
            User compUser = new User();
            while(check(user, compUser)==true){
                initiateGame(user, compUser);
            }
            if(user.isUserAlive()==false){
                System.out.println("You won. You killed computer with " + user.countShot() + " and your remaining life is " + user.getHealthStatus());
            }
            if(compUser.isUserAlive()==false){
                System.out.println("Computer killed you with " + compUser.countShot() + " shots and remaining life of computer is " + compUser.getHealthStatus());
            }
        }
    }
}