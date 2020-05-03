package test.java;

import main.things.Bed;
import main.things.Loveseat;
import main.things.Thing;
import main.things.Wardrobe;
import org.junit.*;

public class TestsForThings {
    @Test
    public void testForBed(){
        Thing bed = new Bed(2,1,1,"кровать");
        Assert.assertNotNull(bed);
        Assert.assertFalse(bed.isFire());
        bed.setFire(true, 0);
        Assert.assertTrue(bed.isFire());
        Assert.assertEquals(0.0, bed.getQ(0), 0.001);
        Assert.assertEquals(350, bed.getQ(700), 0.001);
        Assert.assertEquals(350.0/2, bed.getQ(350), 0.001);
        Assert.assertEquals(350, bed.getQ(1000), 0.001);
        Assert.assertEquals(350.0/2, bed.getQ(1150), 0.001);
        Assert.assertEquals(0, bed.getQ(1500), 0.001);
    }

    @Test
    public void testForLoveseat(){
        Thing loveseat = new Loveseat(1.6, 1, 1, "кресло");
        Assert.assertNotNull(loveseat);
        Assert.assertFalse(loveseat.isFire());
        loveseat.setFire(true, 0);
        Assert.assertTrue(loveseat.isFire());
        Assert.assertEquals(0.0, loveseat.getQ(0), 0.001);
        Assert.assertEquals(900, loveseat.getQ(350), 0.001);
        Assert.assertEquals(450, loveseat.getQ(350/2), 0.001);
        Assert.assertEquals(900, loveseat.getQ(360), 0.001);
        Assert.assertEquals(450, loveseat.getQ(950), 0.001);
        Assert.assertEquals(0, loveseat.getQ(1600), 0.001);
    }

    @Test
    public void testForWardrobe(){
        Thing wardrobe = new Wardrobe(1.6, 1, 1, "кресло");
        Assert.assertNotNull(wardrobe);
        Assert.assertFalse(wardrobe.isFire());
        wardrobe.setFire(true, 0);
        Assert.assertTrue(wardrobe.isFire());
        Assert.assertEquals(0.0, wardrobe.getQ(0), 0.001);
        Assert.assertEquals(1400, wardrobe.getQ(200), 0.001);
        Assert.assertEquals(700, wardrobe.getQ(100), 0.001);
        Assert.assertEquals(1400, wardrobe.getQ(500), 0.001);
        Assert.assertEquals(700, wardrobe.getQ(700 + 1300/2), 0.001);
        Assert.assertEquals(0, wardrobe.getQ(2100), 0.001);
    }
}
