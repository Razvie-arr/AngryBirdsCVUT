package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import java.util.List;

import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsCannon extends GameObject {

    protected IShootingMode shootingMode;
    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode( );
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode( );
    protected static IShootingMode DYNAMIC_SHOOTING_MODE = new DynamicShootingMode();
    protected int missileCounter;

    public abstract void moveUp( );
    public abstract void moveDown( );
    public abstract void aimUp( );
    public abstract void aimDown( );
    public abstract void powerUp( );
    public abstract void powerDown( );
    public abstract void backToInitialAngle( );
    public abstract double getAngle();
    public abstract int getPower();
    public abstract void setAngle(double angle);
    public abstract IShootingMode getShootingMode();
    public abstract void setShootingMode(IShootingMode mode);
    public abstract List<AbsMissile> shoot( );
    public abstract void primitiveShoot( );
    public abstract List<AbsMissile> ultraRageShoot();


    @Override
    public void acceptVisitor( IVisitor visitor ) {
        visitor.visitCannon( this );
    }

    abstract public void incrementMissileCounter();

    abstract public void decrementMissileCounter();

    abstract public int getMissileCounter();

    abstract public void setMissileCounter(int missileCounter);

    public void toggleShootingMode( ) {
        if( this.shootingMode instanceof SingleShootingMode ){
            this.shootingMode = DOUBLE_SHOOTING_MODE;
        }
        else if( this.shootingMode instanceof DoubleShootingMode ){
            this.shootingMode = DYNAMIC_SHOOTING_MODE;
        }
        else {
            this.shootingMode = SINGLE_SHOOTING_MODE;
        }
    }
    
}
