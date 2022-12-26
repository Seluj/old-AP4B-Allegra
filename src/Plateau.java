
public class Plateau {

    private final static int X = 3;
    private final static int Y = 4;

    private final Carte[][] cartes = new Carte[X][Y];
    private final boolean[][] cache = new boolean[X][Y];

    public Plateau() {
        for (Carte[] c : cartes) {
            for (Carte c1 : c) {
                c1 = new Carte();
            }
        }
        for (boolean[] b : cache) {
            for (boolean b1 : b) {
                b1 = false;
            }
        }
    }

    public Plateau(Pioche p) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                cartes[i][j] = p.piocher_carte();
            }
        }
    }

    public void retourner(int x, int y) {
        if (!this.isRetourner(x, y)) {
            cache[x][y] = true;
        }
    }


    /**
     * EXEPTION A GERER !!!!!!!!!
     * @param x
     * @param y
     * @return
     */
    private boolean isRetourner(int x, int y) {
        return cache[x][y];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (isRetourner(i, j))
                    str.append(" ").append(cartes[i][j]).append(" ");
                else
                    str.append(" - ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}