package SamplePackage;

class Abstract2 extends Abstract1{

	@Override
	void run() {
		// TODO Auto-generated method stub
		System.out.println("Running");
	}
	
	public static void main(String[] args){
		
		Abstract1 abs=new Abstract2();
		abs.run();
	}


	
}
