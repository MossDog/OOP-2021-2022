package ie.tudublin;

import javax.swing.SwingWorker;

import com.jogamp.opengl.util.awt.AWTGLPixelBuffer.SingleAWTGLPixelBufferProvider;

import processing.core.PApplet;
import processing.core.PFont;

public class Loops extends PApplet
{


	int mode = 0;
	PFont f;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB, 255, 255, 255);
		noStroke();
		background(255);
		f = createFont("Arial", 16, true);
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

		/*
		background(0);
		String number;
		for(int i = 0; i < boxes * boxes; i++){
			stroke(map(120, 0, 360, 0, 255), 255, 255);
			fill(0);
			rect(map((width/boxes) * (i%boxes), 0, width, 50, width - 50), map((height/boxes) * (i/boxes), 0, height, 50, height - 50), width/boxes, height/boxes);
			if((i%boxes) == 0){
				textFont(f, 16);
				textAlign(LEFT);
				number = "" + (int)map(i/boxes, 0, 9, 0 - (boxes/2), boxes/2);
				println(number);
				fill(255, 255, 255);
				text(number, 0, (height/boxes) * (i/boxes));
			}else if(i/boxes == 0){
				textFont(f, 16);
				textAlign(LEFT);
				number = "" + (int)map(i%boxes, 0, 9, 0 - (boxes/2), boxes/2);
				fill(255, 255, 255);
				text(number, (width/boxes) * (i%boxes), 0);
			}
		}
		*/

		noStroke();
		for(int i = 0; i < segments; i++){
			for(int j = 0; j < segments; j++){
				if(i % 2 == 0){
					if(j % 2 == 0){
						//light blue
						fill(map(195, 0, 360, 0, 255), 75, 240);
						rect(i * (width/segments), j * (height/segments), width/segments, height/segments);

					}else{
						//dark blue
						fill(map(227, 0, 360, 0, 255), 255, 127);
						rect(i * (width/segments), j * (height/segments), width/segments, height/segments);
					}
				}else{
					if(j % 2 == 0){
						//dark blue
						fill(map(227, 0, 360, 0, 255), 255, 127);
						rect(i * (width/segments), j * (height/segments), width/segments, height/segments);
					}else{
						//light blue
						fill(map(195, 0, 360, 0, 255), 75, 240);
						rect(i * (width/segments), j * (height/segments), width/segments, height/segments);
					}
				}
			}
		}

		switch(mode){
			case 0:
				for(int i = 0; i < segments; i++){
					fill(i*(255/segments), 255, 255);
					rect(i*(width/segments), 0, width/segments, height);
				}
				break;

			case 1:
				for(int i = 0; i < segments; i++){
					fill(i*(255/segments), 255, 255);
					rect(i*(width/segments), i*(height/segments), width/segments, height/segments);
				}
				break;

			case 2:
				for(int i = 0; i < segments; i++){
					fill(i*(255/segments), 255, 255);
					rect(i*(width/segments), i*(height/segments), width/segments, height/segments);
					fill(i*(255/segments), 255, 255);
					//((segments - 1) - i) is like the inverse of i for this situation
					rect(((segments - 1) - i) * (width/segments), i*(height/segments), width/segments, height/segments);
				}
				break;

			case 3:
				for(int i = circles; i > 0; i--){
					fill(i * (255/circles), 255, 255);
					ellipse(width/2, height/2, i * ((width/circles)), i * ((width/circles)));
				}
				break;

			case 4:
			
				break;

			case 5: 

				break;
				
		}
		
	}
}