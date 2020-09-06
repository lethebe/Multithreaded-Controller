
public class WindowMalfunction extends Event {

	public WindowMalfunction(long delayTime, GreenhouseControls greenhouse) {
		super(delayTime, greenhouse);
	}

	@Override
	public void action() throws ControllerException {
		greenhouse.setVariable("windowOk", false);
		throw new ControllerException("Window Malfunction");
	}

	@Override
	public void resumeRestored() {
		new Bell(this.getSuspendTime(),greenhouse);
		greenhouse.events.remove(this);
		
	}

}
