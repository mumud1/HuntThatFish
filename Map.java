public class Map{
    //  Private Variables
        private Fish[][] lakeMap;
        private int fishCol;
        private int fishRow;
        private boolean fishCaughtOrNot;

    //  Constructs lakeMap, sets up Boundaries and Accesible Areas
        public Map(){
        lakeMap = new Fish[52][52];
        for(int row = 0 ; row < lakeMap.length ; row++)
        {
            for(int col = 0 ; col < lakeMap[row].length ; col++)
            {
                if(row == 0 || row == 51 || col == 0 || col == 51)
                {
                    lakeMap[row][col] = new Fish("border");
                }
                else
                {
                    lakeMap[row][col] = new Fish();
                }
            }
        }
        fishCol = (int)(Math.random()*49)+1;
        fishRow = (int)(Math.random()*49)+1;
        lakeMap[fishRow][fishCol] = new Fish("fish");
        fishCaughtOrNot = false; 
        }

        public void printMap(){
            for(Fish[] row : lakeMap)
            {
                for(Fish col : row)
                {
                    System.out.print(col.getCord());
                }
                System.out.println();
            }
        }

//Mutators:
        public void caughtFish(){
            fishCaughtOrNot = true;
        }

        public void setFishX(int x){
            lakeMap[fishRow][fishCol] = new Fish();
            fishCol = x;
            lakeMap[fishRow][fishCol] = new Fish("fish");
        }

        public void setFishY(int y){
            lakeMap[fishRow][fishCol] = new Fish();
            fishRow = y;
            lakeMap[fishRow][fishCol] = new Fish("fish");
        }

//Returners:
        public Fish[][] getMap(){
            return lakeMap;
        }

        public int getFishX(){
            return fishCol;
        }

        public int getFishY(){
            return fishRow;
        }

        public boolean isFishCaught(){
            return fishCaughtOrNot;
        }

//      Little Cheat to Reset Fish Coordinates
        public void resetFish(){
            int ogX = fishCol;
            int ogY = fishRow;
            lakeMap[fishRow][fishCol] = new Fish();
            while(fishCol == ogX || fishRow == ogY)
            {
                fishCol = (int)(Math.random()*49)+1;
                fishRow = (int)(Math.random()*49)+1;
            }
            lakeMap[fishRow][fishCol] = new Fish("fish");

        }
}

