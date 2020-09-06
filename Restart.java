import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Restart extends Event  {

	public Restart(long delayTime, GreenhouseControls greenhouse) {
		super(0, greenhouse);
	
	}

	@Override
	public void action() throws ControllerException {
		//needs to read in text file and then parse out events from it , and use reflection to do this for the assignment
		File file = new File(greenhouse.state.getEventFile());
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String eventLine = scanner.nextLine();
				eventLine = eventLine.trim();
				String[] splitLine = eventLine.split(",");
				
				if (splitLine[0].trim().contains("Event=ThermostatNight")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = ThermostatNight.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=ThermostatDay")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = ThermostatDay.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=LightOn")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = LightOn.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						Object[] args = {delayTime,greenhouse};
						constructor.newInstance(args);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=LightOff")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = LightOff.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				
				if (splitLine[0].trim().contains("Event=FansOn")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = FansOn.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=FansOff")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = FansOff.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				
				
				if (splitLine[0].trim().contains("Event=PowerOut")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = PowerOut.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=WindowMalfunction")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = WindowMalfunction.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=WaterOff")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = WaterOff.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=WaterOn")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = WaterOn.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=Terminate")) {
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = Terminate.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
				
				if (splitLine[0].trim().contains("Event=Bell")) {
					if (splitLine.length == 2) {
					
					int timelength = splitLine[1].trim().length();
					long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
					Constructor constructor = null;
					try {
						constructor = Bell.class.getConstructor(long.class,GreenhouseControls.class);
					} catch (NoSuchMethodException | SecurityException e) {
						System.out.println("Constructor Error");
					}
					try {
						constructor.newInstance(delayTime,greenhouse);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
					}
					
					else {
						int timelength = splitLine[1].trim().length();
						int ringLength = splitLine[2].trim().length();
						long delayTime = Long.parseLong(splitLine[1].trim().substring(5,timelength));
						int rings = Integer.parseInt(splitLine[2].trim().substring(6,ringLength ));
						Constructor constructor = null;
						try {
							constructor = Bell.class.getConstructor(long.class,GreenhouseControls.class,int.class);
						} catch (NoSuchMethodException | SecurityException e) {
							System.out.println("Constructor Error");
						}
						try {
							constructor.newInstance(delayTime,greenhouse,rings);
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException e) {
							e.printStackTrace();
						}
						
					}
					
				}
				
	
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public String toString() {
		return "Restart Complete";
	}

	@Override
	public void resumeRestored() {
		//never needs to be used
		
	}

}
