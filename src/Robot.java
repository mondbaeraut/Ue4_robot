import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class Robot extends DifferentialWheels {
    private DistanceSensors distanceSensors = null;
    private LightSensors lightSensors = null;
    public Robot(){
        super();
    }

    public void initDS(){
       distanceSensors = new DistanceSensors(this);
    }
    public void initLS(){
        lightSensors = new LightSensors(this);
    }
    public DistanceSensor getDSSensor(String sensor){
        return distanceSensors.getSensor(sensor);
    }
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
}
