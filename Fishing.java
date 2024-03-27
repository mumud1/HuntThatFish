public class Fishing{
//  Private Variables 
    private static boolean rod = true;
    private static boolean net = false;
    private static int coins = 0;//Rememeber to change back to 10, nvm change it to 0 later.
    private static int moves = 0;
    
//Mutators:
//  Adds Coins
    public static void addCoins(int x){
        coins += x;
    }

//Returners:
//  Returns Coins
    public int getCoins(){
        return coins;
    }
//  Returns if Rod is Equipped or Not
    public boolean rodEQ(){
        return rod;
    }
//  Returns if Net is Equipped or Not
    public boolean netEQ(){
        return net;
    }

//Game Methods:

//  Searches at a Requested Coordinates and Checks if Fish is Caught
    public static void fish(Map map, int x, int y){
        if(rod){
            if(map.getMap()[y][x].getExist())
            {
                moves++;
                map.caughtFish();
                System.out.println("YOU CAUGHT THE FISH!");
            }
            else if(map.getMap()[y][x].getBorder())
            {
                moves++;
                coins -= 5;
                System.out.println("You can't fish the border... fined 5 coins...");
            }
            else
            {
                int ogCoins = coins;
                coins += (int)(Math.random()*4)+1;
                moves++;
                map.getMap()[y][x].checked();
                System.out.println("You didn't catch anything... Coins earned: " + (coins - ogCoins));
            }
        }
        else if(net){
            boolean caught = false;
            boolean inBorder = false;
            for(int a = y - 1 ; a < y + 2 ; a++)
            {
                inBorder = false;
                for(int b = x - 1 ; b < x + 2 ; b++)
                {
                    if(map.getMap()[a][b].getBorder())
                    {
                        moves++;
                        coins -= 10;
                        System.out.println("You can't fish the border... fined 10 coins for using net...");
                        inBorder = true;
                        break;
                    }
                }
                if(inBorder)
                {
                    break;
                }
            }
            if(!inBorder)
            {
                for(int i = y - 1 ; i < y + 2 ; i++)
                {
                    caught = false;
                    for(int j = x - 1 ; j < x + 2 ; j++)
                    {
                        if(map.getMap()[i][j].getExist())
                        {
                            moves++;
                            map.caughtFish();
                            System.out.println("YOU CAUGHT THE FISH!");
                            caught = true;
                            break;
                        }
                    }
                    if(caught)
                    {
                        break;
                    }
                }
            }
            if(!inBorder && !caught)
            {
                for(int r = y - 1 ; r < y + 2 ; r++)
                {
                    for(int c = x - 1 ; c < x + 2 ; c++)
                    {
                       map.getMap()[r][c].checked(); 
                    }
                }
                moves++;
                int ogCoins = coins;
                coins += (int) (Math.random()*5)+5;
                System.out.println("You didn't catch anything... Coins earned: " + (coins - ogCoins));
            }
            
        }
        else{
            System.out.println("You somehow don't have a rod or a net??");
        }

        
    }

//  Requests for Net Purchase and Equips Net if Able to
    public static void requestNet(){
        if(coins >= 200)
        {
            rod = false;
            net = true;
            coins -= 200;
            moves++;
            System.out.println("You purchased the Net! Now your fishing window is 3x3! (Permanently Equipped) " + coins + " coins remains... ");
        }
        else
        {
            System.out.println("You are " + (200 - coins) + " short from buying the net");
        }
    }

    public static void requestBait(Map map, int x, int y){
        if(coins >= 50)
        {
            moves++;
            coins -= 50;
            if(x == map.getFishX() && y == map.getFishY())
            {
                coins += 50;
                System.out.println("Something's weird...");
            }
            if(y < map.getFishY())
            {
                map.setFishY(map.getFishY() - (int) (Math.random()*(map.getFishY() - y - 1) + 1));
            }
            else if(y > map.getFishY())
            {
                map.setFishY(map.getFishY() + Math.abs((int) (Math.random()*(map.getFishY() - y - 1) + 1)));
            }
            if(x < map.getFishX())
            {
                map.setFishX(map.getFishX() - (int) (Math.random()*(map.getFishX() - x - 1) + 1));
            }
            else if(x > map.getFishX())
            {
                map.setFishX(map.getFishX() + Math.abs((int) (Math.random()*(map.getFishX() - x - 1) + 1)));
            }
            System.out.println("Bait dropped... The fish moves closer... " + coins + " coins remains...");
        }
        else
        {
            System.out.println("You are " + (50 - coins) + " short from buy the bait");
        }
    }

    public static void printStat(){
        System.out.println("You have " + coins + " coins total... and you have made " + moves + " moves in total...");
    }

    public static void printWins(){
        System.out.println("And to do that... ");
        for(int i = 0 ; i < 31 ; i++)
        {
            System.out.println("............................................................................");
        }
        if(rod)
        {
            System.out.println("You did it with just a rod! And...");
        }
        else if(net)
        {
            System.out.println("You did it easier with a net! And...");
        }
        for(int j = 0 ; j < 31 ; j++)
        {
            System.out.println("............................................................................");
        }
        System.out.println("You made " + moves + " moves in total to catch it and still have " + coins + " coins remaining! And on average, you make " + calAvg() + " coins per move!");
    }

    public static double calAvg(){
        return (double) coins / moves;
    }
}