package org.firstinspires.ftc.teamcode.autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.vision.Camera;

@Autonomous(name="Red1LeftGate2Park", group="OnBot")

public class Red1LeftGate2Park extends LinearOpMode {
    private ElapsedTime     runtime = new ElapsedTime();

    AutoCommon auto=null;

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

        AutoCommon.encoderDrive(driveSpeed, 2400, 10, false);

        AutoCommon.encoderStrafe(strafeSpeed, 10, -2400, true, false, false);

        AutoCommon.encoderDrive(driveSpeed, -1175, 10, false);
        
        AutoCommon.encoderTurn(.5, -1075, 10);

        AutoCommon.encoderDrive(driveSpeed, 1500, 10, false);


        if(pos == 0){
            AutoCommon.encoderStrafe(strafeSpeed, 10, 400, true, false, false);

            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1600, true, false, false);

            // Left

        } else if (pos == 1){

            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -1100, true, false, false);

            // Center

        } else if(pos == 2){
            AutoCommon.encoderStrafe(strafeSpeed, 10, -400, true, false, false);

            sleep(2000);

            AutoCommon.encoderStrafe(strafeSpeed, 10, -750, true, false, false);

            // Right

        }

        AutoCommon.encoderDrive(driveSpeed, 350, 10, false);


    }
}