import com.cyberbotics.webots.controller.LightSensor;

/**
 * Created by mod on 12/7/15.
 */
public class LightSensors {
    private static int LS_N = 0; // Sensor left
    //private static int LS_NNO = 1;
    private static int LS_NO = 1; // Sensor front left
    private static int LS_O = 2;
    private static int LS_SO = 3;
    private static int LS_S = 4;

    private static int LS_SW = 5; // Sensor left
    private static int LS_W = 6;
    private static int LS_NW = 7; // Sensor front left
    private LightSensor[] sensors;

    private int sensorenableinitvalue = 10;
    private Robot robot = null;

    public LightSensors(Robot robot) {
        this.robot = robot;
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
        for(LightSensor sensor:sensors){
            sensor.enable(sensorenableinitvalue);
        }
    }
    public LightSensor getSensor(String sensor){
        switch (sensor){
            case "N":
                return sensors[LS_N];
            case "NO":
                return sensors[LS_NO];
            case "O":
                return sensors[LS_O];
            case "SO":
                return sensors[LS_SO];
            case "S":
                return sensors[LS_S];
            case "SW":
                return sensors[LS_SW];
            case "W":
                return sensors[LS_W];
            case "NW":
                return sensors[LS_NW];
            default:
                return null;
        }
    }

    public LightSensor[] getAll() {
        return sensors;
    }
}
