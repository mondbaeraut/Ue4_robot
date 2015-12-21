

/**
 * Created by mod on 12/7/15.
 */
public class BB_WallGrind {
    private static int TIME_STEP = 16;
    private Robot robot;
    private int counter = 0;
    private int counter2 = 0;
    private static int simpleWallDistance = 50;
    private static int widerWallDistance = 60;


    public BB_WallGrind() {
        robot = new Robot();
        robot.initDS();
    }


    public static void main(String[] args) {
        BB_WallGrind wallgrind = new BB_WallGrind();
        wallgrind.run();
    }

    public void run() {
        boolean wallfound = false;
        while (robot.step(TIME_STEP) != -1) {
            goToWall();
            if(turnRight()){
                wallfound = true;
                System.out.println("Wallfound");


            };
            if(wallfound){
                System.out.println("IN LEFT Schleife");
                driveLeftAfterWall();
            }

        }

    }


    private void goToWall(){
        if (robot.getDSSensor("NNO").getValue()   < simpleWallDistance  ){
            counter++;
            System.out.println("Forward");
            if(counter > 3) {
                robot.forward();
                counter = 0;

            }
        }

    }


    private boolean turnRight(){
        if (robot.getDSSensor("NNW").getValue() > widerWallDistance && robot.getDSSensor("NNO").getValue() > widerWallDistance && robot.getDSSensor("NW").getValue() > widerWallDistance){
            counter2++;
            if(counter2 > 3) {
                System.out.println("Right");
                robot.right();
                counter2 = 0;
                return true;
            }
        }
        return false;

    }

    private void driveLeftAfterWall(){
        if (robot.getDSSensor("W").getValue() < widerWallDistance && robot.getDSSensor("NNO").getValue()   < widerWallDistance   &&robot.getDSSensor("NNW").getValue()   < widerWallDistance    ){
            System.out.println("LEFT");
            robot.left();

        }
    }

}
