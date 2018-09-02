package model;
public class FSAlive implements FSState {
	
	public FSAlive() {
		Bomb.isDying = 0;
	}

	@Override
	public void goNext(FlyingSaucer context) {
		context.setState(new FSHit());
	}

    @Override
    public int theState() {
        return 1;
    }

    

    

   
	
}
