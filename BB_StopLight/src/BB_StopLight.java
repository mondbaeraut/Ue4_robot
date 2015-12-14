import com.cyberbotics.webots.controller.LightSensor;

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
            if (!stop) {
                if (robot.getDSSensor("NNO").getValue() > 1800 && robot.getLSSensor("N").getValue() > 1800) {
                    robot.driveStop();
                    stop = true;
                    System.out.println("STOP");
                } else if (robot.getDSSensor("NNO").getValue() > 1800 && robot.getLSSensor("N").getValue() > 1600) {
                    boolean ok = true;
                    for (LightSensor s : robot.getLSSensors()) {
                        if (robot.getLSSensor("N").getValue() > s.getValue()) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        robot.driveForwardSlow();
                    } else {
                        robot.rotateRight();
                    }
                } else {
                    boolean ok = true;
                    for (LightSensor s : robot.getLSSensors()) {
                        if (robot.getLSSensor("N").getValue() > s.getValue()) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        robot.driveForward();
                    } else {
                        robot.rotateRight();
                    }
                }
            }
        }

    }
}
