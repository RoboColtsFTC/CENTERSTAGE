package org.firstinspires.ftc.teamcode.Autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drivetrain.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drivetrain.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
@Disabled
public class BlueRightBetter extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        waitForStart();
        
        drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)));

        int pos = 1;

        ManipulatorCommon.lowerArm();

        TrajectorySequence left = drive.trajectorySequenceBuilder(new Pose2d(0,0, Math.toRadians(180)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27, 2.5, Math.toRadians(-90)), Math.toRadians(90))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(40, 2.5, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(40,64, Math.toRadians(-90)), Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(10,84, Math.toRadians(-90)), Math.toRadians(90))
                .build();

        TrajectorySequence center = drive.trajectorySequenceBuilder(new Pose2d(0,0, Math.toRadians(180)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(32, 0, Math.toRadians(-90)), Math.toRadians(0))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(45, 0, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(45,64, Math.toRadians(-90)), Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(10,84, Math.toRadians(-90)), Math.toRadians(90))
                .build();

        TrajectorySequence right = drive.trajectorySequenceBuilder(new Pose2d(0,0, Math.toRadians(180)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27, -2.5, Math.toRadians(90)), Math.toRadians(-90))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(45, 0, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(45,64, Math.toRadians(-90)), Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(10,84, Math.toRadians(-90)), Math.toRadians(90))
                .build();


        if(pos == 0){
            drive.followTrajectorySequence(left);
        } else if(pos == 1){
            drive.followTrajectorySequence(center);
        } else if(pos == 2){
            drive.followTrajectorySequence(right);
        }

        ManipulatorCommon.shoot();

        TrajectorySequence rest = drive.trajectorySequenceBuilder(drive.getPoseEstimate())
                .lineToLinearHeading(new Pose2d(30, 78, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(30, 90.5, Math.toRadians(90)))
                .build();

        drive.followTrajectorySequence(rest);

        Robot.endAngle = drive.getPoseEstimate().getHeading();
    }
}
