package main.things;

public class Loveseat extends Thing {
    public Loveseat(double diametr, double x, double y, String name) {
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
        } else if (currentTimeForFire > 0 && currentTimeForFire < 350) {
            return currentTimeForFire*18.0/7;
        } else if (currentTimeForFire >= 350 && currentTimeForFire <= 400){
            return 900 ;
        } else if (currentTimeForFire > 400 && currentTimeForFire <= 1500){
            return -currentTimeForFire*9.0 / 11 + (9*1500.0/11);
        } else if (currentTimeForFire > 1500){
            System.out.println("Потух: " + name + " Время: " + time);
            return 0;
        } else {
            return 0;
        }
    }
}
