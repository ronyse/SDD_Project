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
public class BombHit implements BombState {
    public BombHit() {
       
    
        
        Bomb.isDying = 1;
    
    
   
	}

    @Override
	public void goNext(Bomb context) {
        
            context.setState(new BombDone());
            
	}

    @Override
    public int theState() {
        return 2;
    }
    
        
       
        
    }
