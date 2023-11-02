package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Blue Left", group="OnBot")

public class BlueLeft extends LinearOpMode {
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

        AutoCommon.encoderDrive(driveSpeed, 1000, 10, true);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(strafeSpeed, 10, 250, true, true, false);

            // Score the thing
            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, 250, false, true, false);

        // Center
        } else if (pos == 1){
            AutoCommon.encoderDrive(driveSpeed, 300, 10, true);

            // Score the thing
            sleep(2000);

            AutoCommon.encoderDrive(driveSpeed, -300, 10, true);

        // Right
        } else {
            AutoCommon.encoderStrafe(strafeSpeed, 10, 250, false, true, false);

            // Score the thing
            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, 250, true, true, false);
        }

        AutoCommon.turnToAngleAuton(90);

        AutoCommon.encoderDrive(driveSpeed, 1500, 10, true);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(strafeSpeed, 10, 400, true, true, false);

            // Score the other thing
            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1600, true, true, false);

        // Center
        } else if (pos == 1){
            // Score the thing
            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1100, true, true, false);

        // Right
        } else {
            AutoCommon.encoderStrafe(strafeSpeed, 10, -400, true, true, false);

            // Score the other thing
            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -750, true, true, false);

        }

        AutoCommon.encoderDrive(driveSpeed, 500, 10, true);
    }
}