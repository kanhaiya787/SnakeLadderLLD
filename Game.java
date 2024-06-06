import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Deque<Player> players;
    Board board;
    Dice dice;
    int n;
    Game(){
        players = new LinkedList<>();
        n=10; //size of board
        initialize();
    }

    public void initialize(){
        Player p1 = new Player(1,0,"KK");
        Player p2 = new Player(2,0,"Ayu");

        players.add(p1);
        players.add(p2);

        int numberOfLadder = 2;
        int numberOfSnakes = 2;
        dice = new Dice();
        board = new Board(n,numberOfLadder,numberOfSnakes);
    }


    public void startGame(){
        Player winner = null;

        while(true){
            Player p = players.pollFirst();
            System.out.println("Player "+p.getName()+" is rolling the dice!");
            int newPos = p.getPosition() + dice.getValue();

            int jump = checkJump(newPos);
            if(jump!=-1){
                newPos=jump;
            }
            if(newPos>=(n*n)-1) {
                winner = p;
                break;
            }
            System.out.println("Position for player "+p.getName()+" is changed from: "+p.getPosition()+" to: "+newPos);
            p.setPosition(newPos);
            players.addLast(p);
        }

        System.out.println("Winner of game is "+winner.getName());

    }

    public int checkJump(int newPos){
        if(newPos>=(n*n)-1)
            return -1;

        int[] arr = board.getRowCell(newPos);
        int dest = board.getJump(arr[0],arr[1]);

        return dest;
    }
}
