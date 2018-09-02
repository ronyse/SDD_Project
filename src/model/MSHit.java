/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Main;

/**
 *
 * @author alexmullis
 */
public class MSHit implements MSState {
    public MSHit() {
       
    
        
       
   
    
   
	}

    @Override
	public void goNext(MotherShip context) {
        if(Main.animator.bossCounter >= 250){
            context.setState(new MSDone());
        }
	}

    @Override
    public int theState() {
        return 2;
    }
    
        
       
        
    }
