package com.container.windowEvents.AWT;
//Abstract windowing toolkit: it is platform - dependent 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



class Vehicle{
	
	String color;
	int cc;
	int gears;
	

Vehicle(String color, int cc, int gears){
	this.color = color;
	this.cc = cc;
	this.gears = gears;
}

void drived(Graphics g) {
	System.out.println("Vehicle is Drived");
}
void pause() {
	System.out.println("Vehicle is paused");
}
 void resume() {
	System.out.println("Vehicle is resumed");
}

}


class EBicycle extends Vehicle{
	 
	EBicycle(String color, int cc, int gears){
		super(color, cc, gears);
	}
		
	@Override  
	void drived(Graphics g) {
		System.out.println("Ebicycle is drived");
		for(int i = 0; i <100; i++) {
			try {
                Thread.sleep(50);
			}
                catch(InterruptedException e ) {
                	e.printStackTrace();
                }
			g.clearRect(0, 0, 600, 600);
			 g.drawOval(50, 150, 50, 50);  //Left circle
			 g.drawOval(70, 170, 10, 10);  // Small circle
			 
			 g.drawOval(160, 150, 50, 50); //Right circle
			 g.drawOval(180, 170, 10, 10); // Small circle
			 
			 g.drawRect(90, 130, 20, 10); //rectangle
			 g.drawLine(170, 115, 185, 175);//cycle handle to big Circle
			 g.drawArc(140, 110, 30, 10, 260, 190); // ARC = g.drawArc 110 up and down ,70 width, 10 
			 
			// Drawing the pedals
		        g.drawOval(120, 170, 10, 10); // center pedal circle
		        g.drawLine(125, 175, 115, 185); // left pedal
		        g.drawLine(125, 175, 135, 185); // right pedal
			
		    //Left and Right side straight line
		        g.drawLine(75, 175, 125, 175); // Horizontal Line____main body
		        g.drawLine(125, 175, 175, 140);//Right line
		        g.drawLine(100, 140, 175, 140); // upper frame
		        g.drawLine(75, 175, 100, 140); // lower frame and also left side line
		        g.drawLine(98, 139, 124, 173);//vertical 
			}
		}
	@Override  
	void pause() {
		System.out.println("EBicycle is pausecd");
	}
	@Override  
	void resume() {
		System.out.println("EBicycle is resumed");
	}
	
}

class Car extends Vehicle{
	Car(String color, int cc, int gears){
		super(color, cc, gears);
	}
	@Override  
	void drived(Graphics g) {
		System.out.println("Car is drived");
		for(int i= 0; i<100; i++) {
			try {
				Thread.sleep(50);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			g.clearRect(0, 0, 600, 600);
			// Draw car body 
	        g.drawRect(100, 350, 300, 50); // Main body 
	        g.drawRect(150, 300, 200, 50); // Top part of the car
	        
	        // Draw car details
	        g.drawRect(220, 310, 60, 20);  
	       
	        // Draw car wheels
	        g.drawOval(120, 400, 50, 50); // Left wheel 
	        g.drawOval(330, 400, 50, 50); // Right wheel
	        
		}
	}
	void pause() {
		System.out.println("Car is pause");
	}
	void resume() {
		System.out.println("Car is resume");
	}
}

public class MyVehicle extends Frame {
	private Vehicle currentVehicle;

	public MyVehicle() {
	
		this.setVisible(true);
		this.setSize(600, 600);
		this.setTitle("User Interface");
		//this.setBackground(Color.gray);
		
		
		Button BtnEBicycle = new Button("Click EBicycle ");
		Button BtnCar = new Button("Click Car");
		 
		BtnEBicycle.setBounds(50, 50, 100, 50);
		BtnCar.setBounds(200, 50 ,100, 50);
		
		this.setLayout(null);
		this.add(BtnEBicycle);
		this.add(BtnCar);
		
		 BtnEBicycle.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                currentVehicle = new EBicycle("Red", 100, 5);
	                repaint();
	            }
	        });

	     BtnCar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                currentVehicle = new Car("Blue", 800, 5);
	                repaint();
	            }
	        });
		
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g) {
        if (currentVehicle != null) {
            currentVehicle.drived(g);
        }
    }
	
	public static void main(String[] args) {
		new MyVehicle();
		MyVehicle Veh = new MyVehicle();
		

	}

}
