import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class FixWindow extends Event implements Fixable {

	public FixWindow(long delayTime, GreenhouseControls greenhouse) {
		super(0, greenhouse);
	}

	@Override
	public void fix() {
		greenhouse.setVariable("windowOk", true);
		greenhouse.setVariable("errorcode", 0);
		
	}

	@Override
	public void log() {
		File fixLog = new File("fix.log");
		try {
			FileWriter writer = new FileWriter(fixLog);
			Calendar now = Calendar.getInstance();
			writer.write(""+now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH)+"-"+
			now.get(Calendar.DATE)+"    "+now.get(Calendar.HOUR_OF_DAY)+":"+
					now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND)+
					"------------Repaired Window");
			writer.flush();
			writer.close();
			Scanner scanner = new Scanner(fixLog);
			System.out.println(scanner.nextLine());
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void action() throws ControllerException {
		this.fix();
		this.log();
		
	}

	@Override
	public String toString() {
		return "Finished Repairing Window";
	}

	@Override
	public void resumeRestored() {
		//doesnt ever need to run
	}
	
}
