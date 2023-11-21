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
public class BlueLeft extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Robot.init(false,true,false,true,false,this);

        waitForStart();

//        if (isStopRequested()) return;

        drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)));

        int pos = 1;

        Trajectory traj;

        ManipulatorCommon.lowerArm();

        if(pos == 0){
            traj = drive.trajectoryBuilder(new Pose2d(0,0,Math.toRadians(180)), true)
                    .splineToLinearHeading(new Pose2d(18, 10, Math.toRadians(180)), Math.toRadians(0))
                    .build();

            drive.followTrajectory(traj);

            ManipulatorCommon.releaseGroundPixel();

            traj = drive.trajectoryBuilder(traj.end(), false)
                    .lineToLinearHeading(new Pose2d(10, 10, Math.toRadians(180)))
                    .build();

            drive.followTrajectory(traj);

            traj = drive.trajectoryBuilder(traj.end(), false)
                    .lineToLinearHeading(new Pose2d(30, 36, Math.toRadians(180)))
                    .build();

            drive.followTrajectory(traj);
        } else if(pos == 1){
            traj = drive.trajectoryBuilder(new Pose2d(0,0,Math.toRadians(180)), true)
                    .splineToLinearHeading(new Pose2d(28, 3, Math.toRadians(180)), Math.toRadians(0))
                    .build();

            drive.followTrajectory(traj);

            ManipulatorCommon.releaseGroundPixel();

            traj = drive.trajectoryBuilder(traj.end(), false)
                    .lineToLinearHeading(new Pose2d(10, 3, Math.toRadians(180)))
                    .build();

            drive.followTrajectory(traj);

            traj = drive.trajectoryBuilder(traj.end(), false)
                    .lineToLinearHeading(new Pose2d(30, 36, Math.toRadians(90)))
                    .build();

            drive.followTrajectory(traj);
        } else {
            traj = drive.trajectoryBuilder(new Pose2d(0,0,Math.toRadians(180)), true)
                    .splineToLinearHeading(new Pose2d(27, -2.5, Math.toRadians(90)), Math.toRadians(-90))
                    .build();

            drive.followTrajectory(traj);

            ManipulatorCommon.releaseGroundPixel();

            traj = drive.trajectoryBuilder(traj.end(), false)
                    .lineToLinearHeading(new Pose2d(37.5, 36, Math.toRadians(90)))
                    .build();

            drive.followTrajectory(traj);
        }





        ManipulatorCommon.shoot();

        traj = drive.trajectoryBuilder(traj.end(), false)
                .lineToLinearHeading(new Pose2d(2, 30, Math.toRadians(90)))
                .build();

        drive.followTrajectory(traj);

        traj = drive.trajectoryBuilder(traj.end(), false)
                .lineToLinearHeading(new Pose2d(2, 42.5, Math.toRadians(90)))
                .build();

        drive.followTrajectory(traj);

        Robot.endAngle = drive.getPoseEstimate().getHeading();
    }
}
