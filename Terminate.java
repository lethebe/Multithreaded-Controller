
public class Terminate extends Event {

	public Terminate(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
		
	}

	@Override
	public void action() throws ControllerException {
		System.out.println("Terminating...");
		System.exit(0);
	}

	@Override
	public void resumeRestored() {
		new Terminate(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}
	
}
