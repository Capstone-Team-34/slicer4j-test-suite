package MinePumpSystem;
import org.junit.Test;
import tests.TestInterface;
import tests.TestCommand;

public class Actions {
    Environment env;
    public MinePump p;

    public Actions() {
        env = new Environment();
        p = new MinePump(env);
    }

    public void waterRise() {
        env.waterRise();
    }

    public void methaneChange() {
        env.changeMethaneLevel();
    }

    public void  stopSystem__before__stopCommand() {
        TestInterface.actionExecuted = true;
    }

    public void  stopSystem__role__stopCommand() {
        p.stopSystem();
    }

    public void
    stopSystem() {
        if (TestCommand.get_STOPCOMMAND___()) {
            stopSystem__role__stopCommand();
        } else {
            stopSystem__before__stopCommand();
        }
    }

    void  startSystem__before__startCommand() {
        TestInterface.actionExecuted = true;
    }

    void  startSystem__role__startCommand() {
        p.startSystem();
    }

    public void
    startSystem() {
        if (TestCommand.get_STARTCOMMAND___()) {
            startSystem__role__startCommand();
        } else {
            startSystem__before__startCommand();
        }
    }

    public void timeShift() {
        p.timeShift();
    }

    String getSystemState() {
        return p.toString();
    }
}
