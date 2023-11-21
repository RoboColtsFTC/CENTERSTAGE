package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drivetrain.TeleopDrivetrain;
import org.firstinspires.ftc.teamcode.manipulator.ManipulatorCommon;

public final class Robot {
    public static LinearOpMode curOpMode;
    public static Gamepad driver;
    public static Gamepad operator;
    public static HardwareMap hwMap;
    public static boolean hasManipulator;
    public static boolean hasDrivetrain;
    public static boolean hasClimber;
    public static boolean hasSensors;
    public enum LoopStates {Running, Completed};

    public static LoopStates DrivetrainLoopState;
    public static LoopStates LiftClawLoopState;

    public static double endAngle = 0;

    public static void init(boolean drivetrainAdded, boolean manipulator,
                            boolean climberAdded, boolean autonAdded,
                            boolean sensorsAdded,
                            LinearOpMode opMode)
    {
        curOpMode=opMode;
        hwMap=opMode.hardwareMap;

        driver=curOpMode.gamepad1;
        operator=curOpMode.gamepad2;



        if(drivetrainAdded) {
            TeleopDrivetrain.initDrivetrain();
            hasDrivetrain = drivetrainAdded;
        }

        if(manipulator) {
            ManipulatorCommon.initManipulatorCommon();
            hasManipulator = manipulator;
        }

        if(sensorsAdded)
        {

        }

        if(autonAdded)
        {

        }

        if(climberAdded){
            Climber.initClimber();
            hasClimber = hasClimber;
        }


    }
}
