import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LightSensor;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by FH-Studium on 14.12.2015.
 */
public class BB_StopLight {

    private static int TIME_STEP = 16;
    private Robot robot;

    public BB_StopLight() {
        robot = new Robot();
        robot.initLS();
        robot.initDS();
    }


    public static void main(String[] args) {
        BB_StopLight wallgrind = new BB_StopLight();
        wallgrind.run();
    }

    public void run() {
        boolean stop = false;
        while (robot.step(TIME_STEP) != -1) {
            if(!stop) {
                if (((robot.getLSSensor("NNO").getValue() + robot.getLSSensor("NNW").getValue()) / 2) > 2680) {
                    if (!isNearWall()) {
                        validate();
                    }
                } else {
                    stop = true;
                    robot.stop();
                }
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

