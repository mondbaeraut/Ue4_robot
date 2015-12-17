import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;
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
    public DistanceSensor[] getDSSensors(){
        return distanceSensors.getAll();
    }
    public DistanceSensor getDSSensor(String sensor){
        return distanceSensors.getSensor(sensor);
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

    public void left(){
        setSpeed(-MAX_SPEED, MAX_SPEED);
    }
    public void right(){
        setSpeed(MAX_SPEED, -MAX_SPEED);
    }
    public void forward(){
        setSpeed(MAX_SPEED, MAX_SPEED);
    }
    public void forwardSlow(){setSpeed(SLOW_SPEED, SLOW_SPEED);}
    public void backward(){
        setSpeed(-MAX_SPEED, -MAX_SPEED);
    }
    public void stop(){
        setSpeed(MIN_SPEED, MIN_SPEED);
    }
    public void scan() { setSpeed(-SLOW_SPEED,MAX_SPEED);}
}
