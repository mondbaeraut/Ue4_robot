import Controller.BBController;
import Sensors.DS;
import Sensors.DistanceSensors;

/**
 * Created by mod on 12/7/15.
 */
public class BB_WallGrind extends BBController{
    private DistanceSensors distanceSensors;
    private static final int maxdistanceEast = 200;
    private static final int maxdistanceNorth = 200;
    private static int TIME_STEP = 16;
    public BB_WallGrind() {
        distanceSensors = new DistanceSensors();
    }



    public static void main(String[] args) {
        BB_WallGrind wallgrind = new BB_WallGrind();
        wallgrind.run();
    }

    @Override
    public void run() {
        while (step(TIME_STEP) != -1){
            if(distanceSensors.getSensor(DS.W).getValue() == maxdistanceEast){
                driveForward();
            } else if(distanceSensors.getSensor(DS.NNW).getValue() <=maxdistanceNorth && distanceSensors.getSensor(DS.NNO).getValue() <= maxdistanceNorth){
                driveRight();
            } else{
                driveLeft();
            }
        }

    }
}
