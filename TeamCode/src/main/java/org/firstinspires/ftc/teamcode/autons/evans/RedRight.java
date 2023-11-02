package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Red Right", group="OnBot")

public class RedRight extends LinearOpMode {
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

        pos = 2;

        CommonPrograms.redRightStart(pos);

//        AutoCommon.turnToAngleAuton(-90);
        AutoCommon.encoderTurn(.5, -750, 10);

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