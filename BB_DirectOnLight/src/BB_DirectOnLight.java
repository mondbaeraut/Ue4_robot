import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LightSensor;
import sun.management.Sensor;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class BB_DirectOnLight {

    private static int TIME_STEP = 16;
    private Robot robot;

    public BB_DirectOnLight() {
        robot = new Robot();
        robot.initLS();
        robot.initDS();
    }


    public static void main(String[] args) {
        BB_DirectOnLight wallgrind = new BB_DirectOnLight();
        wallgrind.run();
    }

    public void run() {

        while (robot.step(TIME_STEP) != -1) {
                    if (!isNearWall()) {
                        validate();
                    }
        }
    }

    private boolean scanRobot() {
        double rightside = robot.getLSSensor("NO").getValue() + robot.getLSSensor("O").getValue() + robot.getLSSensor("SO").getValue();
        double leftside = robot.getLSSensor("NW").getValue() + robot.getLSSensor("W").getValue() + robot.getLSSensor("SW").getValue();
        if (rightside > leftside) {
            robot.left();
        } else {
            robot.right();
        }

        return true;
    }

    private void validate() {
        boolean north = true;
        for (LightSensor s : robot.getLSSensors()) {
            if (((robot.getLSSensor("NNO").getValue() + robot.getLSSensor("NNW").getValue()) / 2) > s.getValue()) {
                north = false;
            }
        }
        if (north) {
            System.out.println("Forward");
            robot.forward();
        } else {
            System.out.println("Back");
            robot.backward();
            this.scanRobot();
        }

    }

    private boolean isNearWall() {
        boolean isnearWall = false;
        for (DistanceSensor d : robot.getDSSensors()) {
            if (d.getValue() > 100) {
                System.out.println("Is Near Wall");
                robot.backward();
                this.scanRobot();
                isnearWall = true;
            }
        }
        return isnearWall;
    }



}


