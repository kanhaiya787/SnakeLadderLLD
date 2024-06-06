import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    int numberOfLadders=0, numberOfSnakes=0;

    public Board(int n, int numberOfLadders, int numberOfSnakes){
        this.cells = new Cell[n][n];
        this.numberOfLadders = numberOfLadders;
        this.numberOfSnakes = numberOfSnakes;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cells[i][j] = new Cell();
            }
        }
        addLadder(n, numberOfLadders);
        addSnakes(n, numberOfSnakes);
    }

    public void addLadder(int n, int numberOfLadders){
        int start = 1;
        int end=99;
        while(numberOfLadders>0){
            int source = ThreadLocalRandom.current().nextInt(start, end);
            int dest = ThreadLocalRandom.current().nextInt(start, end);

            if(source>dest)
                continue;

            int[] arr = getRowCell(source);
            System.out.println(source+" "+dest);
            System.out.println("Ladder is set from "+arr[0]+" to: "+arr[1]);
            cells[arr[0]][arr[1]].jump =  new Jump(source, dest);
            numberOfLadders--;
        }
    }
    public void addSnakes(int n, int numberOfSnakes){
        int start = 1;
        int end=99;
        while(numberOfSnakes>0){
            int source = ThreadLocalRandom.current().nextInt(start, end);
            int dest = ThreadLocalRandom.current().nextInt(start, end);

            if(source<dest)
                continue;

            int[] arr = getRowCell(source);
            System.out.println(source+" "+dest);
            System.out.println("Snake is set from "+arr[0]+" to: "+arr[1]);
            cells[arr[0]][arr[1]].jump =  new Jump(source, dest);
            numberOfSnakes--;
        }
    }

    public int[] getRowCell(int source){
        int[] arr = new int[2];
        arr[0] = source/10;
        arr[1] = source%10;

        return arr;
    }

    public int getJump(int row, int col){
        if(cells[row][col].jump != null){
            System.out.println("Found a Jump!!! to: "+cells[row][col].jump.getDestination());
            return (cells[row][col].jump.getDestination());
        }

        return -1;
    }

}
