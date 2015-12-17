import Jama.Matrix;

/**
 * Created by mod on 12/16/15.
 */
public class PP_DirectOnLight {
    private static int TIME_STEP = 16;
    private Robot robot;


    public PP_DirectOnLight(){
        robot = new Robot();
        robot.initDS();
        robot.initLS();
    }

    public static void main(String[] args) {
        PP_DirectOnLight pp_directOnLight = new PP_DirectOnLight();
        pp_directOnLight.run();
    }

    public void run() {

        Matrix k = new Matrix(new double[][]{

        });

        Matrix c = new Matrix(new double[][]{
                {100.0,100.0}
        });
        Matrix m = null;
        while(robot.step(TIME_STEP) != -1){
            m = new Matrix(new double[][]{

            });
            double[][] a = k.times(m).plus(c).getArray();
            robot.setSpeed(a[0][0],a[0][1]);
        }
    }
}
