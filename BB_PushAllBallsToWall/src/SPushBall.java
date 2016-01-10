/**
 * Created by mod on 1/5/16.
 */
public class SPushBall extends State {
    private static final int distanceToReach = 2500;
    private static final int lSpeed = 1000;
    private static final int rSpeed = 1000;

    public SPushBall(Robot robot) {
        super(robot);
    }

    @Override
    public boolean activate() {

        double distanceNorth = (getRobot().getDSSensor("NNW").getValue()+getRobot().getDSSensor("NNO").getValue())/2;
        if(distanceNorth >= distanceToReach){
            getRobot().setlSpeed(lSpeed);
            getRobot().setrSpeed(rSpeed);
            System.out.println("Push Ball...");
            return true;
        }
        return false;
    }

}
