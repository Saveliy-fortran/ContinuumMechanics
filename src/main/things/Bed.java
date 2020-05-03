package main.things;

public class Bed extends Thing {
    public Bed(double diametr, double x, double y, String name) {
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
        } else if (currentTimeForFire > 0 && currentTimeForFire < 700) {
            return currentTimeForFire*1.0/2;
        } else if (currentTimeForFire >= 700 && currentTimeForFire <= 1050){
            return 350 ;
        } else if (currentTimeForFire > 1050 && currentTimeForFire <= 1250){
            return -currentTimeForFire*7.0 / 4 + (7*1250.0/4);
        } else if (currentTimeForFire > 1250){
            System.out.println("Потух: " + name + " Время: " + time);
            return 0;
        } else {
            return 0;
        }
    }
}
