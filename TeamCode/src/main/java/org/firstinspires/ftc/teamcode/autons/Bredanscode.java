package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Bredanscode", group="OnBot")

public class Bredanscode extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

    boolean red=false;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    @Override
    public void runOpMode() {
        

        Robot.init(true,false,false,true,false,this);

        //AutoCommon.resetEncoders();

        AutoCommon.encoderDrive(driveSpeed, 2300, 10, false);

        AutoCommon.encoderStrafe(strafeSpeed, 10, -2400, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, -1100, 10, false);

        AutoCommon.encoderTurn(.5, -790, 10);

        AutoCommon.encoderDrive(driveSpeed, 1400, 10, false);

        sleep(1000);

        AutoCommon.encoderDrive(driveSpeed, -1400, 10, false);

        //AutoCommon.encoderStrafe(strafeSpeed, 10, -1100, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, -2575, 10, false);

        AutoCommon.encoderTurn(1, 790, 10);






        //AutoCommon.encoderStrafe(strafeSpeed, 10, 2600, true, false, false);

        //AutoCommon.encoderTurn(.5, 775, 10);


    }
}