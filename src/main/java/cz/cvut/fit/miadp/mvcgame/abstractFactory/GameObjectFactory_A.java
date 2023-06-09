package cz.cvut.fit.miadp.mvcgame.abstractFactory;

import cz.cvut.fit.miadp.mvcgame.builder.IMissileBuilder;
import cz.cvut.fit.miadp.mvcgame.builder.MissileABuilder;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsBarrier;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.family_A.*;

import java.util.ArrayList;
import java.util.List;

public class GameObjectFactory_A implements IGameObjectFactory {

    private IGameModel model;

    public GameObjectFactory_A( IGameModel model ){
        this.model = model;
    }

    @Override
    public Cannon_A createCannon() {
        return new Cannon_A( new Position( MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y ), this );
    }

    @Override
    public AbsMissile createMissile(Position cannonPosition, double initAngle, int initVelocity ) {
        IMissileBuilder builder = new MissileABuilder();
        builder.setPosition(model.getCannonPosition());
        builder.setAngle(initAngle);
        builder.setVelocity(initVelocity);
        builder.setMovingStrategy(this.model.getMovingStrategy());
        return builder.getResult();
    }

    @Override
    public GameInfo_A createGameInfo() {
        return new GameInfo_A(new Position(MvcGameConfig.GAMEINFO_POS_X, MvcGameConfig.GAMEINFO_POS_Y), model);
    }

    @Override
    public Enemy_A createEnemy() {
        return new Enemy_A(MvcGameConfig.createEnemyPosition());
    }

    @Override
    public Enemy_A createEnemy_Test() {
        return new Enemy_A(new Position(500, 360));
    }

    @Override
    public AbsBarrier createBarrier(Position enemyPosition) {
        return new Barrier_A(MvcGameConfig.createBarrierNearEnemy(enemyPosition));
    }
}
