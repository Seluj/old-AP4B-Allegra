public class Carte {
    private int credits;

    public Carte() {
        this.credits = -2;
    }
    public Carte(int nb) {
        this.credits = nb;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "" + credits;
    }
}
