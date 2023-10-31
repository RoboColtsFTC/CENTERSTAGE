package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="AutonRed2Left", group="OnBot")

public class AutonRed2Left extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

    boolean red=false;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    @Override
    public void runOpMode() {


        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();

        AutoCommon.encoderDrive(driveSpeed, 150, 10, false);

        AutoCommon.encoderStrafe(strafeSpeed, 10, -2500, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, 1100, 10, false);

        AutoCommon.encoderTurn(.5, -750, 10);

        AutoCommon.encoderDrive(driveSpeed, 1300, 10, false);

        sleep(2000);

        AutoCommon.encoderStrafe(strafeSpeed, 10, -1400, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, 350, 10, false);
    }
}