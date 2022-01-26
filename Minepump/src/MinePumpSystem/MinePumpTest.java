package MinePumpSystem;

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
    }

    @org.junit.jupiter.api.Test
    void isLowWaterLevel() {
        Environment env = new Environment();
        MinePump p = new MinePump(env);

        env.lowerWaterLevel();
        assert(p.isLowWaterLevel());

        for(int i = 0; i < 10; i++) {
            env.waterRise();
        }
        assert(!p.isLowWaterLevel());
    }
}