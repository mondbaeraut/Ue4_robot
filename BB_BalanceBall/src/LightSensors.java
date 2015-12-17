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

    public LightSensor getSensor(String sensor) {
        switch (sensor) {
            case "NNO":
                return sensors[LS_NNO];
            case "NO":
                return sensors[LS_NO];
            case "O":
                return sensors[LS_O];
            case "SO":
                return sensors[LS_SO];
            case "NNW":
                return sensors[LS_NNW];
            case "NW":
                return sensors[LS_SW];
            case "W":
                return sensors[LS_W];
            case "SW":
                return sensors[LS_NW];
            default:
                System.out.println("Default taken");
                return sensors[LS_NW];
        }
    }

    public LightSensor[] getAll() {
        return sensors;
    }
}
