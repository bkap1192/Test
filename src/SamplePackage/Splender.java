package SamplePackage;

public class Splender extends Bike2
{
	void run()
	{
		System.out.println("running safely");
	}
	
	public static void main(String args[])
	{
		Bike2 b=new Splender();
		b.run();
	}

}
