package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class AbsMissile extends GameObject {
    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissile(this);
    }
}
