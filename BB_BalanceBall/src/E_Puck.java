import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LightSensor;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class E_Puck extends Robot {
    private static int MIN_SPEED = 0;
    private static int SLOW_SPEED = 500;
    private static int MAX_SPEED = 1000;

    public E_Puck() {
        super();
    }


    @Override
    void left() {
        setSpeed(MAX_SPEED,SLOW_SPEED);
    }

    @Override
    void right() {
        setSpeed(SLOW_SPEED,MAX_SPEED);
    }

    @Override
    void forward() {
        setSpeed(MAX_SPEED,MAX_SPEED);

    }

    @Override
    void slowForward() {
        setSpeed(SLOW_SPEED,SLOW_SPEED);

    }

    @Override
    void backward() {
        setSpeed(-MAX_SPEED,-MAX_SPEED);

    }

    @Override
    void stop() {
        setSpeed(MIN_SPEED,MIN_SPEED);

    }

    @Override
    void scan() {
        setSpeed(-SLOW_SPEED,-SLOW_SPEED);
    }
}
