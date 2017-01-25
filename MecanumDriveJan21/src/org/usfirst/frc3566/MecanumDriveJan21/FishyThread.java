package org.usfirst.frc3566.MecanumDriveJan21;


import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class FishyThread extends Thread {

	public static int FPStotal = 24, defaultStart = FPStotal/2;
	/**test this on network table and see what's the ideal distinction value
	for differentiating actual vision targets and unwanted interfering contours
	**/
	public static int VisionTargetImgProcAreaThreshold = 20000;
	//total should be smaller than 24 to make sure each cam starts at <= 12
	private int myFPS;
	private UsbCamera camera;
	private CvSink cvSink;
	private CvSource outputStream;
	private Mat mat;
	private GripPipelineJan25 pipeline;
	private final Object imgLock = new Object();
	
	
	public FishyThread(int portNumber, int startFPS) {
		// Get the UsbCamera from CameraServer
		camera = CameraServer.getInstance().startAutomaticCapture(portNumber);
		// Set the resolution
		camera.setResolution(640, 480);
		myFPS = startFPS;
		camera.setFPS(myFPS);

		
		// Get a CvSink. This will capture Mats from the camera
		cvSink = CameraServer.getInstance().getVideo();
		// Setup a CvSource. This will send images back to the Dashboard

		outputStream = CameraServer.getInstance().putVideo("HSL " + portNumber, 640, 480);

		// Mats are very memory expensive. Lets reuse this Mat.
		mat = new Mat();

		// create example of gripPipeline class
		pipeline = new GripPipelineJan25();
		
		// This cannot be 'true'. The program will never exit if it is. This
		// lets the robot stop this thread when restarting robot code or
		// deploying.

	}

	@Override
	public void run() {
		
		 while (!Thread.interrupted()) {
			// updates the fps
			camera.setFPS(myFPS);
			// Tell the CvSink to grab a frame from the camera and put it
			// in the source mat. If there is an error notify the output.
			if (cvSink.grabFrame(mat) == 0) {
				// Send the output the error.
				outputStream.notifyError(cvSink.getError());
				// skip the rest of the current iteration
				// continue;
			}
			
			pipeline.process(mat); // puts mat through pipeline

			// Give the output stream a new image to display
			//**doesn't necessarily need this in competition bc it slows down the dashboard
			outputStream.putFrame(pipeline.hslThresholdOutput());
			
			/**
			//puts rectangle around the first contour if contours are found
			 if (!pipeline.filterContoursOutput().isEmpty()) {
				 Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
			 }
			 **/
			
			 int count = 0; double max1 = 0, max2= 0 , max3 = 0; 
			 int maxNum1 = -1, maxNum2 = -1;
			 
	//the loop finds out the first, second and third biggest contours in the filtered results
			 //TODO check if in contoursOutput the contours are already sorted by size
			 for(MatOfPoint m: pipeline.filterContoursOutput()){
				double temp = Imgproc.contourArea(m);
				if(temp>=max1)
				{
					max3=max2;
					max2=max1;
					max1=temp;
					maxNum2=maxNum1;
					maxNum1=count;
				}else if(temp>=max2){
					max3=max2;
					max2=temp;
					maxNum2=count;
				}else if(temp>=max3){
					max3=temp;
				}
				count++;
			 }
			 
			 Robot.table.putValue("Max area 1", max1);
			 Robot.table.putValue("Max area 2", max2);
			 Robot.table.putValue("Max area 3", max3);
			 Robot.table.putValue("TotalContour#", count);
			 
			 if(max1 > VisionTargetImgProcAreaThreshold && 
					 max2 > VisionTargetImgProcAreaThreshold){
				 //will print out 1 and 2 if the contours are already sorted by size
				 System.out.println("maxNums "+maxNum1+" "+maxNum2);
				MatOfPoint temp1 = pipeline.filterContoursOutput().get(maxNum1);
				MatOfPoint temp2 = pipeline.filterContoursOutput().get(maxNum2);
				
				//draw bounding rects around contours
				Rect r1 = Imgproc.boundingRect(temp1);
				Rect r2 = Imgproc.boundingRect(temp2);
				
				int r1X = r1.x, r1Y=r1.y, r2X = r2.x, r2Y = r2.y, r1Width = r1.width,
						r1Height = r1.height, r2Width = r2.width, r2Height = r2.height;
				 Robot.table.putValue("1stTargetX", r1X);
				 Robot.table.putValue("1stTargetY", r1Y);
				 Robot.table.putValue("2ndTargetX", r2X);
				 Robot.table.putValue("2ndTargetX", r2Y);
				 
				 Robot.table.putValue("CalculatedXCenter", 
				(r1X>r2X)? //checks which r is at left
						//if r2 at left (r1x>r2x)
				(	(r1X>(r2X+r2Width))? //checks if the two r are touching
						(r1X+r2X+r2Width)/2: -1	) //if touching return -1
				//if r1 at left (r1x<r2x)
				: (	(r2X>(r1X+r1Width))? //checks if the two r are touching
						(r1X+r2X+r1Width)/2: -1 )			);
				 
				 
				 Robot.table.putValue("CalculatedYCenter", 
							(r1Y>r2Y)? //checks which r is at top
									//if r2 at top (r1y>r2y)
							(	(r1Y>(r2Y+r2Height))? //checks if the two r are touching
									(r1Y+r2Y+r2Height)/2: -1	) //if touching return -1
							//if r1 at top (r1y<r2y)
							: (	(r2Y>(r1Y+r1Height))? //checks if the two r are touching
									(r1Y+r2Y+r1Height)/2: -1 )			);
				 
				 
			 }else{
				 Robot.table.putValue("1stTargetX", -1);
				 Robot.table.putValue("1stTargetY", -1);
				 Robot.table.putValue("2ndTargetX", -1);
				 Robot.table.putValue("2ndTargetX", -1);
			 }
		}
}
	

	public void setCamFPSvalue(int fps) {
			myFPS = fps;
	}

}