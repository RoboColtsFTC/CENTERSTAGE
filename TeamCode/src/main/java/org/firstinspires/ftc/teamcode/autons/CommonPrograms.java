package org.firstinspires.ftc.teamcode.autons;

import static org.firstinspires.ftc.teamcode.Robot.curOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

public class CommonPrograms {






    public static void redLeftStart(int pos){
        AutoCommon.encoderDrive(.5, 1000, 10, false);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(.5, 10, 500, true, true, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderStrafe(.5, 10, 500, false, true, false);

            AutoCommon.encoderDrive(.5, 300, 10, false);

            // Center
        } else if (pos == 1){
            AutoCommon.encoderDrive(.5, 300, 10, false);

            ManipulatorCommon.releaseGroundPixel();

            // Right
        } else {
            AutoCommon.encoderDrive(.5, 300, 10, false);

            AutoCommon.encoderTurn(.5, -750, 10);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderTurn(.5, 750, 10);
        }
    }









    public static void redRightStart(int pos){
        AutoCommon.encoderDrive(.5, 1000, 10, false);

        // Left
        if(pos == 0){
            AutoCommon.turnToAngleAuton(90);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.turnToAngleAuton(-90);

            // Center
        } else if (pos == 1){
            AutoCommon.encoderDrive(.5, 300, 10, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderDrive(.5, -300, 10, false);

            // Right
        } else {
            AutoCommon.encoderStrafe(.5, 10, 500, false, true, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderStrafe(.5, 10, 500, true, true, false);
        }
    }








    public static void blueRightStart(int pos){
        ManipulatorCommon.lowerArm();

        AutoCommon.encoderDrive(.5, 1000, 10, false);

        // Left
        if(pos == 0){
            AutoCommon.turnToAngleAuton(90);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.turnToAngleAuton(0);

            AutoCommon.encoderDrive(.5, 300, 10, false);

            // Center
        } else if (pos == 1){
            AutoCommon.encoderDrive(.5, 300, 10, false);

            ManipulatorCommon.releaseGroundPixel();

            // Right
        } else {
            AutoCommon.encoderStrafe(.5, 10, 500, false, true, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderStrafe(.5, 10, 500, true, true, false);

            AutoCommon.encoderDrive(.5, 300, 10, false);
        }
    }







    public static void blueLeftStart(int pos){
        ManipulatorCommon.lowerArm();

        AutoCommon.encoderDrive(.5, 1000, 10, false);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(.5, 10, 500, true, true, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderStrafe(.5, 10, 500, false, true, false);

            // Center
        } else if (pos == 1){
            AutoCommon.encoderDrive(.5, 300, 10, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderDrive(.5, -300, 10, false);

            // Right
        } else {

            AutoCommon.encoderTurn(.5, -750, 10);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderTurn(.5, 750, 10);
        }
    }
}
