import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class WallGrind extends DifferentialWheels{
    private DistanceSensors distanceSensors;
    private static final int maxdistanceEast = 200;
    private static final int maxdistanceNorth = 200;
    private static int TIME_STEP = 16;
    private DistanceSensor[] sensors;

    private static int MIN_SPEED = 0;
    private static int SLOW_SPEED = 500;
    private static int MAX_SPEED = 1000;

    public void driveLeft(){
        setSpeed(MIN_SPEED, MAX_SPEED);
    }
    public void driveRight(){
        setSpeed(MAX_SPEED, MIN_SPEED);
    }
    public void driveForward(){
        setSpeed(MAX_SPEED, MAX_SPEED);
    }
    public void driveForwardSlow(){setSpeed(SLOW_SPEED, SLOW_SPEED);}
    public void driveBackward(){
        setSpeed(-MAX_SPEED, -MAX_SPEED);
    }
    public void driveStop(){
        setSpeed(MIN_SPEED, MIN_SPEED);
    }

    public WallGrind() {
       super();
        sensors = new DistanceSensor[]{
                getDistanceSensor("ps0"),
               getDistanceSensor("ps1"),
                getDistanceSensor("ps2"),
                getDistanceSensor("ps3"),
                getDistanceSensor("ps7"),
                getDistanceSensor("ps6"),
                getDistanceSensor("ps5"),
                getDistanceSensor("ps4")
        };
        for(DistanceSensor sensor : sensors){
            sensor.enable(10);
        }
    }



    public static void main(String[] args) {
       WallGrind wallgrind = new WallGrind();
        wallgrind.run();
    }

    public void run() {
        while (step(TIME_STEP) != -1){
            if(sensors[1].getValue() == maxdistanceEast){
               driveForward();
            } else if(sensors[4].getValue() <=maxdistanceNorth && sensors[2].getValue() <= maxdistanceNorth){
                driveRight();
            } else{
                driveLeft();
            }
        }

    }
}
