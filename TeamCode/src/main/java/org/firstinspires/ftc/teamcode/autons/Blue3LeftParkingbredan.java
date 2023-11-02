package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Blue3LeftParkingbredans", group="OnBot")
@Disabled
public class Blue3LeftParkingbredan extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

    boolean red=false;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    @Override
    public void runOpMode() {


        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();
        //AutoCommon.encoderTurn(.5, 750, 10);
        //AutoCommon.encoderDrive(driveSpeed, 1500, 10, false);
        //AutoCommon.encoderStrafe(strafeSpeed, 10, 1250, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, 1100, 10, false);

        AutoCommon.encoderTurn(.5, 750, 10);

        AutoCommon.encoderDrive(driveSpeed, 1500, 10, false);

        sleep(1500);

        AutoCommon.encoderDrive(driveSpeed, -3850, 10, false);

        AutoCommon.encoderTurn(.5, -750, 10);

        AutoCommon.encoderDrive(driveSpeed, 4250, 10, false);

        AutoCommon.encoderTurn(.5, -750, 10);

        AutoCommon.encoderDrive(driveSpeed, 1100, 10, false);

















    }
}