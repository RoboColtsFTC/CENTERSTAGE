package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Robot.driver;
import static org.firstinspires.ftc.teamcode.Robot.hwMap;

import com.qualcomm.robotcore.hardware.CRServo;

public class Climber {

    public static CRServo leftSide = null;
    public static CRServo rightSide = null;

    public static void initClimber(){
        leftSide = hwMap.get(CRServo.class, "leftSide");
        rightSide = hwMap.get(CRServo.class, "rightSide");

        leftSide.setPower(0);
        rightSide.setPower(0);
    }

    public static void executeClimberTeleop(){
        if(driver.left_bumper && driver.right_bumper){
            leftSide.setPower(-.0675);
            rightSide.setPower(.0875);
        } else if(driver.left_bumper){
            leftSide.setPower(.5);
            rightSide.setPower(-.5);
        } else if(driver.right_bumper){
            leftSide.setPower(-.5);
            rightSide.setPower(.5);
        } else {
            leftSide.setPower(0);
            rightSide.setPower(0);
        }
    }

}
