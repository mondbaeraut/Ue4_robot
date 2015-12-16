

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_BalanceBall{
    private DistanceSensors distanceSensors;
    private static final int maxdistanceWest = 3000;
    private static final int maxdistanceNorth = 2700;
    private static int TIME_STEP = 16;
    private Robot robot;

    public BB_BalanceBall() {
        robot = new Robot();
        robot.initDS();
    }



    public static void main(String[] args) {
        BB_BalanceBall wallgrind = new BB_BalanceBall();
        wallgrind.run();
    }

    public void run() {
        while (robot.step(TIME_STEP) != -1){
            if(robot.getDSSensor("NNO").getValue() > 1500 && robot.getDSSensor("NNW").getValue() > 1500){
                robot.driveForwardSlow();
            }else if(robot.getDSSensor("NNO").getValue() > 1500 && robot.getDSSensor("NNW").getValue() < 1500){
                robot.driveLeft();
            }
            else if(robot.getDSSensor("NNO").getValue() < 1500 && robot.getDSSensor("NNW").getValue() > 1500){
                robot.driveRight();
            } else{
                robot.driveForward();
            }
        }

    }
}
