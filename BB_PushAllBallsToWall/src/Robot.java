import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class Robot extends DifferentialWheels {
    private DistanceSensors distanceSensors = null;
    private static int TIME_STEP = 16;
    private List<State> stateList = null;
    private int lSpeed = 0;
    private int rSpeed = 0;
    public Robot(){
        super();
    }

    public void initStates(){
        if(stateList == null) {
            stateList = new LinkedList<>();
        }
        stateList.add(new SUnwedger(this));
        stateList.add(new SPushBall(this));
        stateList.add(new SFindBall(this));
        System.out.println(stateList.size());
    }

    public void run(){
        if(stateList != null) {
            while (step(TIME_STEP) != -1) {
                for(State state: stateList){
                    if(state.activate()){
                        drive(lSpeed,rSpeed);
                    }
                }
            }
        }
    }
    public void initDS(){
       distanceSensors = new DistanceSensors(this);
    }
    public DistanceSensor getDSSensor(String sensor){
        return distanceSensors.getSensor(sensor);
    }
    private void drive(int lSpeed, int rSpeed){
        setSpeed(lSpeed,rSpeed);
    }
    public void setlSpeed(int lSpeed) {
        this.lSpeed = lSpeed;
    }
    public void setrSpeed(int rSpeed) {
        this.rSpeed = rSpeed;
    }
}
