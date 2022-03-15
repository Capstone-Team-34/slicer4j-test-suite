package tests;

import java.util.*;
import Actions.*;

public class tests {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        System.out.println(getExecutedActions());
    }


    public static List<String> getExecutedActions() {
        return Action.actionHistory;
    }


    static void test1() {
        Action.setup();
        Action.bobKeyAdd();
        Action.bobSetAddressBook();
        Action.bobToAlias();
    }


    static void test2() {
        Action.setup();
        Action.rjhKeyAdd();
        Action.bobKeyChange();
        Action.bobToRjh();
    }


    static void test3() {
        Action.setup();
        Action.rjhDeletePrivateKey();
        Action.rjhKeyAdd();
        Action.chuckKeyAdd();
        Action.rjhEnableForwarding();
        Action.bobToRjh();
    }


    static void test4() {
        Action.setup();
        Action.bobKeyAdd();
        Action.rjhKeyChange();
        Action.bobToRjh();
    }


    static void test5() {
        Action.setup();
        Action.bobKeyAdd();
        // rjhKeyAdd();
        Action.rjhKeyChange();
        Action.bobToRjh();
    }


    static void test6() {
        Action.setup();
        Action.bobKeyAdd();
        Action.rjhSetAutoRespond();
        Action.bobToRjh();
    }


    static void test7() {
        Action.setup();
        Action.bobKeyAdd();
        Action.rjhEnableForwarding();
        Action.bobToRjh();
    }


    static void test8() {
        Action.setup();
        Action.bobKeyAdd();
        Action.rjhSetAutoRespond();
        Action.rjhKeyChange();
        Action.bobToRjh();
    }


    static void test9() {
        Action.setup();
        Action.rjhDeletePrivateKey();
        Action.rjhKeyAdd();
        Action.rjhEnableForwarding();
        Action.bobToRjh();
    }
}
