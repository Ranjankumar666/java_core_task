package src.question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoxTest {
    @Test
    public void checkBox() {
        int length = 10;
        int breadth = 20;

        int expectedArea = length * breadth;

        Box box = new Box(length, breadth);
        assertEquals(expectedArea, box.area());
    }

    @Test
    public void checkBox3d() {
        int length = 10;
        int breadth = 20;
        int height = 30;

        Box3d box = new Box3d(length, breadth, height);

        int expectedVolume = length * breadth * height;
        int expectedArea = 2 * (length * breadth + breadth * height + length * height);

        assertEquals(expectedVolume, box.volume());
        assertEquals(expectedArea, box.area());
    }

}
