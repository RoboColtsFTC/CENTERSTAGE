package org.firstinspires.ftc.teamcode.vision;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;

public class Camera {

    public enum SkystonePosition {
        LEFT,
        CENTER,
        RIGHT
    }

    OpenCvCamera phoneCam;
    SkystoneDeterminationPipeline pipeline;

    public static boolean red;

    public Camera(LinearOpMode opMode, boolean red){
        this.red = red;

        int cameraMonitorViewId = opMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", opMode.hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(opMode.hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        pipeline = new SkystoneDeterminationPipeline();
        phoneCam.setPipeline(pipeline);


        phoneCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                phoneCam.startStreaming(320,240, OpenCvCameraRotation.SENSOR_NATIVE);
            }
            @Override
            public void onError(int errorCode) {}
        });
    }

    public void closeCamera(){
        phoneCam.closeCameraDevice();
        phoneCam.closeCameraDeviceAsync(new OpenCvCamera.AsyncCameraCloseListener() {
            @Override
            public void onClose() {}
        });
    }

    public int getResult(){
        if(pipeline.getAnalysis() == SkystonePosition.LEFT){
            return 0;
        } else if (pipeline.getAnalysis() == SkystonePosition.CENTER){
            return 1;
        } else if (pipeline.getAnalysis() == SkystonePosition.RIGHT){
            return 2;
        } else {
            return -1;
        }
    }

    public static class SkystoneDeterminationPipeline extends OpenCvPipeline {


        static final Scalar BLUE = new Scalar(0, 0, 255);
        static final Scalar GREEN = new Scalar(0, 255, 0);

        static final int REGION_WIDTH = 50;
        static final int REGION_HEIGHT = 50;
        static final Point REGION1_TOPLEFT_ANCHOR_POINT = new Point(25,100);
        static final Point REGION2_TOPLEFT_ANCHOR_POINT = new Point(125+12,100);
        static final Point REGION3_TOPLEFT_ANCHOR_POINT = new Point(250,100);

        Point region1_pointA = new Point(
                REGION1_TOPLEFT_ANCHOR_POINT.x,
                REGION1_TOPLEFT_ANCHOR_POINT.y);
        Point region1_pointB = new Point(
                REGION1_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
                REGION1_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
        Point region2_pointA = new Point(
                REGION2_TOPLEFT_ANCHOR_POINT.x,
                REGION2_TOPLEFT_ANCHOR_POINT.y);
        Point region2_pointB = new Point(
                REGION2_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
                REGION2_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
        Point region3_pointA = new Point(
                REGION3_TOPLEFT_ANCHOR_POINT.x,
                REGION3_TOPLEFT_ANCHOR_POINT.y);
        Point region3_pointB = new Point(
                REGION3_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
                REGION3_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);

        Mat region1R, region2R, region3R;
        Mat region1G, region2G, region3G;
        Mat region1B, region2B, region3B;

        Mat RGB = new Mat();
        Mat R = new Mat();
        Mat G = new Mat();
        Mat B = new Mat();

        public int avg1R, avg2R, avg3R;
        public int avg1G, avg2G, avg3G;
        public int avg1B, avg2B, avg3B;
        private volatile SkystonePosition position = SkystonePosition.LEFT;

        void inputToRGB(Mat input) {
            Imgproc.cvtColor(input, RGB, Imgproc.COLOR_RGB2BGR);

            Core.extractChannel(RGB, R, 2);
            Core.extractChannel(RGB, G, 1);
            Core.extractChannel(RGB, B, 0);
        }

        @Override
        public void init(Mat firstFrame) {
            inputToRGB(firstFrame);

            region1R = R.submat(new Rect(region1_pointA, region1_pointB));
            region2R = R.submat(new Rect(region2_pointA, region2_pointB));
            region3R = R.submat(new Rect(region3_pointA, region3_pointB));

            region1G = G.submat(new Rect(region1_pointA, region1_pointB));
            region2G = G.submat(new Rect(region2_pointA, region2_pointB));
            region3G = G.submat(new Rect(region3_pointA, region3_pointB));

            region1B = B.submat(new Rect(region1_pointA, region1_pointB));
            region2B = B.submat(new Rect(region2_pointA, region2_pointB));
            region3B = B.submat(new Rect(region3_pointA, region3_pointB));
        }

        @Override
        public Mat processFrame(Mat input) {
            inputToRGB(input);

            avg1R = (int) Core.mean(region1R).val[0];
            avg2R = (int) Core.mean(region2R).val[0];
            avg3R = (int) Core.mean(region3R).val[0];

            avg1G = (int) Core.mean(region1G).val[0];
            avg2G = (int) Core.mean(region2G).val[0];
            avg3G = (int) Core.mean(region3G).val[0];

            avg1B = (int) Core.mean(region1B).val[0];
            avg2B = (int) Core.mean(region2B).val[0];
            avg3B = (int) Core.mean(region3B).val[0];

            Imgproc.rectangle(input, region1_pointA, region1_pointB, BLUE, 2);

            Imgproc.rectangle(input, region2_pointA, region2_pointB, BLUE, 2);

            Imgproc.rectangle(input, region3_pointA, region3_pointB, BLUE, 2);

            int minR1 = Math.min(avg1R, avg2R);
            int minR = Math.min(minR1, avg3R);

            int minB1 = Math.min(avg1B, avg2B);
            int minB = Math.min(minB1, avg3B);

            if(red ? minB == avg1B : minR == avg1R) {
                position = SkystonePosition.LEFT;

                Imgproc.rectangle(input, region1_pointA, region1_pointB, GREEN, -1);
            }
            else if(red ? minB == avg2B : minR == avg2R) {
                position = SkystonePosition.CENTER;

                Imgproc.rectangle(input, region2_pointA, region2_pointB, GREEN, -1);
            }
            else if(red ? minB == avg3B : minR == avg3R){
                position = SkystonePosition.RIGHT;

                Imgproc.rectangle(input, region3_pointA, region3_pointB, GREEN, -1);
            }

            return input;
        }

        public SkystonePosition getAnalysis() {
            return position;
        }
    }
}
