import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.LightSensor;

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
    public LightSensor[] getLSSensors(){
        return lightSensors.getAll();
    }
    public LightSensor getLSSensor(String sensor){
        return lightSensors.getSensor(sensor);
    }
    private static int MIN_SPEED = 0;
    private static int SLOW_SPEED = 500;
    private static int MAX_SPEED = 1000;

    public void rotateLeft(){
        setSpeed(MIN_SPEED, MAX_SPEED);
    }
    public void rotateRight(){
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
