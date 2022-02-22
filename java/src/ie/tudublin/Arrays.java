package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet{

    float[] rainfall = {1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9, 10};

    String[] months = {"JAN", "FEB", "MARCH", "APRIL", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float a1[] = new float[100];
    float a2[];

    public void settings(){
        size(500, 500);
    }

    public void setup(){

        for(int i = 0; i < rainfall.length; i++){
            println(rainfall[i] + "\t" + months[i]);
        }

        //enhanced for loop
        for(float r: rainfall){
            println(r);
        }

        float min, max;
        for(int i = rainfall.length-1; i >= 0; i--){
            println(rainfall[i] + "\t" + months[i]);
            min = Float.MAX_VALUE;
            max = Float.MIN_VALUE;

            if(min < rainfall[i]){
                min = rainfall[i];
            }
            if(max > rainfall[i]){
                max = rainfall[i];
            }
            if(i == 0){
                println("min: " + min + "\tmax: " + max);
            }

        }
    
        for(i = 0; i < rainfall.length; i++){
            rect(i, rainfall[i], c, d);
        }

    }

}
