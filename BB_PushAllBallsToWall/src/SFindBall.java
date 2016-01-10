/**
 * Created by mod on 1/5/16.
 */
public class SFindBall extends State {
    private static final int distanceToReach = 1000;
    private static final int distanceToReachToBall = 2500;
    private static final int lSpeed = 1000;
    private static final int rSpeed = 1000;
    private static final int lFoundSpeed = -1000;
    private static final int rFoundSpeed = -1000;
    public SFindBall(Robot robot) {
        super(robot);
    }

    @Override
    public boolean activate() {

        double distanceNorth = (getRobot().getDSSensor("NNW").getValue()+getRobot().getDSSensor("NNO").getValue())/2;
        double distanceNW = getRobot().getDSSensor("NW").getValue();
        double distanceNO = getRobot().getDSSensor("NO").getValue();;
        double distanceW = getRobot().getDSSensor("W").getValue();
        double distanceO = getRobot().getDSSensor("O").getValue();

        if(distanceNorth >= distanceToReachToBall){
            return false;
        }else if(distanceNW >= distanceToReach || distanceW >= distanceToReach){
            getRobot().setlSpeed(lFoundSpeed);
            getRobot().setrSpeed(rSpeed);
            System.out.println("Find Ball...");
            return true;
        }else if(distanceNO >= distanceToReach || distanceO >= distanceToReach){
            getRobot().setlSpeed(lSpeed);
            getRobot().setrSpeed(rFoundSpeed);
            System.out.println("Find Ball...");
            return true;
        }
            getRobot().setlSpeed(lSpeed);
            getRobot().setrSpeed(rSpeed);
            System.out.println("Find Ball...");
            return true;

    }
}
