

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_WallGrind{
    private DistanceSensors distanceSensors;
    private static final int maxdistanceEast = 20;
    private static final int maxdistanceNorth = 20;

    private static int TIME_STEP = 16;
    private Robot robot;

    public BB_WallGrind() {
        robot = new Robot();
        robot.initDS();
    }



    public static void main(String[] args) {
        BB_WallGrind wallgrind = new BB_WallGrind();
        wallgrind.run();
    }

    public void run() {
        while (robot.step(TIME_STEP) != -1){
           if(robot.getDSSensor("NNW").getValue() <= maxdistanceNorth || robot.getDSSensor("NNO").getValue() <= maxdistanceNorth ){
                robot.driveRight();
            }else if(robot.getDSSensor("O").getValue() == maxdistanceEast){
                robot.driveForward();
            }else{
                robot.driveForward();
            }
            }

    }
}
