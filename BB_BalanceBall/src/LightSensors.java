import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LightSensor;

/**
 * Created by mod on 12/7/15.
 */
public class LightSensors {
    // private static final int LS_N = 0; // Sensor left
    private static int LS_NNO = 0; // Sensor left
    private static int LS_NO = 1;
    private static int LS_O = 2; // Sensor front left
    private static int LS_SO = 3;

    private static int LS_NNW = 7; // Sensor left
    private static int LS_NW = 6;
    private static int LS_W = 5; // Sensor front left
    private static int LS_SW =4;
    private LightSensor[] sensors;

    private static final int sensorenableinitvalue = 10;
    private double[] allValue;


    public LightSensors(Robot robot) {
        sensors = new LightSensor[]{
                robot.getLightSensor("ls0"),
                robot.getLightSensor("ls1"),
                robot.getLightSensor("ls2"),
                robot.getLightSensor("ls3"),
                robot.getLightSensor("ls4"),
                robot.getLightSensor("ls5"),
                robot.getLightSensor("ls6"),
                robot.getLightSensor("ls7"),

        };
        for (LightSensor sensor : sensors) {
            sensor.enable(sensorenableinitvalue);
        }
    }

    public double getSensor(String sensor) {
        switch (sensor) {
            case "NNO":
                return sensors[LS_NNO].getValue();
            case "NO":
                return sensors[LS_NO].getValue();
            case "O":
                return sensors[LS_O].getValue();
            case "SO":
                return sensors[LS_SO].getValue();
            case "NNW":
                return sensors[LS_NNW].getValue();
            case "NW":
                return sensors[LS_SW].getValue();
            case "W":
                return sensors[LS_W].getValue();
            case "SW":
                return sensors[LS_NW].getValue();
            default:
                return 0.;
        }
    }
    public double[] getAllValue() {
        double[] values = new double[8];
        DistanceSensor ds;
        for(int i = 0; i < sensors.length;i++){
            values[i] = sensors[i].getValue();
        }
        return values;
    }
}
