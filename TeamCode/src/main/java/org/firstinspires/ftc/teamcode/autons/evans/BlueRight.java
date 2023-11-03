package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.autons.CommonPrograms;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Blue Right", group="OnBot")

public class BlueRight extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    boolean red=false;

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
            telemetry.addData("Result Blue", camera.getResult());
            telemetry.update();
        }

        waitForStart();

        AutoCommon.resetEncoders();

        // Start
        pos = 2;

        CommonPrograms.blueRightStart(pos);

        AutoCommon.encoderDrive(driveSpeed, 1000, 10, true);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 2400, true, true, false);

        AutoCommon.encoderDrive(driveSpeed, -1175, 10, true);

        AutoCommon.turnToAngleAuton(90);

        AutoCommon.encoderDrive(driveSpeed, 1500, 10, true);

        // Left
        if(pos == 0){
            AutoCommon.encoderStrafe(strafeSpeed, 10, 400, true, true, false);

            ManipulatorCommon.shoot();

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1600, true, true, false);

        // Center
        } else if (pos == 1){
            ManipulatorCommon.shoot();

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1100, true, true, false);

        // Right
        } else {
            AutoCommon.encoderStrafe(strafeSpeed, 10, -400, true, true, false);

            ManipulatorCommon.shoot();

            AutoCommon.encoderStrafe(strafeSpeed, 10, -750, true, true, false);

        }

        AutoCommon.encoderDrive(driveSpeed, 500, 10, true);
    }
}