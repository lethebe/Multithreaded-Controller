
public class Bell  extends Event{

	public Bell(long delayTime, GreenhouseControls greenhouse) {
		this(delayTime,greenhouse,1);
	}

	public Bell(long delayTime, GreenhouseControls greenhouse, int rings) {
		super(delayTime,greenhouse);
		long counter = 2000;
		for(int i =1; i < rings;i++) {
			new Bell(delayTime+counter,greenhouse);
			counter+=2000;
		}
		
	}

	@Override
	public void action() {
		//doesn't actually do anything, print is called external to action in Event to limit code 
	}
	
	@Override
	public String toString() {
		return "Ring!!";
	}

	@Override
	public void resumeRestored() {
		new Bell(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	
}
