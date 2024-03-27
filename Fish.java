public class Fish{
//  Private Variables
    private boolean isExist;
    private boolean isBorder;
    private static int amtOfFish;
    private int mapDigit;

//  Default Constructor
    public Fish(){
        isExist = false;
        isBorder = false;
        mapDigit = 0;
    }

//  Specified Constructor
    public Fish(String x){
        if(x.equals("border"))
        {
            isBorder = true;
            isExist = false;
            mapDigit = 1;
        }
        else if(x.equals("fish"))
        {
            isExist = true;
            isBorder = false;
            amtOfFish++;
            mapDigit = 0;
        }
    }

//Mutator: 
//  Turns an Unchecked Index From 0 to 2
    public void checked(){
        mapDigit = 2;
    }
//Returners:
    public int getCord(){
        return mapDigit;
    }

    public boolean getExist(){
        return isExist;
    }

    public boolean getBorder(){
        return isBorder;
    }
}