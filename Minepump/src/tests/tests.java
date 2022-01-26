package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import MinePumpSystem.Environment;
import MinePumpSystem.MinePump;

public class tests {


    //RunningExample: [STARTCOMMAND___] [STOPCOMMAND___] [METHANEALARM___] [METHANEQUERY___] [LOWWATERSENSOR___] [HIGHWATERSENSOR___] BASE___ :: Program;

    public static void main(String args[])
    {
        System.out.println("Start");
        Environment env = new Environment();
        MinePump p = new MinePump(env);
        env.waterRise();
        //p.startSystem();
        env.waterRise();
        p.timeShift();
        env.waterRise();
        p.timeShift();
        p.timeShift();
        p.timeShift();
        System.out.println(p.toString());


    }
}
