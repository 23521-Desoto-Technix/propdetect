package org.firstinspires.ftc.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.processors.FirstPipelineRevised;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name="Vision Test")
public class CameraTest extends LinearOpMode {
    private FirstPipelineRevised firstPipelineRevised; //Create an object of the VisionProcessor Class
    private VisionPortal portal;
    
    @Override
    public void runOpMode() throws InterruptedException {
        firstPipelineRevised = new FirstPipelineRevised();
        portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(firstPipelineRevised)
                .build();
        

        waitForStart();
	while (opModeIsActive()) {
		telemetry.addLine(String.valueOf(firstPipelineRevised.getSelection()));
		telemetry.update();
	}



    }
}
