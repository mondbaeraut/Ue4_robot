import Jama.Matrix;

/**
 * Created by mod on 12/16/15.
 */
public class PP_StopLight {
    private static int TIME_STEP = 16;
    private Robot robot;


    public PP_StopLight(){
        robot = new Robot();
        robot.initDS();
        robot.initLS();
    }

    public static void main(String[] args) {
        PP_StopLight pp_directOnLight = new PP_StopLight();
        pp_directOnLight.run();

    }

    public void run() {

        Matrix k = new Matrix(new double[][]{
                //Highspeed Values
               /* {0.8,0.9,1.},
                {0.8,0.9,1.}*/


                {0.2,0.5,1.},
                {0.2,0.5,1.}
        });

        Matrix m = null;

        while(robot.step(TIME_STEP) != -1){
            double valueNNW = (robot.getLSSensor("NNW").getValue());
            double valueNNO = robot.getLSSensor("NNO").getValue();
            double valueNW = (robot.getLSSensor("NW").getValue());
            double valueNO = robot.getLSSensor("NO").getValue();
            double valueO = robot.getLSSensor("O").getValue();
            double valueW = robot.getLSSensor("W").getValue();
            double valueSO = robot.getLSSensor("SO").getValue();
            double valueSW = robot.getLSSensor("SW").getValue();

            m = new Matrix(new double[][]{

                    {valueW, valueNW, valueNNW},
                    {valueO, valueNO, valueNNO}
            });

            Matrix endMatrix = k.arrayTimes(m);
            robot.setSpeed(endMatrix.get(0,0), endMatrix.get(1,0));



        }


    }
}
