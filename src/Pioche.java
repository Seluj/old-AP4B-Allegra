import java.util.Arrays;
import java.util.Random;

public class Pioche {

    private static final int total = 120;


    private final Carte[] cartes = new Carte[total];

    private int index = 0;

    /**
     * Default constructor create draw pile with random card
     */
    public Pioche()
    {
        Random rand = new Random();
        int randInt, i = index;
        while (i < total) {
            randInt = rand.nextInt(-1, 12);
            if (check_carte(randInt, i)) {
                Carte toInsert = new Carte(randInt);
                cartes[i] = toInsert;
                i++;
            }
        }
    }

    public Carte piocher_carte()
    {
        Carte returned = cartes[index];
        index++;
        return returned;
    }

    /**
     * Check if there are enought card of the card passed by parameter
     * @param carte the card to check
     * @param fin
     * @return true if the card can be inserted and false if not
     */
    private boolean check_carte(int carte, int fin) {
        int nb = nb_carte(carte, fin);
        switch (carte) {
            case -1, 0, 1, 2, 3 -> {
                if (nb >= 8)
                    return false;
            }
            case 4, 5, 6, 7 -> {
                if (nb >= 11)
                    return false;
            }
            case 8, 9, 10, 11 -> {
                if (nb >= 9)
                    return false;
            }
        }
        return true;
    }


    /**
     * Return the number the card in parameter in the draw pile
     * @param carte card to check into the draw pile
     * @param fin
     * @return the number of card
     */
    private int nb_carte(int carte, int fin) {
        int nb = 0;
        for (int i = index; i < fin; i++) {
            if (carte == cartes[i].getCredits())
                nb++;
        }
        return nb;
    }

    /**
     * Print card in draw pile
     * @param entier if true, print all card if not, print all card remaining
     */
    public void printCartes(boolean entier) {
        if (entier) {
            System.out.print(this);
        } else {
            StringBuilder str = new StringBuilder();
            str.append('[');
            for (int i = index; i < total; i++) {
                str.append(cartes[i]);
                if ((i+1) != total)
                    str.append(" ,");
            }
            str.append(']');
            System.out.print(str);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return Arrays.toString(cartes);
    }
}