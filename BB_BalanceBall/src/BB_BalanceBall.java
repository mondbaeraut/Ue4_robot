

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_BalanceBall {
    private static int TIME_STEP = 16;
    private Robot robot;
    private int counter = 0;
    private static int simpleWallDistance = 50;
    private static int widerWallDistance = 60;

    public BB_BalanceBall() {
        robot = new Robot();
        robot.initDS();
    }



    public static void main(String[] args) {
        BB_BalanceBall wallgrind = new BB_BalanceBall();
        wallgrind.run();
    }

    public void run() {
        boolean ballfound = false;
        while(robot.step(TIME_STEP) != -1){
           if(!ballfound){
                if(!ballfound()){
                    robot.forward();
                }else{
                    ballfound = true;
                }
           } else{
               robot.stop();
               moveWithBall();
           }
        }

    }

    private void moveWithBall() {
        scanRobot();
    }

    private void scanRobot() {
        double rightside = robot.getDSSensor("NNO").getValue();
        double leftside =  robot.getDSSensor("NNW").getValue();
        double westtside =  robot.getDSSensor("W").getValue();
        double easttside =  robot.getDSSensor("O").getValue();
        if (rightside > simpleWallDistance && leftside > simpleWallDistance) {
            robot.forward();
        }else if(leftside > simpleWallDistance){
            robot.left();
        } else if(rightside > simpleWallDistance){
            robot.right();
        } else if(westtside > simpleWallDistance){
            robot.left();
        } else if(easttside > simpleWallDistance){
            robot.right();
        }
        else{
            System.out.println("FAILED");
            robot.stop();
        }
    }


    private boolean ballfound(){
        boolean ballFound = false;
        double rightside = robot.getDSSensor("NNO").getValue();
        double leftside = robot.getDSSensor("NNW").getValue();
        double westside = robot.getDSSensor("W").getValue();
        double eastside = robot.getDSSensor("O").getValue();
        if (smoth(rightside) > simpleWallDistance || smoth(leftside) > simpleWallDistance || smoth(westside) > simpleWallDistance || smoth(eastside) > simpleWallDistance) {
            counter++;
            if (counter > 10) {
                ballFound = true;
                counter = 0;
            }
        }
        return ballFound;
    }
    private double smoth(double value){
        if(value > 100){
            return 100;
        }else{
            return 0;
        }
    }


}
