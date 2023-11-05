package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon_ALT1.executeDrivetrainTeleop;
import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon.executeManipulatorTeleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainHardware;
import org.firstinspires.ftc.teamcode.vision.Camera;

@TeleOp(name="Camera", group="Pushbot")
//@Disabled

public class CameraTest extends LinearOpMode {

    Camera camera;

    @Override
    public void runOpMode() {

        camera = new Camera(this, true);

        while(!isStarted()){
            telemetry.addData("Red: ", camera.getResult());
        }

        camera.closeCamera();

        waitForStart();

        camera = new Camera(this, false);

        while (opModeIsActive()) {
            telemetry.addData("Blue: ", camera.getResult());
        }

        camera.closeCamera();
    }

}