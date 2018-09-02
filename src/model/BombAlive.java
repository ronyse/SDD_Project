/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class BombAlive implements BombState {
	
	public BombAlive() {
		Bomb.isDying = 0;
	}

	@Override
	public void goNext(Bomb context) {
		context.setState(new BombHit());
	}

    @Override
    public int theState() {
        return 1;
    }
	
}
