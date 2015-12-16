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
    }


    public static void main(String[] args) {
        BB_DirectOnLight wallgrind = new BB_DirectOnLight();
        wallgrind.run();
    }

    public void run() {
        while (robot.step(TIME_STEP) != -1) {
          if(scan()){
              robot.forward();
              robot.stop();
          } else{
              robot.stop();
              robot.scan();
          }
        }

    }
    private boolean scan(){
        for (LightSensor s : robot.getLSSensors()) {
            if (robot.getLSSensor("N").getValue() > s.getValue()) {
                System.out.println(robot.getLSSensor("N").getValue());
                return false;
            }
        }
        return true;
    }
}


