
public class Plateau implements Base {

    private final Carte[][] cartes = new Carte[X][Y];
    private final int[][] cache = new int[X][Y]; // 0 -> hidden / 1 -> revealed / 2 -> no card

    public Plateau() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                cartes[i][j] = new Carte();
                cache[i][j] = 0;
            }
        }
    }

    public Plateau(Pioche p) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                cartes[i][j] = p.piocher_carte();
                cache[i][j] = 0;
            }
        }
    }

    /**
     * Function used to reveal card [if said card hasn't been revealed or removed yet
     * @param x
     * @param y
     */
    public void retourner(int x, int y) {
        if (!this.isRetourner(x, y)) {
            cache[x][y] = 1;
        }
    }


    /**
     * EXEPTION A GERER !!!!!!!!!
     * @param x
     * @param y
     * @return
     */
    private boolean isRetourner(int x, int y) {
        return cache[x][y] == 1 || cache[x][y] == 2;
    }

    /**
     * Function used to determine wether all the player's cards have been revealed or not
     * @return a boolean 0 -> if they're not all revealed // 1 -> if they are all revealed
     */
    public boolean allRetourner(){
        int i = 0, j = 0;
        boolean notTurned = false;
        while (i < X && !notTurned) {
            i++;
            while (j < Y && !notTurned){
                if (cache[i][j] == 0){
                    notTurned = true;
                }
                j++;
            }
            j = 0;
        }
        return notTurned;
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