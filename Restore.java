import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Restore extends Event  {
	
GreenhouseControls restored;
String file;
	
	public Restore(long delayTime, GreenhouseControls greenhouse,String file) {
		super(0, greenhouse);
		this.file=file;
	}

	@Override
	public void action() throws ControllerException {
		System.out.println("Restoring the system from dump.out file ");
		try {
			Thread.sleep(50); //make sure file is passed and set before attempting to read 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.restoreGreenhouse(file);
		restored.getFixable(restored.getError());
		
		try {
			Thread.sleep(100); //wait for Fixable to repair the system 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		greenhouse.resumeAll();
		
		
	}
	
	@Override
	public String toString() {
		return "System Restored";
	}
	
	public void restoreGreenhouse(String file) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			this.restored=(GreenhouseControls)in.readObject();
			System.out.println(this.restored.state);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public GreenhouseControls getRestored() {
		return this.restored;
	}

	@Override
	public void resumeRestored() {
		// never needs to be used
		
	}
	
	
}
