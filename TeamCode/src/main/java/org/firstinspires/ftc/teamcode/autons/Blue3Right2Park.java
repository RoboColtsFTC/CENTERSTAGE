package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Blue3Right2Park", group="OnBot")
@Disabled
public class Blue3Right2Park extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

    boolean red=false;

    double driveSpeed = .6;
    double strafeSpeed = .6;

    @Override
    public void runOpMode() {


        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();

         AutoCommon.encoderDrive(driveSpeed, 1200, 10, false);

        AutoCommon.encoderTurn(.5, 750, 10);

        AutoCommon.encoderDrive(driveSpeed, 1400, 10, false);

        sleep(2000);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 1250, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, -4250, 10, false);

        AutoCommon.encoderStrafe(strafeSpeed, 10, -5500, true, false, false);

        AutoCommon.encoderTurn(.5, -1100, 10);

        AutoCommon.encoderDrive(driveSpeed, 400, 10, false);

        sleep(2000);

        AutoCommon.encoderDrive(driveSpeed, -400, 10, false);

         AutoCommon.encoderTurn(.5, 1100, 10);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 5500, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, 2000, 10, false);

    }
}