/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*
 * Participant: State
 */

public interface BombState {
	
	void goNext(Bomb context);
        
        public int theState ();
	
}
