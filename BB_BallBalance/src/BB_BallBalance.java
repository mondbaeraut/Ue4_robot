

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_BallBalance {
    private DistanceSensors distanceSensors;
    private static final int maxdistanceWest = 3000;
    private static final int maxdistanceNorth = 2700;
    private static int TIME_STEP = 16;
    private Robot robot;

    public BB_BallBalance() {
        robot = new Robot();
        robot.initDS();
    }



    public static void main(String[] args) {
        BB_BallBalance wallgrind = new BB_BallBalance();
        wallgrind.run();
    }

    public void run() {
        while (robot.step(TIME_STEP) != -1){
            if(robot.getDSSensor("W").getValue() < 100 || robot.getDSSensor("NNW").getValue() < 100 || robot.getDSSensor("NNO").getValue() < 100){
                robot.driveForward();
                System.out.println("drive forward");
            } else if(robot.getDSSensor("W").getValue() ==  50 && robot.getDSSensor("NNW").getValue() <100){
                robot.driveForward();
                System.out.println("parallel to wall");
            } else {
                robot.driveRight();
                System.out.println("rotate right");
            }
        }

    }
}
