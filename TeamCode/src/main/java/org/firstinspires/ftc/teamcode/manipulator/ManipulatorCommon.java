package org.firstinspires.ftc.teamcode.manipulator;

import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.*;
import static org.firstinspires.ftc.teamcode.Robot.*;

public class ManipulatorCommon {

//    public static int x;


    public static void initManipulatorCommon(){
        ManipulatorHardware.initManipulatorHardware();

        input_lift.setPosition(.95);
        lift.setPosition(.6);


//        x = 0;
    }

    public static void executeManipulatorTeleop() {
//        if (x < 0 || x > 3) {
//            x = 0;
//        }
//
//        if (operator.a && x == 0) {
//            stage1_2.setPower(-1);
//            curOpMode.sleep(1);
//            stage1_1.setPower(-1);
//            curOpMode.sleep(200);
//            stage1_1.setPower(0);
//            curOpMode.sleep(10);
//            stage1_2.setPower(0);
//            x = 1;
////            updateTelemetry(telemetry);
//
//        }
//         else if (operator.a && x == 1) {
//            stage1_2.setPower(-1);
//            curOpMode.sleep(1);
//            stage1_1.setPower(-1);
//            stage2_1.setPower(-.25);
//            curOpMode.sleep(300);
//            stage1_1.setPower(0);
//            stage2_1.setPower(0);
//            stage1_2.setPower(0);
//            x = 2;
////            updateTelemetry(telemetry);
//
//        }else if (x == 2) {
//            curOpMode.sleep(750);
//            input_lift.setPosition(9);
//            curOpMode.sleep(1000);
//            x = 3;
////            updateTelemetry(telemetry);
//
//        }
//
//        else if (operator.right_trigger > 0.2 && x == 3) {
//            output.setPower(-.10);
//            shooter.setPower(.5);
//            curOpMode.sleep(250);
//            stage2_1.setPower(-1);
//            output.setPower(-1);
//            curOpMode.sleep(900);
//            stage1_1.setPower(-1);
//            stage2_1.setPower(-1);
//            output.setPower(-1);
//            curOpMode.sleep(1250);
//            shooter.setPower(0);
//            curOpMode.sleep(1000);
//            output.setPower(0);
//            input_lift.setPosition(1);
//            x = 0;
//
//        }
//        else if (operator.left_trigger >0.2 ) {
//            stage1_1.setPower(1);
//            stage1_2.setPower(1);
//            stage2_1.setPower(1);
//            shooter.setPower(-.375);
//
//        }
//        else if (operator.dpad_up){
//            x=0;}
//        else if (operator.dpad_right){
//            x=1;}
//        else if (operator.dpad_down){
//            x=2;}
//        else if (operator.dpad_left){
//            x=3;}
//        else if(operator.b) {
//            shooter.setPower(-.6);
//            curOpMode.sleep(500);
//            shooter.setPower(0);
//
//        }
//
//        else if(operator.right_bumper){
//            input_lift.setPosition(.95b);
//
//        }
//        else if(operator.left_bumper){
//
//            input_lift.setPosition(0.5955);
//        }
//        else if(operator.x){
//            stage1_1.setPower(-1);
//            stage1_2.setPower(-1);
//            stage2_1.setPower(-1);
//            shooter.setPower(.5);
//            output.setPower(-.1);
//        }
//        else {
//            stage1_1.setPower(0);
//            stage1_2.setPower(0);
//            stage2_1.setPower(0);
//            shooter.setPower(0);
//            output.setPower(0);
//        }


        if (operator.b) {
            stage1_1.setPower(1);
            stage1_2.setPower(1);
            stage2_1.setPower(1);
            shooter.setPower(-.5);
            output.setPower(.1);
        } else if (operator.right_trigger > .2) {
            stage1_1.setPower(-1);
            stage1_2.setPower(-1);
            stage2_1.setPower(-1);
        } else if (operator.a) {
            input_lift.setPosition(.93);
            stage2_1.setPower(.5);
            stage1_1.setPower(0);
            shooter.setPower(-.3);
        } else if(operator.y) {
            stage1_1.setPower(-.25);
            stage2_1.setPower(-.25);
        } else if(operator.x){
            stage2_1.setPower(-.25);
        } else {
            stage1_1.setPower(0);
            stage1_2.setPower(0);
            stage2_1.setPower(0);
            shooter.setPower(0);
            output.setPower(0);
        }

        if(operator.left_trigger > .2){
            input_lift.setPosition(.95);
            shooter.setPower(operator.left_trigger/2);
            output.setPower(-operator.left_trigger/5);
        }


        if (operator.right_bumper) {
            input_lift.setPosition(.95);
        } else if (operator.left_bumper) {
            input_lift.setPosition(0.5955);
        }

        if(operator.dpad_up){
            lift.setPosition(.75);
        } else if (operator.dpad_down){
            lift.setPosition(.35);
        } else if (operator.dpad_right){
            lift.setPosition(.5);
        } else if (operator.dpad_left){
            lift.setPosition(.6);
        }

        if(operator.start){
            shoot();
        }
    }

    public static void shoot(){
        shooter.setPower(.25);
        output.setPower(-1);
        curOpMode.sleep(1500);
        stage1_1.setPower(-.25);
        stage2_1.setPower(-.25);
        curOpMode.sleep(5000);
    }

    public static void lowerArm(){
        lift.setPosition(.35);
    }

    public static void releaseGroundPixel(){
        stage1_1.setPower(1);
        curOpMode.sleep(1000);
        stage1_1.setPower(0);
    }

    public static void dropIntake() {
        input_lift.setPosition(0.5955);
    }

    public static void raiseIntake(){
        input_lift.setPosition(.95);
    }
}
