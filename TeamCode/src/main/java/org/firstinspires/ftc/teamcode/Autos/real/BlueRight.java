package org.firstinspires.ftc.teamcode.Autos.real;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.drivetrain.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drivetrain.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;
import org.firstinspires.ftc.teamcode.vision.Camera;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class BlueRight extends LinearOpMode {
    @Override


    public void runOpMode() throws InterruptedException {
        int pos = 0;

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        Camera camera = new Camera(this, false);

        while(!isStarted()){
            pos = camera.getResult();
        }


        waitForStart();



        drive.setPoseEstimate(new Pose2d(12,-60, Math.toRadians(-90)));


        TrajectorySequence left1 = drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(23, -40, Math.toRadians(-90)), Math.toRadians(90))
                .build();
        TrajectorySequence left2 = drive.trajectorySequenceBuilder(left1.end())
                .forward(10)
                .lineToLinearHeading(new Pose2d(45, -38, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();


        TrajectorySequence center1 = drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(16, -31, Math.toRadians(-90)), Math.toRadians(90))
                .build();
        TrajectorySequence center2 = drive.trajectorySequenceBuilder(center1.end())
                .lineToLinearHeading(new Pose2d(14, -40, Math.toRadians(-90)))
                .lineToLinearHeading(new Pose2d(45, -31, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();


        TrajectorySequence right1 = drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(9, -32, Math.toRadians(0)), Math.toRadians(-180))
                .build();
        TrajectorySequence right2 = drive.trajectorySequenceBuilder(right1.end())
                .lineToLinearHeading(new Pose2d(45, -23, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build();

        if(pos == 2){
            drive.followTrajectorySequence(left1);
            ManipulatorCommon.releaseGroundPixel();
//            drive.followTrajectorySequence(left2);
//            drive.followTrajectorySequence(drive.trajectorySequenceBuilder(left1.end())
//                    .lineToLinearHeading(new Pose2d(15,32,Math.toRadians(180)))
//                    .build());
        } else if(pos == 1){
            drive.followTrajectorySequence(center1);
            ManipulatorCommon.releaseGroundPixel();
//            drive.followTrajectorySequence(center2);
//            drive.followTrajectorySequence(drive.trajectorySequenceBuilder(center1.end())
//                    .lineToLinearHeading(new Pose2d(15,32,Math.toRadians(180)))
//                    .build());
        } else if(pos == 0){
            drive.followTrajectorySequence(right1);
            ManipulatorCommon.releaseGroundPixel();
//            drive.followTrajectorySequence(right2);
//            drive.followTrajectorySequence(drive.trajectorySequenceBuilder(right1.end())
//                    .lineToLinearHeading(new Pose2d(15,32,Math.toRadians(180)))
//                    .build());
        }

//        ManipulatorCommon.shoot();
//
//        TrajectorySequence rest = drive.trajectorySequenceBuilder(drive.getPoseEstimate())
//                .back(10)
//                .setTangent(-90)
//                .splineToLinearHeading(new Pose2d(56, -60, Math.toRadians(0)), Math.toRadians(0))
//                .build();
//
//        drive.followTrajectorySequence(rest);

        Robot.endAngle = drive.getPoseEstimate().getHeading() + Math.toRadians(90);
    }
}
