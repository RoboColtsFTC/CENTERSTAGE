package org.firstinspires.ftc.teamcode.drivetrain;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;

import static org.firstinspires.ftc.teamcode.Robot.driver;
import static org.firstinspires.ftc.teamcode.Robot.hwMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.Robot;

public class TeleopDrivetrain {
//    public static BHI260IMU imu;
    public static MecanumDrive drive;

    public static BNO055IMU imu2;
//    public static IMU imu2;
    public static BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();



    public static void initDrivetrain() {
        /* instantiate motors */

        Motor lf = new Motor(hwMap, "drive_LF", Motor.GoBILDA.RPM_312);
        Motor rf = new Motor(hwMap, "drive_RF", Motor.GoBILDA.RPM_312);
        Motor lr = new Motor(hwMap, "drive_LR", Motor.GoBILDA.RPM_312);
        Motor rr = new Motor(hwMap, "drive_RR", Motor.GoBILDA.RPM_312);

        lf.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        lr.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rr.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);


        drive = new MecanumDrive(lf, rf, lr, rr);

        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled      = false;
//        parameters.

        imu2 = hwMap.get(BNO055IMU.class, "imu2");
        imu2.initialize(parameters);
//        imu2.resetYaw();

//        imu = hwMap.get(BHI260IMU.class, "imu");
//        imu.initialize(new IMU.Parameters(orientationOnRobot));

//        imu.resetYaw();

    }

    public static void executeTeleop(){
//        drive.driveFieldCentric(
//                driver.right_stick_x,
//                -driver.left_stick_y,
//                driver.left_trigger > .2 ? driver.left_trigger : -driver.right_trigger,
//                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),   // gyro value passed in here must be in degrees
//                false
//        );
        Robot.curOpMode.telemetry.addData("offset", Math.toDegrees(Robot.endAngle));



        Orientation thing = new Orientation(imu2.getAngularOrientation().axesReference,
                imu2.getAngularOrientation().axesOrder,
                imu2.getAngularOrientation().angleUnit,
                (float)(imu2.getAngularOrientation().firstAngle - Math.toDegrees(Robot.endAngle)),
                imu2.getAngularOrientation().secondAngle,
                imu2.getAngularOrientation().thirdAngle,
                imu2.getAngularOrientation().acquisitionTime);

        double yaw = thing.firstAngle;

        double realYaw = yaw < 0 ? 360 + yaw : yaw;

        PIDController controller = new PIDController(.015,.0015,0);

        double xVal;
        double yVal;
        double turnVal;

        if(!(driver.left_trigger > .2)){
            xVal =driver.left_stick_x * .25;
            yVal = -driver.left_stick_y * .25;
            turnVal = -driver.right_stick_x * .25;
        } else {
            xVal =driver.left_stick_x * .75;
            yVal = -driver.left_stick_y * .75;
            turnVal = -driver.right_stick_x * .75;
        }

        if(Math.abs(xVal) > .1 || Math.abs(yVal) > .1 || Math.abs(xVal) > .1 || Math.abs(turnVal) > .1){
            if(yaw > -45 && yaw < 45) {
                drive.driveFieldCentric(
                        xVal,
                        yVal,
                        Math.abs(turnVal) > .1 ? turnVal : -controller.calculate(0, yaw),
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            } else if(yaw > 45 && yaw < 135){
                drive.driveFieldCentric(
                        xVal,
                        yVal,
                        Math.abs(turnVal) > .1 ? turnVal : -controller.calculate(90, yaw),
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            } else if(realYaw > 135 && realYaw < 225){
                drive.driveFieldCentric(
                        xVal,
                        yVal,
                        Math.abs(turnVal) > .1 ? turnVal : -controller.calculate(180, realYaw),
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            } else if(yaw > -135 && yaw < -45){
                drive.driveFieldCentric(
                        xVal,
                        yVal,
                        Math.abs(turnVal) > .1 ? turnVal : -controller.calculate(-90, yaw),
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            } else {
                drive.driveFieldCentric(
                        xVal,
                        yVal,
                        turnVal,
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            }
        } else {
            if(driver.dpad_down){
                drive.driveRobotCentric(0,0,
                        -controller.calculate(180, realYaw));
            } else if (driver.dpad_right){
                drive.driveRobotCentric(0,0,
                        -controller.calculate(-90, yaw));
            } else if (driver.dpad_up){
                drive.driveRobotCentric(0,0,
                        -controller.calculate(0, yaw));
            } else if (driver.dpad_left){
                drive.driveRobotCentric(0,0,
                        -controller.calculate(90, yaw));
            } else {
                drive.driveFieldCentric(
                        0,
                        0,
                        0,
                        yaw,//imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES),
                        false
                );
            }
        }


        if(driver.back){
            Robot.endAngle = 0;
//            imu.resetYaw();
            imu2.initialize(parameters);
        }

        Robot.curOpMode.telemetry.addData("yaw", imu2.getAngularOrientation().firstAngle);
        Robot.curOpMode.telemetry.addData("Calibration", imu2.isGyroCalibrated());
        Robot.curOpMode.telemetry.addData("yaw", realYaw);
        Robot.curOpMode.telemetry.update();

    }

}