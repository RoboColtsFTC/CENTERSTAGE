package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon.executeManipulatorTeleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.TeleopDrivetrain;


@TeleOp(name="Only Drive", group="Pushbot")
//@Disabled

public class OnlyDrive extends LinearOpMode {

    @Override
    public void runOpMode() {

        Robot.DrivetrainLoopState = Robot.LoopStates.Completed;
        Robot.init(true,false,false,true,true,this);

        waitForStart();

        while (opModeIsActive()) {
            TeleopDrivetrain.executeTeleop();
        }
    }

}