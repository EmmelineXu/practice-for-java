public class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";


    public int getSpeed(){
        return speed;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }

    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public void setOn(boolean newOn){
        on = newOn;
    }
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public void setColor(String newColor){
        color = newColor;
    }

    Fan(){
    }

    Fan(int speed, boolean on, String color, double radius){

    }
    public void toString1(){
        if (on)
            System.out.print(speed + " " + color + " " + radius);
        else
            System.out.print(color + " " + radius);
    }
}

class TestFan {
    public static void main(String[]args){

        Fan object1 = new Fan();
        object1.setSpeed(Fan.FAST);
        object1.setRadius(10);
        object1.setColor("yellow");
        object1.setOn(true);

        Fan object2 = new Fan();
        object2.setSpeed(Fan.MEDIUM);
        object2.setRadius(5);
        object2.setColor("blue");
        object2.setOn(false);

        //display the result
        object1.toString1();
        System.out.println();
        object2.toString1();
    }
}

