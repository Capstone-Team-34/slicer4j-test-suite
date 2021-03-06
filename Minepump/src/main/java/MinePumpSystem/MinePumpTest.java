package MinePumpSystem;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class MinePumpTest {
    public MinePumpTest() {}

    @Test
    public void isHighWaterLevel() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);
        env.lowerWaterLevel();

        assertTrue(!p.isHighWaterLevel());

        env.waterRise();
        env.waterRise();
        assertTrue(p.isHighWaterLevel());

        p.startSystem();
        p.activatePump();

        env.lowerWaterLevel();
        env.lowerWaterLevel();
        assertTrue(!p.isHighWaterLevel());

        env.waterRise();
        env.waterRise();
        p.timeShift();
        p.timeShift();
        assertTrue(!p.isHighWaterLevel());

        logTestPassed("isHighWaterLevel");
    }

    @Test
    public void isLowWaterLevel() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        env.lowerWaterLevel();
        assertTrue(p.isLowWaterLevel());

        env.waterRise();
        env.waterRise();
        env.waterRise();

        assertTrue(!p.isLowWaterLevel());
        logTestPassed("isLowWaterLevel");
    }

    @Test
    public void isMethaneAlarm() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assertTrue(!p.isMethaneAlarm());

        env.changeMethaneLevel();

        assertTrue(p.isMethaneAlarm());
        logTestPassed("isMethaneAlarm");
    }

    @Test
    public void timeShift() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        env.waterRise();
        env.waterRise();

        p.timeShift();
        p.timeShift();

        assertTrue(p.isHighWaterLevel());

        p.startSystem();
        p.timeShift();
        p.timeShift();

        assertTrue(p.isHighWaterLevel());

        p.activatePump();
        p.timeShift();
        p.timeShift();

        assertTrue(!p.isHighWaterLevel());
        logTestPassed("timeShift");

    }

    @Test
    public void activatePump() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assertTrue(!p.pumpRunning);

        p.activatePump();

        assertTrue(p.pumpRunning);
        logTestPassed("activatePump");
    }

    @Test
    public void deactivatePump() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assertTrue(!p.pumpRunning);

        p.activatePump();

        assertTrue(p.pumpRunning);

        p.deactivatePump();

        assertTrue(!p.pumpRunning);
        logTestPassed("deactivatePump");
    }

    @Test
    public void testToString() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assertTrue(p.toString().equals("Pump(System:On,Pump:Off) Env(Water:normal,Meth:OK)"));

        p.activatePump();

        assertTrue(p.toString().equals("Pump(System:On,Pump:On) Env(Water:normal,Meth:OK)"));

        env.waterRise();

        assertTrue(p.toString().equals("Pump(System:On,Pump:On) Env(Water:high,Meth:OK)"));

        env.lowerWaterLevel();

        assertTrue(p.toString().equals("Pump(System:On,Pump:On) Env(Water:normal,Meth:OK)"));

        env.lowerWaterLevel();

        assertTrue(p.toString().equals("Pump(System:On,Pump:On) Env(Water:low,Meth:OK)"));

        env.changeMethaneLevel();

        assertTrue(p.toString().equals("Pump(System:On,Pump:On) Env(Water:low,Meth:CRIT)"));

        p.stopSystem();

        assertTrue(p.toString().equals("Pump(System:Off,Pump:Off) Env(Water:low,Meth:CRIT)"));
        logTestPassed("testToString");
    }

    @Test
    public void stopSystem() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assertTrue(!p.pumpRunning);
        assertTrue(p.systemActive);

        p.stopSystem();

        assertTrue(!p.pumpRunning);
        assertTrue(!p.systemActive);

        p.startSystem();

        assertTrue(!p.pumpRunning);
        assertTrue(p.systemActive);

        p.activatePump();

        assertTrue(p.pumpRunning);
        assertTrue(p.systemActive);

        p.stopSystem();

        assertTrue(!p.pumpRunning);
        assertTrue(!p.systemActive);
        logTestPassed("stopSystem");
    }

    @Test
    public void startSystem() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        p.stopSystem();

        assertTrue(!p.pumpRunning && !p.systemActive);

        p.startSystem();
        p.activatePump();

        p.stopSystem();

        assertTrue(!p.pumpRunning && !p.systemActive);
        logTestPassed("startSystem");
    }

    private void logTestPassed(String testName) {
        Date date = new Date(System.currentTimeMillis());
        File dir = new File("slicer4j-stats/");
        dir.mkdir();
        File f = new File(dir, "PassingTest.log");
        try {
            f.createNewFile();
            String text = "Test passed: " + testName + "\t--------\t" + date.toString() + "\n";
            FileWriter fw = new FileWriter(f, true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}