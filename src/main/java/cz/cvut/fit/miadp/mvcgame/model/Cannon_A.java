package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class Cannon_A extends AbsCannon {

    private final IGameObjectFactory goFact;

    public Cannon_A(Position initPosition, IGameObjectFactory goFact) {
        this.position = initPosition;
        this.goFact = goFact;
    }

    @Override
    public void moveUp() {
        this.move(new Vector(0, -1 * MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown() {
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public AbsMissile shoot() {
        return this.goFact.createMissile(this.getPosition());
    }

    @Override
    public Position getPosition() {
        return position;
    }
}