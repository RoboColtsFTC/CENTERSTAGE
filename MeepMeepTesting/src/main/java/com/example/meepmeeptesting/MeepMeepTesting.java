package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.SampleMecanumDrive;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

//import static

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-38, -32, Math.toRadians(0)), Math.toRadians(90))
                        .addDisplacementMarker(() -> {})
                        .waitSeconds(1)
                        .addDisplacementMarker(() -> {})
                        .lineToLinearHeading(new Pose2d(-35, -32, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(-35, -10, Math.toRadians(0)))
                        .waitSeconds(3)
                        .setReversed(false)
                        .splineToLinearHeading(new Pose2d(45, -28, Math.toRadians(0)), Math.toRadians(-90))
                        .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                SampleMecanumDrive.getAccelerationConstraint(5))
                        .back(10)
                        .setTangent(90)
                        .splineToLinearHeading(new Pose2d(56, -10, Math.toRadians(0)), Math.toRadians(0))
                        .build()
                );

        RoadRunnerBotEntity myBot1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-34, -32.5, Math.toRadians(-90)), Math.toRadians(90))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-34, -37.5, Math.toRadians(-90)))
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(-53.5, -30, Math.toRadians(0)), Math.toRadians(90))
                                .waitSeconds(3)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(30, -10, Math.toRadians(0)), Math.toRadians(0))
                                .splineToLinearHeading(new Pose2d(45, -35, Math.toRadians(0)), Math.toRadians(0))
                                .forward(5,
                                        SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .waitSeconds(3)
                                .back(10)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(56, -10, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );
        RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-33, -32, Math.toRadians(180)), Math.toRadians(0))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-35, -32, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-35, -10, Math.toRadians(180)))
                                .waitSeconds(3)
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(40, -27.5, Math.toRadians(0)), Math.toRadians(-90))
                                .setTangent(-90)
                                .lineToLinearHeading(new Pose2d(45, -42, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .waitSeconds(3)
                                .back(10)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(56, -10, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );







        RoadRunnerBotEntity redLeftLeftStop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-38, -32, Math.toRadians(0)), Math.toRadians(90))
                        .addDisplacementMarker(() -> {})
                        .waitSeconds(1)
                        .addDisplacementMarker(() -> {})
                        .lineToLinearHeading(new Pose2d(-35, -32, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(-35, -10, Math.toRadians(0)))
                        .build()
                );

        RoadRunnerBotEntity redLeftCenterStop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-34, -32.5, Math.toRadians(-90)), Math.toRadians(90))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-34, -37.5, Math.toRadians(-90)))
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(-53.5, -30, Math.toRadians(0)), Math.toRadians(90))
                                .build()
                );
        RoadRunnerBotEntity redLeftRightStop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-33, -32, Math.toRadians(180)), Math.toRadians(0))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-35, -32, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-35, -10, Math.toRadians(180)))
                                .build()
                );













        RoadRunnerBotEntity rightLeft = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(9, -32, Math.toRadians(0)), Math.toRadians(180))
                                .waitSeconds(1)
                                .lineToLinearHeading(new Pose2d(45, -28, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(56, -60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );


        RoadRunnerBotEntity rightCenter = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(14, -32, Math.toRadians(-90)), Math.toRadians(90))
                                .waitSeconds(1)
                                .lineToLinearHeading(new Pose2d(14, -40, Math.toRadians(-90)))
                                .lineToLinearHeading(new Pose2d(45, -35, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(56, -60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );

        RoadRunnerBotEntity rightRight = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(23, -40, Math.toRadians(-90)), Math.toRadians(90))
                                .waitSeconds(1)
                                .forward(10)
                                .lineToLinearHeading(new Pose2d(45, -42, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(56, -60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );







        RoadRunnerBotEntity brightRight = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(40, 40, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-38, 32, Math.toRadians(0)), Math.toRadians(-90))
                        .addDisplacementMarker(() -> {})
                        .waitSeconds(1)
                        .addDisplacementMarker(() -> {})
                        .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(0)))
                        .waitSeconds(3)
                        .setReversed(false)
                        .splineToLinearHeading(new Pose2d(45, 28, Math.toRadians(0)), Math.toRadians(90))
                        .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                SampleMecanumDrive.getAccelerationConstraint(5))
                        .back(10)
                        .setTangent(-90)
                        .splineToLinearHeading(new Pose2d(56, 10, Math.toRadians(0)), Math.toRadians(0))
                        .build()
                );

        RoadRunnerBotEntity brightCenter = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(40, 40, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-34, 32.5, Math.toRadians(90)), Math.toRadians(-90))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
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
                                .waitSeconds(3)
                                .back(10)
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(56, 10, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );
        RoadRunnerBotEntity brightLeft = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(40, 40, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-33, 32, Math.toRadians(180)), Math.toRadians(0))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(180)))
                                .waitSeconds(3)
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(40, 27.5, Math.toRadians(0)), Math.toRadians(90))
                                .setTangent(90)
                                .lineToLinearHeading(new Pose2d(45, 42, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .waitSeconds(3)
                                .back(10)
                                .setTangent(-90)
                                .splineToLinearHeading(new Pose2d(56, 10, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );









        RoadRunnerBotEntity brightRightStop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-38, 32, Math.toRadians(0)), Math.toRadians(-90))
                        .addDisplacementMarker(() -> {})
                        .waitSeconds(1)
                        .addDisplacementMarker(() -> {})
                        .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(0)))
                        .build()
                );

        RoadRunnerBotEntity brightCenterStop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-34, 32.5, Math.toRadians(90)), Math.toRadians(-90))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-34, 37.5, Math.toRadians(90)))
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(-53.5, 30, Math.toRadians(0)), Math.toRadians(-90))
                                .build()
                );
        RoadRunnerBotEntity brightLeftstop = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-33, 32, Math.toRadians(180)), Math.toRadians(0))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(180)))
                                .build()
                );





        RoadRunnerBotEntity brightRightPark = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-38, 32, Math.toRadians(0)), Math.toRadians(-90))
                        .addDisplacementMarker(() -> {})
                        .waitSeconds(1)
                        .addDisplacementMarker(() -> {})
                        .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(0)))
                        .build()
                );

        RoadRunnerBotEntity brightCenterPark = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-34, 32.5, Math.toRadians(90)), Math.toRadians(-90))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-34, 37.5, Math.toRadians(90)))
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(-53.5, 30, Math.toRadians(0)), Math.toRadians(-90))
                                .build()
                );
        RoadRunnerBotEntity brightLeftPark = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(-33, 32, Math.toRadians(180)), Math.toRadians(0))
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(1)
                                .addDisplacementMarker(() -> {})
                                .lineToLinearHeading(new Pose2d(-35, 32, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-35, 10, Math.toRadians(180)))
                                .build()
                );









        RoadRunnerBotEntity BleftLeft = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(23, 40, Math.toRadians(90)), Math.toRadians(-90))
                                .waitSeconds(1)
                                .forward(10)
                                .lineToLinearHeading(new Pose2d(45, 42, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(56, 60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );


        RoadRunnerBotEntity BleftCenter = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(14, 32, Math.toRadians(90)), Math.toRadians(-90))
                                .waitSeconds(1)
                                .lineToLinearHeading(new Pose2d(14, 40, Math.toRadians(90)))
                                .lineToLinearHeading(new Pose2d(45, 35, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(56, 60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );

        RoadRunnerBotEntity BleftRight = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->

                        drive.trajectorySequenceBuilder(new Pose2d(12,60, Math.toRadians(90)))
                                .setReversed(true)
                                .splineToLinearHeading(new Pose2d(9, 32, Math.toRadians(0)), Math.toRadians(180))
                                .waitSeconds(1)
                                .lineToLinearHeading(new Pose2d(45, 28, Math.toRadians(0)))
                                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                                        SampleMecanumDrive.getAccelerationConstraint(5))
                                .back(10)
                                .setTangent(90)
                                .splineToLinearHeading(new Pose2d(56, 60, Math.toRadians(0)), Math.toRadians(0))
                                .build()
                );

        RoadRunnerBotEntity test = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(12,-60, Math.toRadians(-90)))
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(9, -32, Math.toRadians(0)), Math.toRadians(-180))
                .lineToLinearHeading(new Pose2d(45, -23, Math.toRadians(0)))
                .forward(5, SampleMecanumDrive.getVelocityConstraint(5, Math.toRadians(180), 18),
                        SampleMecanumDrive.getAccelerationConstraint(5))
                .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)

//                .addEntity(myBot)
//                .addEntity(myBot1)
//                .addEntity(myBot2)
//
//                .addEntity(rightLeft)
//                .addEntity(rightCenter)
//                .addEntity(rightRight)
//
//                .addEntity(BleftLeft)
//                .addEntity(BleftCenter)
//                .addEntity(BleftRight)
//
//                .addEntity(brightLeft)
//                .addEntity(brightCenter)
//                .addEntity(brightRight)

//                .addEntity(redLeftCenterStop)
//                .addEntity(redLeftLeftStop)
//                .addEntity(redLeftRightStop)

//                .addEntity(brightRightStop)
//                .addEntity(brightLeftstop)
//                .addEntity(brightCenterStop)

                .addEntity(test)


                .start();
    }
}