

/**
 * Created by mod on 12/7/15.
 *
 */
public class BB_BalanceBall {
    private static int TIME_STEP = 16;
    private Robot robot;
    private int counter = 0;
    private double rightside;
    private double leftside;
    private double westside;
    private double eastside;

    public BB_BalanceBall() {
        robot = new E_Puck();
        robot.initDS();
    }

    public static void main(String[] args) {
        BB_BalanceBall bb_balanceBall = new BB_BalanceBall();
        bb_balanceBall.run();
    }

    public void run() {
        boolean ballFound = false;
        while(robot.step(TIME_STEP) != -1){
           if(!ballFound){
                if(!ballFound()){
                    robot.forward();
                }else{
                    ballFound = true;
                }
           } else{
                robot.stop();
                scanForBall();
           }
        }

    }

    private void scanForBall() {
        rightside = robot.getDSSensorValue("NNO");
        leftside =  robot.getDSSensorValue("NNW");
        westside =  robot.getDSSensorValue("W");
        eastside =  robot.getDSSensorValue("O");
        if (rightside > 50 && leftside > 50) {
            robot.forward();
        }else if(leftside > 50){
            robot.left();
        } else if(rightside > 50){
            robot.right();
        } else if(westside > 50){
            robot.left();
        } else if(eastside > 50){
            robot.right();
        }
        else{
            robot.stop();
        }
    }

    private boolean ballFound(){
        boolean ballFound = false;
        rightside = robot.getSmoothDSSensorValue("NNO");
        leftside = robot.getSmoothDSSensorValue("NNW");
        westside = robot.getSmoothDSSensorValue("W");
        eastside = robot.getSmoothDSSensorValue("O");
        if (rightside > 50 || leftside > 50 || westside > 50 || eastside > 50) {
            counter++;
            if (counter > 10) {
                ballFound = true;
                counter = 0;
            }
        }
        return ballFound;
    }
}
