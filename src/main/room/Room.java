package main.room;

import static java.lang.Math.*;

public class Room {
    private double ro; // плотность материала стен
    private double lambda; // Теплопроводность материала стен
    private double c; // Удельная теплоёмкость материала стен
    private double tolchina; // толщина стен
    private double vysota; // высота комнаты
    private double hirina; // Ширина комнаты
    private double dlina; // Длинна комнаты
    private double hirinaProema; // Ширина отверстия
    private double vysotaProema; // Длинна отверстия

    public Room(double ro, double lambda, double c, double tolchina, double vysota, double hirina, double dlina, double hirinaProema, double vysotaProema) {
        this.ro = ro;
        this.lambda = lambda;
        this.c = c;
        this.tolchina = tolchina;
        this.vysota = vysota;
        this.hirina = hirina;
        this.dlina = dlina;
        this.hirinaProema = hirinaProema;
        this.vysotaProema = vysotaProema;
    }

    private double getTRel(){
        double Trel = pow(tolchina/2,2)*c*ro/lambda;
        //System.out.println("Trel = " + Trel);
        return Trel;
    }

    private double getHK(int time){
        if (time < getTRel()){
            return sqrt(lambda*ro*c/time);
        } else {
            return lambda/tolchina;
        }
    }

    public double qForCommonFlash(int time){
        double At = hirina*dlina*2 + 2*(dlina+hirina)*vysota - hirinaProema*vysotaProema;
        double A0 = hirinaProema*vysotaProema;
        return 610*sqrt(getHK(time)*At*A0*sqrt(vysotaProema));
    }
}
