/**
 * Created by mod on 1/5/16.
 */
public class SUnwedger extends State {
    private static final int distanceToReachSouth = 100;
    private static final int distanceToReach = 2000;
    private static final int lSpeed = 1000;
    private static final int rSpeed = 1000;

    public SUnwedger(Robot robot) {
        super(robot);
    }

    @Override
    public boolean activate() {

        getRobot().setrSpeed(-rSpeed);
        getRobot().setlSpeed(lSpeed);

        double valueW = getRobot().getDSSensor("W").getValue();
        double valueO = getRobot().getDSSensor("O").getValue();
        double valueNW = getRobot().getDSSensor("NW").getValue();
        double valueNO = getRobot().getDSSensor("NO").getValue();
        double valueSW = getRobot().getDSSensor("SW").getValue();
        double valueSO = getRobot().getDSSensor("SO").getValue();

        if((valueW >= distanceToReach || valueNW >= distanceToReach) && !(valueSW <= distanceToReachSouth && valueNW <= distanceToReachSouth)){
            getRobot().setrSpeed(-rSpeed);
            getRobot().setlSpeed(lSpeed);
            System.out.println("Unwedger...");
           return true;
        } else if(valueO >= distanceToReach || valueNO >= distanceToReach && !(valueSW < distanceToReachSouth || valueNW < distanceToReachSouth)){
            getRobot().setrSpeed(rSpeed);
            getRobot().setlSpeed(-lSpeed);
            System.out.println("Unwedger...");
            return true;
        }else {
            return false;
        }
    }

}
