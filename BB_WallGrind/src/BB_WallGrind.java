

/**
 * Created by mod on 12/7/15.
 */
public class BB_WallGrind {
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
        boolean wallfound = false;
        while (robot.step(TIME_STEP) != -1) {
            if (wallfound) {
                if (positionParallelToWall()) {
                    robot.forward();
                    if(wallfound()){
                        robot.backward();
                        robot.right();
                    }
                } else {
                    robot.backward();
                }
            } else {
                robot.forward();
                wallfound = wallfound();
            }

        }

    }

    private boolean positionParallelToWall() {
        int smoothvaluewest = smooth(robot.getDSSensor("W").getValue());
        robot.forward();
        if (robot.getDSSensor("W").getValue() == 50) {
            return true;
        } else if (smoothvaluewest < 50) {
            robot.right();
            return false;
        }
        return false;
    }

    public boolean wallfound() {
        if (smooth(robot.getDSSensor("NNO").getValue()) > 50 && smooth(robot.getDSSensor("NNW").getValue()) > 50) {
            return true;
        }
        return false;
    }

    private int smooth(double input) {
        if (input > 50) {
            return 100;
        } else {
            return 0;
        }
    }
}
