package bangbang.Sensors;

import bangbang.BBController;
import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

/**
 * Created by mod on 12/7/15.
 */
public class DistanceSensors extends DifferentialWheels {
    private DistanceSensor[] sensors;
    private static int DS_NNO = 0; // Sensor left
    private static int DS_NO = 1;
    private static int DS_O = 2; // Sensor front left
    private static int DS_SO = 3;

    private static int DS_NNW = 4; // Sensor left
    private static int DS_NW = 5;
    private static int DS_W = 6; // Sensor front left
    private static int DS_SW = 7;


    public DistanceSensors(){
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

    public DistanceSensor getSensor(DS sensor){
        switch (sensor){
            case NNO:
                return sensors[DS_NNO];
            case NO:
                return sensors[DS_NO];
            case O:
                return sensors[DS_O];
            case SO:
                return sensors[DS_SO];
            case NNW:
                return sensors[DS_NNW];
            case NW:
                return sensors[DS_NW];
            case W:
                return sensors[DS_W];
            case SW:
                return sensors[DS_SW];
            default:
                return null;
        }
    }

}
