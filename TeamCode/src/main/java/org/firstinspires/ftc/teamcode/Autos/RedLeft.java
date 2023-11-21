package org.firstinspires.ftc.teamcode.Autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drivetrain.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drivetrain.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drivetrain.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
@Disabled
public class RedLeft extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        int pos = 0;

        Camera camera = new Camera(this, true);

        while(!isStarted()){
            pos = camera.getResult();
        }

        waitForStart();

        drive.setPoseEstimate(new Pose2d(-36,-60, Math.toRadians(-90)));

        TrajectorySequence left1 = drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-45, -40, Math.toRadians(-90)), Math.toRadians(90))
                .build();

        TrajectorySequence left2 = drive.trajectorySequenceBuilder(left1.end())
                .lineToLinearHeading(new Pose2d(-45, -45, Math.toRadians(-90)))
                .lineToLinearHeading(new Pose2d(-35, -45, Math.toRadians(-90)))
                .lineToLinearHeading(new Pose2d(-35, 0, Math.toRadians(-90)))
//                .setTangent(90)
//                .splineToLinearHeading(new Pose2d(30, 0, Math.toRadians(0)), Math.toRadians(0))
                .lineToLinearHeading(new Pose2d(30, 0, Math.toRadians(0)))
                .setTangent(-90)
                .splineToLinearHeading(new Pose2d(47.5, -22.5, Math.toRadians(0)), Math.toRadians(0),
                        SampleMecanumDrive.getVelocityConstraint(15, Math.toRadians(180), DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .forward(5,
                        SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();


        TrajectorySequence center1 = drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-40, -30, Math.toRadians(-90)), Math.toRadians(90))
                .build();
        TrajectorySequence center2 = drive.trajectorySequenceBuilder(center1.end())
                .lineToLinearHeading(new Pose2d(-34, -37.5, Math.toRadians(-90)))
                .setTangent(-90)
                .splineToLinearHeading(new Pose2d(-53.5, -30, Math.toRadians(0)), Math.toRadians(90))
//                .waitSeconds(3)
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(30, -5, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(47.5, -27.5, Math.toRadians(0)), Math.toRadians(0),
                        SampleMecanumDrive.getVelocityConstraint(15, Math.toRadians(180), DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .forward(5,
                        SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();


        TrajectorySequence right1 = drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-33, -32, Math.toRadians(180)), Math.toRadians(0))
                .build();
        TrajectorySequence right2 = drive.trajectorySequenceBuilder(right1.end())
                .lineToLinearHeading(new Pose2d(-35, -32, Math.toRadians(180)))
                .lineToLinearHeading(new Pose2d(-35, -5, Math.toRadians(180)))
//                .waitSeconds(2)
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(47.5, -27.5, Math.toRadians(0)), Math.toRadians(-90))
                .setTangent(-90)
                .lineToLinearHeading(new Pose2d(45, -42, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();

        if(pos == 0){
            drive.followTrajectorySequence(left1);
            ManipulatorCommon.releaseGroundPixel();
            drive.followTrajectorySequence(left2);
        } else if(pos == 1){
            drive.followTrajectorySequence(center1);
            ManipulatorCommon.releaseGroundPixel();
            drive.followTrajectorySequence(center2);
        } else if(pos == 2){
            drive.followTrajectorySequence(right1);
            ManipulatorCommon.releaseGroundPixel();
            drive.followTrajectorySequence(right2);
        }

        ManipulatorCommon.otherShoot();

        TrajectorySequence rest = drive.trajectorySequenceBuilder(drive.getPoseEstimate())
                .back(10)
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(50, 0, Math.toRadians(0)), Math.toRadians(0))
                .build();

        drive.followTrajectorySequence(rest);

        Robot.endAngle = drive.getPoseEstimate().getHeading();
    }
}
