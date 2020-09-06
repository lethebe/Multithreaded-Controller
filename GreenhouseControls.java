import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Scanner;

public class GreenhouseControls extends Controller {
	
	State state;
	
	public GreenhouseControls() {
		this.state= new State("Hello");
	}
	
	public  void setVariable(String key,Object value) {
		state.addState(key, value);
	}

	public int getError() {
		return state.getErrorcode();
		}
	
	public Fixable getFixable(int errorcode) {
		if (errorcode == 1) {
			return new FixWindow(0,this);
		}
		else {
			return new PowerOn(0,this);
			
		}
	}

	@Override
	public void shutdown(ControllerException e) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		this.suspendAll();
		
		try {
			Thread.sleep(500); //sleep for 0.5 s to allow threads that may have completed wait periods to finish their I/O and terminate 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		String message = e.getMessage();
		System.out.println("System Shutdown initiated due to: "+message);
		if (message.equals("Window Malfunction")) {
			this.setVariable("errorcode", 1);
			File errorLog = new File("error.log");
			try {
				FileWriter writer = new FileWriter(errorLog);
				Calendar now = Calendar.getInstance();
				writer.write(""+now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH)+"-"+
						now.get(Calendar.DATE)+"    "+now.get(Calendar.HOUR_OF_DAY)+":"+
								now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND)+
								"------------Window Malfunction");
				writer.flush();
				writer.close();
				Scanner scanner = new Scanner(errorLog);
				System.out.println(scanner.nextLine());
				scanner.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			this.setVariable("errorcode", 2);
			File errorLog = new File("error.log");
			try {
				FileWriter writer = new FileWriter(errorLog);
				Calendar now = Calendar.getInstance();
				writer.write(""+now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH)+"-"+
						now.get(Calendar.DATE)+"    "+now.get(Calendar.HOUR_OF_DAY)+":"+
								now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND)+
								"------------Power Out");
				writer.flush();
				writer.close();
				Scanner scanner = new Scanner(errorLog);
				System.out.println(scanner.nextLine());
				scanner.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			FileOutputStream fOut = new FileOutputStream("dump.out");
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(this);
			oOut.flush();
			oOut.close();
			System.out.println("Greenhouse serialized to dump.out");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		new Terminate(0,this);
	
	}
	
	public static void printUsage() {
		System.out.println("Correct Format:");
		System.out.println("  java GreenhouseControls -f <filename>, or");
		System.out.println(" java GreenhouseControls -d dump.out");
	}
	
	public static void main(String[] args) {
		try {
			String option = args[0];
			String filename = args[1];
			
			if( !(option.equals("-f")) && !(option.equals("-d"))) {
				System.out.println("Invalid option");
				GreenhouseControls.printUsage();
			}
			GreenhouseControls gc = new GreenhouseControls();
			
			if (option.equals("-f")) {
				gc.setVariable("eventFile", filename);
				new Restart(0,gc);
			}
			
			if (option.equals("-d")) {
				Restore r = new Restore(0,gc,filename);
				Thread.sleep(300); // make sure  restore thread has run completely 
				gc = r.getRestored();
				gc.resumeRestoredAll();
			}
			
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid number of parameters");
			GreenhouseControls.printUsage();
		} catch (InterruptedException e) {
			System.out.println("Interrupt error");
			e.printStackTrace();
		}
	}

	
	


}
