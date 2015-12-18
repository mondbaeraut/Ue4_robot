

/**
 * Created by mod on 12/7/15.
 */
public class BB_WallGrind {
    private boolean isParallelToWall = false;
    private int cParrallel = 0;
    private static int TIME_STEP = 16;
    private Robot robot;
    private int counter = 0;
    private int counter2 = 0;
    private double [] wallparts;

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
           /* if (!wallfound) {
                if (!wallfound()) {
                    robot.forward();
                } else {
                    System.out.println("Wall Found");
                    robot.stop();
                    wallfound = true;
                }
            } else {
                turn();
            }
        }*/
            goToWall();

          //  goToWall();

            turnRight();
            driveLeftAfterWall();

        }

    }


    public boolean wallfound() {
        boolean ballFound = false;
        double rightside = robot.getDSSensor("NNO").getValue();
        double leftside = robot.getDSSensor("NNW").getValue();
        double westside = robot.getDSSensor("W").getValue();
        double eastside = robot.getDSSensor("O").getValue();
        if (smoth(rightside) > 50 || smoth(leftside) > 50 || smoth(westside) > 50 || smoth(eastside) > 50) {
            counter++;
            if (counter > 10) {
                ballFound = true;
                counter = 0;
            }
        }
        return ballFound;
    }

    private double smoth(double value) {
        if (value > 100) {
            return 100;
        } else {
            return 0;
        }
    }

    private double smoth2(double value) {
        if (value > 50) {
            return 100;
        } else {
            return 0;
        }
    }

    private boolean turn() {


       if (robot.getDSSensor("NNW").getValue() > 50 && robot.getDSSensor("NNO").getValue() > 50) {
            System.out.println("Rotate Right");
            robot.right();
        } else {
           counter++;
           robot.forward();

       }
        //robot.forward();
        return false;

    }

    private boolean goToWall(){
        if ((robot.getDSSensor("NNW").getValue()  + robot.getDSSensor("NNO").getValue() )/2 < 50 ){
            counter++;
            System.out.println("Forward");
            if(counter > 5) {
                robot.forward();
                counter = 0;
                return true;
            }
        }
        return false;
    }



    private void turnRight(){
        if (robot.getDSSensor("NNW").getValue() > 50 && robot.getDSSensor("NNO").getValue() > 50&& robot.getDSSensor("NW").getValue() > 50){
            counter2++;
            if(counter2 > 5) {
                System.out.println("Right");
                robot.right();
                counter2 = 0;
            }
        }

    }

    private void driveLeftAfterWall(){
        if (robot.getDSSensor("W").getValue() < 50){
            robot.left();
        }

    }
}
