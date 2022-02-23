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
		colorMode(HSB, 255, 255, 255);
		noStroke();
		background(255);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	float segments = 10;
	int circles = 10;
	int offset = 0;
	int boxes = 10;

	public void draw()
	{
		/*PART ONE
		for(int i = 0; i < segments; i ++){
			fill(i*(255/segments), 255, 255);
			rect(i*(width/segments), 0, width/segments, height);
		}
		*/

		/*PART TWO
		for(int i = 0; i < segments; i++){
			fill(i*(255/segments), 255, 255);
			rect(i*(width/segments), i*(height/segments), width/segments, height/segments);
		}
		*/

		/*PART THREE
		for(int i = 0; i < segments; i++){
			fill(i*(255/segments), 255, 255);
			rect(i*(width/segments), i*(height/segments), width/segments, height/segments);
			fill(i*(255/segments), 255, 255);
			//((segments - 1) - i) is like the inverse of i for this situation
			rect(((segments - 1) - i) * (width/segments), i*(height/segments), width/segments, height/segments);
			
		}
		*/

		/*PART FOUR
		for(int i = circles; i > 0; i--){
			fill(i * (255/circles), 255, 255);
			ellipse(width/2, height/2, i * ((width/circles)), i * ((width/circles)));
		}
		*/

		/*PART FIVE
		ellipseMode(CORNER);
		for(int i = 0; i < segments; i++){
			for(int j = 0; j < segments; j++){
				fill((255/segments) * ((i + j)/2), 255, 255);
				ellipse(i*(width/segments), j*(height/segments), width/segments, height/segments);
			}
		}
		*/

		/*
		//COOL VERSION
		offset += (mouseX / 100);
        float w = width / segments;
        float cgap = 255 / (segments * 2);
        for(int i = 0; i < segments; i++){
        	for(int j = 0; j < segments; j++){
				//increments hue within the boundry of 255
				//using the mouse location to effect the speed at which it happens
        		float c = ((cgap * (i + j)) + offset) % 255; 
        		fill(c, 255, 255);
        		ellipse((w / 2) + w * j, (w / 2) + w * i, w, w);
        	}
        }
		*/

		for(int i = 0; i < boxes * boxes; i++){
			stroke(map(120, 0, 360, 0, 255), 255, 255);
			fill(0);
			rect((width/boxes) * (i%boxes), (height/boxes) * (i/boxes), width/boxes, height/boxes);

		}

	}
}

/*ATTEMPT AT THE CODE FROM THE VIDEO
int segs = 4;
int segWidth = 125;
int recX;
//draw
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

switch(mode)	
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