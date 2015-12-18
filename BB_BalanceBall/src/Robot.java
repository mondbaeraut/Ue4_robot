import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LightSensor;

/**
 * Created by mod on 12/18/15.
 */
public abstract class Robot extends DifferentialWheels{
    private DistanceSensors distanceSensors = null;
    private LightSensors lightSensors = null;

    public void initDS() {
        distanceSensors = new DistanceSensors(this);
    }

    public void initLS() {
        lightSensors = new LightSensors(this);
    }

    public double[] getDSSensors() {
        return distanceSensors.getAllValue();
    }

    public double getDSSensorValue(String sensor) {
        return distanceSensors.getSensorValue(sensor);
    }

    public double getSmoothDSSensorValue(String sensor) {
        return distanceSensors.getSmoothSensorValue(sensor);
    }
    
    public double[] getLSSensors() {
        return lightSensors.getAllValue();
    }

    public double getLSSensor(String sensor) {
        return lightSensors.getSensor(sensor);
    }

    abstract void left();

    abstract void right();

    abstract void forward();

    abstract void slowForward();

    abstract void backward();

    abstract void stop();

    abstract void scan();
}
