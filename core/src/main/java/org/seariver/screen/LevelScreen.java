package org.seariver.screen;

import org.seariver.BaseActor;
import org.seariver.BaseScreen;
import org.seariver.actor.Card;
import org.seariver.actor.Pile;

import java.util.ArrayList;

import static com.badlogic.gdx.math.MathUtils.random;

public class LevelScreen extends BaseScreen {

    private ArrayList<Pile> pileList;

    public void initialize() {

        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("felt.jpg");
        BaseActor.setWorldBounds(background);

        pileList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int pileX = 120 + 150 * i;
            int pileY = 450;
            Pile pile = new Pile(pileX, pileY, mainStage);
            pileList.add(pile);
        }

        for (int rank = 0; rank < Card.rankNames.length; rank++) {
            for (int suite = 0; suite < Card.suitNames.length; suite++) {
                int x = random(0, 800);
                int y = random(0, 300);
                Card card = new Card(x, y, mainStage);
                card.setRankSuitValues(rank, suite);
                card.toBack();
            }
        }

        for (BaseActor actor : BaseActor.getList(mainStage, "org.seariver.actor.Card")) {
            Card card = (Card) actor;
            if (card.getRankValue() == 0) {
                Pile pile = pileList.get(card.getSuitValue());
                card.toFront();
                card.moveToActor(pile);
                pile.addCard(card);
                card.setDraggable(false);
            }
        }

        background.toBack();
    }

    public void update(float deltaTime) {
    }
}
