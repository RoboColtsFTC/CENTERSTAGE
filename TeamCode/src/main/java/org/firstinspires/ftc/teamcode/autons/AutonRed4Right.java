package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="AutonRed4Right", group="OnBot")
@Disabled
public class AutonRed4Right extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

    boolean red=false;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    @Override
    public void runOpMode() {


        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();

        AutoCommon.encoderDrive(driveSpeed, 1200, 10, false);

        AutoCommon.encoderTurn(.5, -750, 10);

        AutoCommon.encoderDrive(driveSpeed, 1400, 10, false);

        sleep(2000);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 1400, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, -4500, 10, false);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 3000, true, false, false);

        AutoCommon.encoderTurn(.5, 1500, 10);

        AutoCommon.encoderDrive(driveSpeed, 300, 10, false);

        AutoCommon.encoderDrive(driveSpeed, -300, 10, false);

        AutoCommon.encoderTurn(.5, 350, 10);


        //AutoCommon.encoderDrive(driveSpeed, -3000, 10, false);

        //AutoCommon.encoderStrafe(strafeSpeed, 10, -2400, true, false, false);

        //AutoCommon.encoderDrive(driveSpeed, 350, 10, false);


    }
}