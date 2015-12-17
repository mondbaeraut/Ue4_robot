

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_BalanceBall {
    private static int TIME_STEP = 16;
    private Robot robot;
    private int counter = 0;

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
        if (rightside > 50 && leftside > 50) {
            robot.forward();
        }else if(leftside > 50){
            robot.left();
        } else if(rightside > 50){
            robot.right();
        } else if(westtside > 50){
            robot.left();
        } else if(easttside > 50){
            robot.right();
        }
        else{
            System.out.println("FAILED");
            robot.stop();
        }
    }

    private void validate() {

        
    }
    private boolean ballfound(){
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
    private double smoth(double value){
        if(value > 100){
            return 100;
        }else{
            return 0;
        }
    }


}
