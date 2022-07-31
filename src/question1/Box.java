package src.question1;

public class Box {
    public int length;
    public int breadth;

    Box(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return length * breadth;
    }
}

class Box3d extends Box {
    public int height;

    Box3d(int length, int breadth, int height) {
        super(length, breadth);
        this.height = height;
    }

    @Override
    public int area() {
        return 2 * (length * breadth + breadth * height + height * length);
    }

    public int volume() {
        return length * breadth * height;
    }

}
