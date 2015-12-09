package bangbang.Controller;

import bangbang.BBController;
import bangbang.Sensors.DS;
import bangbang.Sensors.DistanceSensors;

/**
 * Created by mod on 12/7/15.
 */
public class BB_WallGrind extends BBController{
    private DistanceSensors distanceSensors;

    public BB_WallGrind() {
        distanceSensors = new DistanceSensors();
    }

    @Override
    public void run() {
        if(distanceSensors.getSensor(DS.NNO).getValue() < 100){
            driveRight();
        }else {
            driveForward();
        }
    }

    public static void main(String[] args) {
        BB_WallGrind wallGrind = new BB_WallGrind();
        wallGrind.run();
    }
}
