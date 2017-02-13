import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board 
{

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
     public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        // If we have two cards selected we have a legal move
        if (selectedCards.size() == 2) 
        {
            // Legal move, check if move sums to 11
            return containsPairSum11(selectedCards);
        }
        // With three cards selected we have a legal move using JQK
        else if (selectedCards.size() == 3) 
        {
            // Legal move, check that we have a JQK selected (not something else)
            return containsJQK(selectedCards);
        }
        // Otherwise this move is not legal, let the user know
        return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() 
    {
        // Make and ArrayList to contain playable cards
        List<Integer> index = cardIndexes();
        // Check is either an 11 sum or JQK move is possible
        if (containsPairSum11(index)  && containsJQK(index)) 
        {
            // One or both of the moves are possible, a play is possible
            return true;
        }
        // Neither move is possible, we can tell the player there are no more moves
        return false;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        // We will now parse through the [two] selected cards, searching for their values
        for (int i = 0; i < selectedCards.size() - 1; i++) 
        {
            // Another loop is needed to store the value of both variables
            for (int j = i + 1; j < selectedCards.size(); j++) 
            {
                // Now to check that they sum to 11
                if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11) 
                {
                    // They do, return success to program to indicate move was legal
                    return true;
                }
            }
        }
        // The two cards do not sum to 11, this is not a valid play
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        // Initialize the three cards that we are looking for, we will look for them below
        boolean Jack = false;
        boolean Queen = false;
        boolean King = false;
        // We will now parse through the three selected cards, searching for JQK
        for (int i = 0; i < selectedCards.size(); i++) {
            if (cardAt(selectedCards.get(i)).rank() == "jack") {
                // We have found a jack, otherwise jack will stay false
                Jack = true;
            }
            else if (cardAt(selectedCards.get(i)).rank() == "queen") {
                // We have found a queen, otherwise queen will stay falsew
                Queen = true;
            }
            else if (cardAt(selectedCards.get(i)).rank() == "king") {
                // We have found a king, otherwise king will stay false
                King = true;
            }
        }
        // All three of these cards must be found, otherwise JQK is not present
        return (Jack && Queen && King);
    }
}