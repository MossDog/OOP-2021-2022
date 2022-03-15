package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

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
				for(int i = 0; i < segments; i++){
					fill(i*(255/segments), 255, 255);
					rect(i*(width/segments), i*(height/segments), width/segments, height/segments);
					fill(i*(255/segments), 255, 255);
					//((segments - 1) - i) is like the inverse of i for this situation
					rect(((segments - 1) - i) * (width/segments), i*(height/segments), width/segments, height/segments);
					
				}
				break;

			case 4:
				for(int i = circles; i > 0; i--){
					fill(i * (255/circles), 255, 255);
					ellipse(width/2, height/2, i * ((width/circles)), i * ((width/circles)));
				}
				break;

			case 5: 
				ellipseMode(CORNER);
				for(int i = 0; i < segments; i++){
					for(int j = 0; j < segments; j++){
						fill((255/segments) * ((i + j)/2), 255, 255);
						ellipse(i*(width/segments), j*(height/segments), width/segments, height/segments);
					}
				}
				break;

			case 6:
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
				break;

			case 7:
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
				/*
				background(0);
				colorMode(RGB);
				float border = width * 0.1f;
				for(int i = -5; i <= 5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);
					stroke(0, 255, 0);
					line(x, border, x, height - border);
					line(border, x, width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
				*/
				break;
			
			case 8:
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
				break;

			case 9:
			/*
				background(0);
				stroke(255, 255, 255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int points = (int)map(mouseX, 1, width, 5, 20);
				int sides = points * 2;
				float px = cx;
				float py = cy - radius; 
				for(int i = 0 ; i <= sides ; i ++)
				{
					float r = (i % 2 == 0) ? radius : radius / 2; 
					// float r = radius;
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * r;
					float y = cy - cos(theta) * r;
					
					//circle(x, y, 20);
					line(px, py, x, y);
					px = x;
					py = y;
				}
				*/
				background(0);
				int npoints = (int)map(mouseX, 0, width, 0, 36);
				float angle = TWO_PI / npoints;
				float halfAngle = angle/2;
				beginShape();
				for (float a = 0; a < TWO_PI; a+=angle){
					float sx = width/2 + cos(a) * 70;//radius - 70
					float sy = height/2 + sin(a) * 70;
					vertex(sx, sy);
					sx = width/2 + cos(a + halfAngle) * 30;
					sy = height/2 + sin(a + halfAngle) * 30;
					vertex(sx, sy);
				}
				endShape(CLOSE);

				break;

			default: break;
		}
		
	}
}