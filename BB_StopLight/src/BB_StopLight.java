import com.cyberbotics.webots.controller.LightSensor;

public class BB_StopLight {

    private static final int TIME_STEP = 16;
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
        while (robot.step(TIME_STEP) != -1) {
            if (robot.getDSSensor("NNO").getValue() > 100 || robot.getDSSensor("NNW").getValue() > 100) {
                robot.stop();
            } else if (scan()) {
                robot.forward();
                robot.stop();
            } else {
                robot.stop();
                robot.scan();
            }
        }

    }

    private boolean scan() {
        for (LightSensor s : robot.getLSSensors()) {
            if (robot.getLSSensor("N").getValue() > s.getValue()) {
                System.out.println(robot.getLSSensor("N").getValue());
                return false;
            }
        }
        return true;
    }
}
