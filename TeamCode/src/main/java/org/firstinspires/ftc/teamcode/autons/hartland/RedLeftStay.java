package org.firstinspires.ftc.teamcode.autons.hartland;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.autons.CommonPrograms;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Red Left Stay", group="OnBot")

public class RedLeftStay extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    boolean red=true;

    double driveSpeed = .5;
    double strafeSpeed = .5;

    Camera camera;

    int pos;

    @Override
    public void runOpMode() {

        Robot.init(true,true,false,true,false,this);

        camera = new Camera(this, red);

        while(!opModeIsActive()){
            pos = camera.getResult();
            telemetry.addData("Result Red", camera.getResult());
            telemetry.update();
        }

        waitForStart();

        AutoCommon.resetEncoders();

        // Start
        ManipulatorCommon.lowerArm();

        AutoCommon.encoderDrive(.5, 1000, 10, false);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(.5, 10, 500, true, true, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderDrive(.5, -500, 10, false);

            // Center
        } else if (pos == 1){
            AutoCommon.encoderStrafe(.5, 10, 200, true, true, false);

            AutoCommon.encoderDrive(.5, 200, 10, false);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderDrive(.5, -200, 10, false);

            // Right
        } else {

            AutoCommon.turnToAngleAuton(-90);

            ManipulatorCommon.releaseGroundPixel();

            AutoCommon.encoderDrive(.5, -300, 10, false);
        }
    }
}