package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Blue Left Park Only", group="OnBot")

public class BlueLeftParkOnly extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    boolean red=false;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    Camera camera;

    int pos;

    @Override
    public void runOpMode() {

        camera = new Camera(this, red);

        while(!opModeIsActive()){
            pos = camera.getResult();
            telemetry.addData("Result Blue", camera.getResult());
            telemetry.update();
        }

        waitForStart();

        Robot.init(true,false,false,true,false,this);

        AutoCommon.resetEncoders();

        // Start

        CommonPrograms.blueLeftStart(pos);

        AutoCommon.turnToAngleAuton(90);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 1000, true, true, false);

        AutoCommon.encoderDrive(driveSpeed, 2000, 10, true);


    }
}