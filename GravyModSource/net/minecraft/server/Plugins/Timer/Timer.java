package net.minecraft.server.Plugins.Timer;

public class Timer extends Thread {
	
	final Runnable task;
	
	long firstRun;
	
	long repetativeRun;
	
	int time = 0;
	
	public Timer(Runnable task, long firstRun, long repetativeRun) {
	
		this.task = task;
		
		this.firstRun = firstRun;
		
		this.repetativeRun = repetativeRun;
		
	}
	
	@Override
	public void run() {
	
		try {
			
			Thread.sleep(firstRun);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runTask();
		
	}
	
	public void runTask() {
	
		task.run();
		
		try {
	        Thread.sleep(repetativeRun);
        } catch (InterruptedException e) {
	        e.printStackTrace();
        }
		
		runTask();
		
	}
	
}
