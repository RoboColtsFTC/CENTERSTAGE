package org.firstinspires.ftc.teamcode.manipulator;

import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.*;
import static org.firstinspires.ftc.teamcode.Robot.*;

public class ManipulatorCommon {

    public static int x;

    public static void initManipulatorCommon(){
        ManipulatorHardware.initManipulatorHardware();

        x = 0;
    }

    public static void executeManipulatorTeleop(){
        if (x < 0 || x > 3) {
            x = 0;
        }

        if (operator.right_bumper) {
            stage1_1.setPower(-1);
            stage1_2.setPower(-1);
        } else {
            stage1_1.setPower(0);
            stage1_2.setPower(0);
        }

        if (operator.left_bumper) {
            stage1_1.setPower(1);
            stage1_2.setPower(1);
        } else {
            stage1_1.setPower(0);
            stage2_1.setPower(0);
        }

        if (operator.a && x == 0) {
            stage1_2.setPower(-1);
            curOpMode.sleep(1);
            stage1_1.setPower(-1);
            curOpMode.sleep(200);
            stage1_1.setPower(0);
            curOpMode.sleep(10);
            stage1_2.setPower(0);
            x = 1;
            curOpMode.updateTelemetry(curOpMode.telemetry);
        }

        if (operator.a && x == 1) {
            stage1_2.setPower(-1);
            curOpMode.sleep(1);
            stage1_1.setPower(-1);
            stage2_1.setPower(-.25);
            curOpMode.sleep(300);
            stage1_1.setPower(0);
            stage2_1.setPower(0);
            stage1_2.setPower(0);
            x = 2;
            curOpMode.updateTelemetry(curOpMode.telemetry);
        }

        if (x == 2) {
            curOpMode.sleep(750);
            input_lift.setPosition(.5);
            curOpMode.sleep(1000);
            x = 3;
            curOpMode.updateTelemetry(curOpMode.telemetry);
        }

        if (operator.right_trigger > 0.2 && x == 3) {
            output.setPower(-.10);
            shooter.setPower(.5);
            curOpMode.sleep(250);
            stage2_1.setPower(-1);
            output.setPower(-1);
            curOpMode.sleep(900);
            stage1_1.setPower(-1);
            stage2_1.setPower(-1);
            output.setPower(-1);
            curOpMode.sleep(1250);
            shooter.setPower(0);
            curOpMode.sleep(1000);
            output.setPower(0);
            input_lift.setPosition(1);
            x = 0;
        }

        if (operator.left_trigger >0.2 ) {
            stage1_1.setPower(1);
            stage2_1.setPower(1);
            shooter.setPower(-.375);
        } else {
            stage1_1.setPower(0);
            stage1_2.setPower(0);
            shooter.setPower(0);
            curOpMode.updateTelemetry(curOpMode.telemetry);
        }

        if (operator.dpad_up){
            x=0;
        } else if (operator.dpad_right){
            x=1;
        } else if (operator.dpad_down){
            x=2;
        } else if (operator.dpad_left){
            x=3;
        }

        if(operator.b) {
            shooter.setPower(-.6);
            curOpMode.sleep(500);
            shooter.setPower(0);
        }
    }

    public void shootAll(){

    }

    public void releaseGroundPixel(){

    }

    public void dropIntake() {

    }

    public void raiseIntake(){

    }
}
