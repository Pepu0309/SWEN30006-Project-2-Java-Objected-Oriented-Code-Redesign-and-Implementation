package oh_heaven.game;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.Random;

public class NPC extends Player{
    // Place this temporarily here for testing.
    static public final int seed = 30006;
    static final Random random = new Random(seed);

    public NPCStrategy strategy;

    public NPC(int playerNumber) {
        super(playerNumber);
    }

    public NPC(int playerNumber, String NPCStrategyName) throws Exception {
        super(playerNumber);
        try {
            strategy = NPCStrategyFactory.getInstance().createStrategy(NPCStrategyName);
            if(strategy == null) {
                throw new Exception("Invalid strategy");
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }

    }

    public static Card randomCard(Hand hand){
        int x = random.nextInt(hand.getNumberOfCards());
        return hand.get(x);
    }

    public Card playMove() {
        // selected = strategy.determineMove(Hand hand);
        selected = randomCard(super.getPlayerHand());
        return selected;
    }
}
