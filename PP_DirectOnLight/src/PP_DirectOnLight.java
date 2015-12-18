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
       /* Matrix k = new Matrix(new double[][]{
                {1.,0.},{0.,0.}
        });
        Matrix c = new Matrix(new double[]{1., 1.}, 1);
        Matrix x = new Matrix(new double[][]{
                {1.,0.},{0.,0.}
        });
        System.out.print(c.times(k).plus(c).toString());
*/
    }

    public void run() {

        Matrix k = new Matrix(new double[][]{
                {0.15,0.05,0.01},
                {0.05,0.01,0.15}
        });

        Matrix c = new Matrix(new double[][]{{100.}, {100.}});
        Matrix m = null;

        while(robot.step(TIME_STEP) != -1){
            double valuemid = (robot.getLSSensor("NNW").getValue());
            double valueO = robot.getLSSensor("O").getValue();
            double valueW = robot.getLSSensor("W").getValue();
            m = new Matrix(new double[][]{{valuemid},{valueO},{valueW}});
            double[][] a = k.times(m).plus(c).getArray();
            robot.setSpeed(a[0][0],a[0][1]);
        }
    }
}
