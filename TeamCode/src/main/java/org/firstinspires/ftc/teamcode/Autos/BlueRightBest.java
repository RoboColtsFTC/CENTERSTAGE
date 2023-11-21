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
public class BlueRightBest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        waitForStart();

        drive.setPoseEstimate(new Pose2d(-36,60, Math.toRadians(90)));

        int pos = 1;

        ManipulatorCommon.lowerArm();

        TrajectorySequence left = drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-33, 32, Math.toRadians(180)), Math.toRadians(0))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(180)))
                .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(180)))
                .waitSeconds(3)
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(40, 27.5, Math.toRadians(0)), Math.toRadians(90))
                .setTangent(90)
                .lineToLinearHeading(new Pose2d(45, 42, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();

        TrajectorySequence center = drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-34, 32.5, Math.toRadians(90)), Math.toRadians(-90))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(-34, 37.5, Math.toRadians(90)))
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-53.5, 30, Math.toRadians(0)), Math.toRadians(-90))
                .waitSeconds(3)
                .setTangent(-90)
                .splineToLinearHeading(new Pose2d(30, 10, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(45, 35, Math.toRadians(0)), Math.toRadians(0))
                .forward(5,
                        SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();

        TrajectorySequence right = drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-38, 32, Math.toRadians(0)), Math.toRadians(-90))
                .addDisplacementMarker(() -> ManipulatorCommon.turnOnReleaseGround())
                .waitSeconds(1)
                .addDisplacementMarker(() -> ManipulatorCommon.turnOffReleaseGround())
                .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(0)))
                .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(0)))
                .waitSeconds(3)
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(45, 28, Math.toRadians(0)), Math.toRadians(90))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
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
                .back(10)
                .setTangent(-90)
                .splineToLinearHeading(new Pose2d(56, 10, Math.toRadians(0)), Math.toRadians(0))
                .build();

        drive.followTrajectorySequence(rest);

        Robot.endAngle = drive.getPoseEstimate().getHeading();
    }
}
