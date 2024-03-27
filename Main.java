import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map map = new Map(); 
        while(!map.isFishCaught()){
            System.out.println("Where would you like to fish?");
            map.printMap();
            System.out.println("Please enter X and Y coordinates individually...");
            Fishing.fish(map, scan.nextInt(), scan.nextInt());
            if(!map.isFishCaught())
            {
                System.out.println("Would you like to purchase something?");
                if(scan.next().equals("yes"))
                {
                    System.out.println("We have a net and baits to aid your fishing...");
                    System.out.println("What would you like to purchase? (Please note that you can't purchase net more than twice! Don't waste your coins!)");
                    String a = scan.next();
                    if(a.equals("net"))
                    {
                        Fishing.requestNet();
                        System.out.println("You went back to fishing...");
                    }
                    if(a.equals("bait"))
                    {
                        map.printMap();
                        System.out.println("Where would you like to drop your bait? Please enter X and Y coordinates individually...");
                        Fishing.requestBait(map, scan.nextInt(), scan.nextInt());
                        System.out.println("You went back to fishing...");
                    }
                }
                else
                {
                    System.out.println("You didn't purchase anything and went back to fish...");
                }
                Fishing.printStat();
            }
        }
        Fishing.printWins();
        


        /**map.printMap();
        System.out.println(map.getFishX());
        System.out.println(map.getFishY());
        Fishing.fish(map, 2, 3);
        map.setFishX(2);
        map.setFishY(2);
        map.resetFish();
        System.out.println(map.getFishX());
        System.out.println(map.getFishY());
        Fishing.fish(map, 3, 3);
        Fishing.requestBait(map, 2, 2);
        System.out.println(map.getFishX());
        System.out.println(map.getFishY());
        Fishing.requestNet();
        Fishing.printStat();**/
    }

}
