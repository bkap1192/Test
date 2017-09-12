package SamplePackage;

public class TestOverloadingMain 
{

	public static void main(String[] args)
	{
		System.out.println("main method with string[]");
	}
	
	public static void main(String args)
	{
		System.out.println("main method with string");
	}
	
	public static void main()
	{
		System.out.println("main method without string");
	}
}
