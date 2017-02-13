/**
 * This class provides a convenient way to test shuffling methods.
 */
import java.util.Arrays;
import java.util.Random;

public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 7;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive realistic shuffles:");
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            realisticShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param va    lues is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int b=0;
        int[] arrayCopy1 = new int[values.length/2];
        int[] arrayCopy2 = new int[values.length/2];
        arrayCopy1 = Arrays.copyOfRange(values, 0, values.length/2);
        arrayCopy2 = Arrays.copyOfRange(values, values.length/2 ,values.length);
        for(int i=0; b <= arrayCopy1.length-1; i++) {
           values[i] = arrayCopy1[b];
           i++;
           values[i] = arrayCopy2[b];
           b++;
        }

    }
    public static void realisticShuffle(int[] values) {
        Random ran = new Random();
        int merge = 0;
        int random = (int)(ran.nextGaussian() * values.length/2 + 2);    
        if (random > 20 || random < -20) {
            random = 0;
        }
        int[] arrayCopy1;
        int[] arrayCopy2;
        arrayCopy1 = Arrays.copyOfRange(values, 0, values.length/2 + random);
        arrayCopy2 = Arrays.copyOfRange(values, values.length/2 + random, values.length);
        int sizeOne=arrayCopy1.length;
        int sizeTwo=arrayCopy2.length;
        int i=0;
        int chance=1;
        while (sizeOne > 0 || sizeTwo > 0) {
            if (sizeTwo==sizeOne && sizeTwo==0){break;}
            if (sizeOne == 0) {chance=0;}
            if (sizeTwo == 0) {chance=100;}
            merge = ran.nextInt(2);
            if (merge < chance){
                values[i] = arrayCopy1[arrayCopy1.length - sizeOne];
                sizeOne--;
            }
            else{ 
                values[i] = arrayCopy2[arrayCopy2.length - sizeTwo];
                sizeTwo--;
            }
            i++;
        }
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        int tmp =0;
        int r = 0;
        Random ran = new Random();
        for (int k=51; k>0; k-- ){
            r = ran.nextInt(k+1);
            tmp = values[k];
            values[k]=values[r];
            values[r] = tmp;
        }
    }
}
