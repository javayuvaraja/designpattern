package com.pattern.creational.facade;

public class Computer {

	// the components of a computer

	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void run() {
		cpu.processData();
		memory.load();
		hardDrive.readdata();
	}
	
	class CPU {
		public void processData() {
			System.out.println("CPU Processing...");
		}
	}

	class Memory {
		public void load() {
			System.out.println("Memory Loading...");
		}
	}

	class HardDrive {
		public void readdata() {
			System.out.println("Initializing the hard drive....");
		}
	}

}
