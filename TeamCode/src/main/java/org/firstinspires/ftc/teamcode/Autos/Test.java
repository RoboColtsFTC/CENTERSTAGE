package org.firstinspires.ftc.teamcode.Autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drivetrain.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
@Disabled
public class Test extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        waitForStart();

//        if (isStopRequested()) return;

        drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)));

        int pos = 1;

        Trajectory traj;

        traj = drive.trajectoryBuilder(new Pose2d(-40,-10, Math.toRadians(0)), false)
                .splineToLinearHeading(new Pose2d(30, -10, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(50, -30, Math.toRadians(0)), Math.toRadians(0))
                .build();


        drive.followTrajectory(traj);

        Robot.endAngle = drive.getPoseEstimate().getHeading();
    }
}
