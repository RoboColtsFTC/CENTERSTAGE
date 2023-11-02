package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Red Left Park Only", group="OnBot")

public class RedLeftParkOnly extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    boolean red=true;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    Camera camera;

    int pos;

    @Override
    public void runOpMode() {

        camera = new Camera(this, red);

        while(!opModeIsActive()){
            pos = camera.getResult();
            telemetry.addData("Result Red", camera.getResult());
            telemetry.update();
        }

        waitForStart();

        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();

        // Start

        CommonPrograms.redLeftStart(pos);

        AutoCommon.encoderDrive(driveSpeed, 1200, 10, true);

        AutoCommon.turnToAngleAuton(-90);

        AutoCommon.encoderDrive(driveSpeed, 3000, 10, true);
    }
}