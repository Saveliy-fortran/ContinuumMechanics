package main;

import main.things.Bed;
import main.things.Loveseat;
import main.things.Thing;
import main.things.Wardrobe;
import main.room.Room;

public class StartCalculation {
    public static void main(String[] args) {
        Thing bed = new Bed(2,1.5, 2.1, "Кровать");
        Thing loveseat = new Loveseat(0.6, 2.7, 2.7, "Кресло для двоих");
        Thing wardrobe = new Wardrobe(0.3, 0.15, 2.85, "Стул" );

        Room room = new Room(500, 0.1, 1000, 0.05, 2, 3, 3, 1, 2);

        TotalFlashCalculation calculation = new TotalFlashCalculation(bed,loveseat,wardrobe,10, room);
        calculation.play(wardrobe);

    }

}
