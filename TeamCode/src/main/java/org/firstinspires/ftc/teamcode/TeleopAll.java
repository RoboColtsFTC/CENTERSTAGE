package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon.executeManipulatorTeleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.TeleopDrivetrain;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;


@TeleOp(name="TeleOp", group="Pushbot")
//@Disabled

public class TeleopAll extends LinearOpMode {

    @Override
    public void runOpMode() {

        Robot.DrivetrainLoopState = Robot.LoopStates.Completed;
        Robot.init(true,true,true,true,true,this);

        waitForStart();

        while (opModeIsActive()) {

            TeleopDrivetrain.executeTeleop();
            executeManipulatorTeleop();
            Climber.executeClimberTeleop();

        }
    }

}