package org.firstinspires.ftc.teamcode.manipulator;

import static org.firstinspires.ftc.teamcode.Robot.*;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.fang;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.input_lift;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.lift;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.output;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.shooter;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.stage1_1;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.stage1_2;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.stage2_1;

public class ManipulatorCommon {
    public static boolean fangMovable = true;

    public static boolean liftMovable = true;


    public static double liftPos = 1;

    public static void initManipulatorCommon(){
        ManipulatorHardware.initManipulatorHardware();

        liftPos = 1;

        input_lift.setPosition(.925);
        lift.setPosition(1);
        fang.setPosition(0);


        fangMovable = true;
        liftMovable = true;
    }

    public static void executeManipulatorTeleop() {
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
            if(!fangMovable){
                input_lift.setPosition(.94);
            }
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
        }

        if(operator.right_stick_button){
            fang.setPosition(.5);
            fang.setPosition(.3);
        }

        if(operator.left_trigger > .2){

            if(fangMovable){
                output.setPower(-.2);
                shooter.setPower(.35);
            } else {
                output.setPower(-.35);
                shooter.setPower(.45);
            }

//            input_lift.setPosition(.95);

        }

        if(!(operator.left_trigger > .2) && !operator.a && !operator.b){
            shooter.setPower(0);
            output.setPower(0);
        }


        if (operator.right_bumper) {
            input_lift.setPosition(.95);
        } else if (operator.left_bumper) {
//            input_lift.setPosition(0.5955);
            input_lift.setPosition(0.585);
        }

        if(liftMovable){
            if(operator.dpad_up){
                liftPos = 1;
                lift.setPosition(1);
                input_lift.setPosition(.85);
                fangMovable = true;
            } else if (operator.dpad_down){
                if(liftPos > .6){
                    liftPos -= .075;
                }

                lift.setPosition(liftPos);
                input_lift.setPosition(.95);
                fangMovable = false;
            }
        }

        if(fangMovable){
            if(operator.dpad_left){
                fang.setPosition(.425);
                liftMovable = false;
            } else if(operator.dpad_right){
                fang.setPosition(0);
                liftMovable = true;
            }
        }
//        else if (operator.dpad_right){
//            lift.setPosition(.6);
//            fangMovable = true;
//        } else if (operator.dpad_left){
//            lift.setPosition(.3);
//            fangMovable = false;
//        }

//        if(operator.left_stick_button){
//            fang.setPosition(.2);
//        } else if(operator.right_stick_button){
//            fang.setPosition(.5);
//        }

//        curOpMode.telemetry.addData("Movable", movable);
//        curOpMode.telemetry.update();
    }

    public static void shoot(){
        shooter.setPower(.25);
        output.setPower(-1);
        curOpMode.sleep(1500);
        stage1_1.setPower(-.25);
        stage2_1.setPower(-.25);
        curOpMode.sleep(2000);
        stage1_1.setPower(0);
        stage2_1.setPower(0);
        shooter.setPower(0);
        output.setPower(0);
    }

    public static void otherShoot(){
        output.setPower(-.2);
        shooter.setPower(.35);
        lift.setPosition(1);
        curOpMode.sleep(1000);
        fang.setPosition(.425);
        curOpMode.sleep(500);
        stage1_1.setPower(-.25);
        stage2_1.setPower(-.25);
        curOpMode.sleep(2500);
        fang.setPosition(0);
        curOpMode.sleep(1000);
        lift.setPosition(.6);
        stage1_1.setPower(0);
        stage2_1.setPower(0);
        shooter.setPower(0);
        output.setPower(0);
    }

    public static void lowerArm(){
//        lift.setPosition(.65);
//        curOpMode.sleep(250);
//        lift.setPosition(.35);
        lift.setPosition(.6);
    }

    public static void releaseGroundPixel(){
        lowerArm();
        curOpMode.sleep(500);
        stage1_1.setPower(1);
        curOpMode.sleep(1000);
        stage1_1.setPower(0);
    }

    public static void turnOnReleaseGround(){
        stage1_1.setPower(1);
    }
    public static void turnOffReleaseGround(){
        stage1_1.setPower(0);
    }


    public static void dropIntake() {
        input_lift.setPosition(0.5955);
    }

    public static void raiseIntake(){
        input_lift.setPosition(.95);
    }
}
