/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class MSAlive implements MSState {
	
	public MSAlive() {
		
	}

	@Override
	public void goNext(MotherShip context) {
		context.setState(new MSHit());
	}

    @Override
    public int theState() {
        return 1;
    }

    
	
}
