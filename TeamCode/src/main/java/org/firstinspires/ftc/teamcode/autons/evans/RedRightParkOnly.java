package org.firstinspires.ftc.teamcode.autons.evans;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Red Right Park Only", group="OnBot")

public class RedRightParkOnly extends LinearOpMode {
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

        CommonPrograms.redRightStart(pos);

        AutoCommon.turnToAngleAuton(-90);

        AutoCommon.encoderStrafe(strafeSpeed, 10, 1000, false, true, false);

        AutoCommon.encoderDrive(driveSpeed, 2000, 10, true);
    }
}