import Jama.Matrix;

/**
 * Created by mod on 12/16/15.
 */
public class PP_WallGrind {
    private static int TIME_STEP = 16;
    private static int constant = 200;
    private Robot robot;


    public PP_WallGrind(){
        robot = new Robot();
        robot.initDS();
        robot.initLS();
    }

    public static void main(String[] args) {
        PP_WallGrind pp_directOnLight = new PP_WallGrind();
        pp_directOnLight.run();

    }

    public void run() {

        Matrix k = new Matrix(new double[][]{
                {0.4,0.2,0.3},
                {0.4,0.2,0.3},
        });

        Matrix m = null;

        while(robot.step(TIME_STEP) != -1){
            double valueNNW = (robot.getDSSensor("NNW").getValue());
            double valueNNO = robot.getDSSensor("NNO").getValue();
            double valueNW = (robot.getDSSensor("NW").getValue());
            double valueNO = robot.getDSSensor("NO").getValue();
            double valueO = robot.getDSSensor("O").getValue();
            double valueW = robot.getDSSensor("W").getValue();
            double valueSO = robot.getDSSensor("SO").getValue();
            double valueSW = robot.getDSSensor("SW").getValue();

            m = new Matrix(new double[][]{

                    {valueW, valueNW, valueNNW},
                    {valueO, valueNO, valueNNO}
            });

            Matrix endMatrix = k.arrayTimes(m);
            robot.setSpeed(endMatrix.get(1,0), endMatrix.get(0,0));



        }


    }
}
