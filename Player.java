public class Player {
    int id;
    int position;
    String name;

    public Player(int id, int position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
