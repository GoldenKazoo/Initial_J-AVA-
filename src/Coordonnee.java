public class Coordonnee {
    private int x,y;
    private boolean virage;

    public Coordonnee(int x, int y, boolean v){
        this.x = x;
        this.y = y;
        this.virage = v;
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
}