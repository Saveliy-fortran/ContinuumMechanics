package main.things;

import main.things.Thing;

public class Wardrobe extends Thing {
    public Wardrobe(double diametr, double x, double y, String name) {
        super(diametr, x, y, name);
    }

    @Override
    public double getQ(int time) {
        int currentTimeForFire = time-timeForFire;
        if (isFire() == false){
            return 0;
        }
        if (currentTimeForFire == 0){
            return 0;
        } else if (currentTimeForFire > 0 && currentTimeForFire < 200) {
            return currentTimeForFire * 7;
        } else if (currentTimeForFire >= 200 && currentTimeForFire <= 700){
            return 1400 ;
        } else if (currentTimeForFire > 700 && currentTimeForFire <= 2000){
            return -currentTimeForFire * 14.0/13 + 14*2000.0/13;
        } else if (currentTimeForFire > 2000){
            System.out.println("Потух: " + name + " Время: " + time);
            return 0;
        } else {
            return 0;
        }
    }
}
