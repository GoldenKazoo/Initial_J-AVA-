public class Coordonnee {
    private int x,y;
    private boolean virage;
    private int id;

    public Coordonnee(int x, int y, boolean v, int id){
        this.x = x;
        this.y = y;
        this.virage = v;
        this.id = id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getVirage(){
        return this.virage;
    }

    public int getId() {
        return id;
    }
}