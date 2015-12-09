package bangbang;

import com.cyberbotics.webots.controller.DifferentialWheels;

/**
 * Created by mod on 12/7/15.
 */
public abstract class BBController extends DifferentialWheels {
    private static int MIN_SPEED = 0;
    private static int SLOW_SPEED = 500;
    private static int MAX_SPEED = 1000;

    public abstract void  run();
    public void driveLeft(){
        setSpeed(MIN_SPEED, MAX_SPEED);
    }
    public void driveRight(){
        setSpeed(MAX_SPEED, MIN_SPEED);
    }
    public void driveForward(){
        setSpeed(MAX_SPEED, MAX_SPEED);
    }
    public void driveForwardSlow(){setSpeed(SLOW_SPEED,SLOW_SPEED);}
    public void driveBackward(){
        setSpeed(-MAX_SPEED, -MAX_SPEED);
    }
    public void driveStop(){
        setSpeed(MIN_SPEED, MIN_SPEED);
    }
}
