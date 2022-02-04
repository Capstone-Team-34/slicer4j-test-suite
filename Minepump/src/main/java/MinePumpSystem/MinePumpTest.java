package MinePumpSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinePumpTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void isHighWaterLevel() {
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
    }

    @org.junit.jupiter.api.Test
    void isLowWaterLevel() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        env.lowerWaterLevel();
        assert(p.isLowWaterLevel());

        env.waterRise();
        env.waterRise();
        env.waterRise();

        assert(!p.isLowWaterLevel());
    }

    @Test
    void isMethaneAlarm() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assert(!p.isMethaneAlarm());

        env.changeMethaneLevel();

        assert(p.isMethaneAlarm());
    }

    @Test
    void timeShift() {
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

    }

    @Test
    void activatePump() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assert(!p.pumpRunning);

        p.activatePump();

        assert(p.pumpRunning);
    }

    @Test
    void deactivatePump() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assert(!p.pumpRunning);

        p.activatePump();

        assert(p.pumpRunning);

        p.deactivatePump();

        assert(!p.pumpRunning);
    }

    @Test
    void testToString() {
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
    }

    @Test
    void stopSystem() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        assert(!p.pumpRunning && p.systemActive);

        p.stopSystem();

        p.startSystem();

        assert(!p.pumpRunning && p.systemActive);
    }

    @Test
    void startSystem() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        p.stopSystem();

        assert(!p.pumpRunning && !p.systemActive);

        p.startSystem();
        p.activatePump();

        p.stopSystem();

        assert(!p.pumpRunning && !p.systemActive);

    }
}