package org.seariver.screen;

import com.badlogic.gdx.math.MathUtils;
import org.seariver.BaseActor;
import org.seariver.BaseScreen;
import org.seariver.actor.Card;

public class LevelScreen extends BaseScreen {

    public void initialize() {

        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture("felt.jpg");
        BaseActor.setWorldBounds(background);

        for (int rank = 0; rank < Card.rankNames.length; rank++) {
            for (int suite = 0; suite < Card.suitNames.length; suite++) {
                int x = MathUtils.random(0, 800);
                int y = MathUtils.random(0, 300);
                Card card = new Card(x, y, mainStage);
                card.setRankSuitValues(rank, suite);
            }
        }
    }

    public void update(float deltaTime) {
    }
}
