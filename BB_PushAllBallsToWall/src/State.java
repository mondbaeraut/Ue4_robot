/**
 * Created by mod on 1/2/16.
 */
public abstract class State {
    private Robot robot = null;

    public State(Robot robot) {
        this.robot = robot;
    }

    public abstract boolean activate();

    public Robot getRobot() {
        return robot;
    }
}
