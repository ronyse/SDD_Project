/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alexmullis
 */
public class MSDone implements MSState {
    public int death;
    public MSDone() {
        
		
        //Main.animator.enemy.state = 0;
	}

    @Override
    public void goNext(MotherShip context) {
        //Main.animator.enemy.state = 0;
        //context.setState(null);
    }    

    @Override
    public int theState() {
        return 0;
    }

    

    }
    

