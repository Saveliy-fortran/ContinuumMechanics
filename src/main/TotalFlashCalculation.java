package main;

import main.things.Thing;
import main.room.Room;


import static java.lang.Math.*;

public class TotalFlashCalculation {

    //Берем объекты и размещаем их в комнате
    private Thing thing1;
    private Thing thing2;
    private Thing thing3;
    private Room room;
    private int timeStep;
    private int time = 0;
    private final int timeFirefighter = 1200;
    private double QCommon = 0;

    public TotalFlashCalculation(Thing thing1, Thing thing2, Thing thing3, int timeStep, Room room) {
        this.thing1 = thing1;
        this.thing2 = thing2;
        this.thing3 = thing3;
        this.timeStep = timeStep;
        this.room = room;
    }
    // Необходимо передать предмет который мы зажигаем
    public void play(Thing thing){
        thing.setFire(true,time);
        System.out.println("Вы подожгли " + thing.getName());
        while (QCommon < room.qForCommonFlash(time)){
            QCommon = getQCommonFor3Things(thing1,thing2,thing3, time);
            //System.out.println("Время="+time+" Q=" + QCommon + " Q0 необходимое для вспышки = " + room.qForCommonFlash(time));
            if (QCommon > room.qForCommonFlash(time)){
                System.out.println("Наступила общая вспышка! Время: " + time);
                break;
            }

            setFireAll(thing1,thing2,thing3, time);
            time += timeStep;
            if (time >= timeFirefighter){
                System.out.println("Приехала пожарная бригада! Время: " + time);
                break;
            }
        }

    }

    private void setFireAll(Thing thing1, Thing thing2, Thing thing3, int time){
        setFireForThing(thing1, thing2, thing3, time);
        setFireForThing(thing1, thing3, thing2, time);
        setFireForThing(thing2, thing3, thing1, time);
    }

    private void setFireForThing(Thing thing1, Thing thing2, Thing thing3, int time){
        if (thing3.isFire() == true){
            return;
        }
        double qExt1 = radiantStreamFromOneSubjectToAnother(thing1,thing3,time); // первое горит третье получает
        double qExt2 = radiantStreamFromOneSubjectToAnother(thing2,thing3,time); // второе горит третье получает

        if (qExt1 + qExt2 >= 20){
            System.out.println("Загорелся " + thing3.getName() + " . Время: " + time);
            thing3.setFire(true, time);
        }
    }

    private double getQCommonFor3Things(Thing thing1, Thing thing2, Thing thing3, int time){
        double Q = thing1.getQ(time) + thing2.getQ(time) + thing3.getQ(time);
        return Q;
    }

    private double radiantStreamFromOneSubjectToAnother(Thing thing1, Thing thing2, int time){
        double qEx = thing1.getQ(time)/(4*PI*pow(getR(thing1,thing2,time),2));
        return qEx;
    }

    private double getR(Thing thing1, Thing thing2, int time){
        double r = sqrt(pow(thing1.getX() - thing2.getX(),2) + pow(thing1.getY() - thing2.getY(),2))-thing2.getDiametr()/2;
        double R = sqrt(pow(getLf(thing1, time)/2, 2) + pow(r,2) );
        return R;
    }

    private double getLf(Thing thing, int time){
        return 0.235*pow(thing.getQ(time), 2.0/5) - 1.02*thing.getDiametr();
    }

}
