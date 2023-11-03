package org.firstinspires.ftc.teamcode.autons.evans;

import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorHardware.lift;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.autons.AutoCommon;
import org.firstinspires.ftc.teamcode.autons.CommonPrograms;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Blue Right Stay", group="OnBot")

public class BlueRightStay extends LinearOpMode {
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

        pos = 1;

        CommonPrograms.blueRightStart(pos);

        AutoCommon.encoderDrive(.5, -500, 10, false);

        AutoCommon.turnToAngleAuton(90);

        AutoCommon.encoderDrive(.5, -500, 10, false);

        lift.setPosition(.5);

        sleep(1000);

        ManipulatorCommon.shoot();
    }
}