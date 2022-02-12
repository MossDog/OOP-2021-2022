package ie.tudublin;

import javax.swing.SwingWorker;

import com.jogamp.opengl.util.awt.AWTGLPixelBuffer.SingleAWTGLPixelBufferProvider;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		noStroke();
		background(0);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	int segs = 4;
	int segWidth = 125;
	int recX;
	
	public void draw()
	{
		background(0);
		int xpos = mouseX;
		for(int i = 0; i < segs; i++){

			if(xpos > i*segWidth && xpos < (i+1)*segWidth){
				recX = i*segWidth;
			}

		}
		//THINGS LEFT TO DO WITH THIS PART | FIGURE OUT DIVISION PROBLEM, FIGURE OUT COLORING PROBLEM, PUT INSIDE SWITCH STATEMENT.
		fill(240, 100, 100);
		rect(recX, 0, 125, height);
	
		/* switch(mode)	
		{
			case 0:
				for(int i = 0; i < 4; i++){

					if(xpos > i*(width/4) && xpos < i+1*(width/4)){
						stroke(0, 0, 255);
					}
					else{
						stroke(0, 0, 0);
					}
					rect(i*(width/4), 0, width/4, height);

				}
				break;
			case 1:
				break;
		} */

	}
}
