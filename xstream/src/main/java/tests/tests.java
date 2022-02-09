package tests;

import TestingExample.*;
public class tests {
    public static int SCALE;

    public static void main(String args[])
    {
        try
        {
            SCALE = 1;

            XstreamExample.COMMON_COUNT = 200 * SCALE;
            XstreamExample.VARIABLE_COUNT = 40 * SCALE;
            XstreamExample.PLACEHOLDER_COUNT = XstreamExample.COMMON_COUNT / 2;
            XstreamExample.splStart___();

            XstreamExample.test0();
            XstreamExample.test1();
            XstreamExample.test2();
            XstreamExample.splEnd___();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
