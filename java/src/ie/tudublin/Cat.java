package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;

    public int getLives(){
        return numLives;
    }

    public void setLives(int num){
        numLives = num;
    }

    public Cat(String name)
    {
        super(name); //this uses the constructor from the Animal class to initialize the name attribute of a Cat object
    }

    public String kill(){
        if(this.numLives > 0){
            numLives--;
            System.out.println("Ouch!");
            return "";
        }else{
            System.out.println("Dead");
            return "dead";
        }
    }
}