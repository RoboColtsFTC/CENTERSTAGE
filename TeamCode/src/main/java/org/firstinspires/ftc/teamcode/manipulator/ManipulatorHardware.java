package org.firstinspires.ftc.teamcode.manipulator;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.Robot.hwMap;

public class ManipulatorHardware {

    public static CRServo stage1_1 = null;
    public static CRServo stage2_1 = null;
    public static DcMotor shooter = null;
    public static CRServo output = null;
    public static CRServo stage1_2 = null;
    public static Servo input_lift = null;

    public static Servo lift = null;

    public static void initManipulatorHardware(){
        stage1_1 = hwMap.get(CRServo.class, "stage1_1");
        stage2_1 = hwMap.get(CRServo.class, "stage2_1");
        shooter = hwMap.get(DcMotor.class, "shooter");
        output = hwMap.get(CRServo.class, "output");
        stage1_2 = hwMap.get(CRServo.class, "stage1_2");
        input_lift = hwMap.get(Servo.class, "input_lift");
        lift = hwMap.get(Servo.class, "lift");
    }
}