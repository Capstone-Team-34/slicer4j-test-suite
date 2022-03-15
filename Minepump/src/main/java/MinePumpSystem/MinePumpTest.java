package MinePumpSystem;

import org.junit.Test;

public class MinePumpTest {
    public MinePumpTest() {}

    @Test
    public void setUp() {
    }

    @Test
    public void isHighWaterLevel() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
            env.lowerWaterLevel();
    
            assert(!p.isHighWaterLevel());
    
            env.waterRise();
            env.waterRise();
            assert(p.isHighWaterLevel());
    
            p.startSystem();
            p.activatePump();
    
            env.lowerWaterLevel();
            env.lowerWaterLevel();
            assert(!p.isHighWaterLevel());
    
            env.waterRise();
            env.waterRise();
            p.timeShift();
            p.timeShift();
            assert(!p.isHighWaterLevel());
        } catch (Throwable T) {
            System.out.println("isHighWaterLevel failed!");
        }
    }

    @Test
    public void isLowWaterLevel() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            env.lowerWaterLevel();
            assert(p.isLowWaterLevel());
    
            env.waterRise();
            env.waterRise();
            env.waterRise();
    
            assert(!p.isLowWaterLevel());
        } catch (Throwable T) {
            System.out.println("isLowWaterLevel failed!");
        }

    }

    @Test
    public void isMethaneAlarm() {
        try{
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            assert(!p.isMethaneAlarm());
    
            env.changeMethaneLevel();
    
            assert(p.isMethaneAlarm());
        } catch (Throwable T) {
            System.out.println("isMethaneAlarm failed!");
        }
    }

    @Test
    public void timeShift() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            env.waterRise();
            env.waterRise();
    
            p.timeShift();
            p.timeShift();
    
            assert(p.isHighWaterLevel());
    
            p.startSystem();
            p.timeShift();
            p.timeShift();
    
            assert(p.isHighWaterLevel());
    
            p.activatePump();
            p.timeShift();
            p.timeShift();
    
            assert(!p.isHighWaterLevel());
        } catch (Throwable T) {
            System.out.println("timeShift failed!");
        }
    }

    @Test
    public void activatePump() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            assert(!p.pumpRunning);
    
            p.activatePump();
    
            assert(p.pumpRunning);
        } catch (Throwable T) {
            System.out.println("activatePump failed!");
        }

    }

    @Test
    public void deactivatePump() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            assert(!p.pumpRunning);
    
            p.activatePump();
    
            assert(p.pumpRunning);
    
            p.deactivatePump();
    
            assert(!p.pumpRunning);
        } catch (Throwable T) {
            System.out.println("deactivatePump failed!");
        }
    }

    @Test
    public void testToString() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            assert(p.toString().equals("Pump(System:On,Pump:Off) Env(Water:normal,Meth:OK)"));
    
            p.activatePump();
    
            assert(p.toString().equals("Pump(System:On,Pump:On) Env(Water:normal,Meth:OK)"));
    
            env.waterRise();
    
            assert(p.toString().equals("Pump(System:On,Pump:On) Env(Water:high,Meth:OK)"));
    
            env.lowerWaterLevel();
    
            assert(p.toString().equals("Pump(System:On,Pump:On) Env(Water:normal,Meth:OK)"));
    
            env.lowerWaterLevel();
    
            assert(p.toString().equals("Pump(System:On,Pump:On) Env(Water:low,Meth:OK)"));
    
            env.changeMethaneLevel();
    
            assert(p.toString().equals("Pump(System:On,Pump:On) Env(Water:low,Meth:CRIT)"));
    
            p.stopSystem();
    
            assert(p.toString().equals("Pump(System:Off,Pump:Off) Env(Water:low,Meth:CRIT)"));
        } catch (Throwable T) {
            System.out.println("testToString failed!");
        }
    }

    @Test
    public void stopSystem() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            assert(!p.pumpRunning);
            assert(p.systemActive);
    
            p.stopSystem();
    
            assert(!p.pumpRunning);
            assert(!p.systemActive);
    
            p.startSystem();
    
            assert(!p.pumpRunning);
            assert(p.systemActive);
    
            p.activatePump();
    
            assert(p.pumpRunning);
            assert(p.systemActive);
    
            p.stopSystem();
    
            assert(!p.pumpRunning);
            assert(!p.systemActive);
        } catch (Throwable T) {
            System.out.println("stopSystem failed!");
        }

    }

    @Test
    public void startSystem() {
        try {
            Environment env = new Environment();
            MinePump p = new MinePump(env);
    
            p.stopSystem();
    
            assert(!p.pumpRunning && !p.systemActive);
    
            p.startSystem();
            p.activatePump();
    
            p.stopSystem();
    
            assert(!p.pumpRunning && !p.systemActive);
        } catch (Throwable T) {
            System.out.println("startSystem failed!");
        }

    }
}