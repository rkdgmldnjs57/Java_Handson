import java.util.Scanner;


class OutOfRangeException extends RuntimeException {}
class AddZeroException extends RuntimeException {}
class SubtractZeroException extends RuntimeException {}

public class SimpleCalculator {
	static int opd1;
	static int opd2;
	
	public void getAddOPD(String str) throws AddZeroException {
		opd1 = Integer.parseInt(str.split("\\+")[0]);
		opd2 = Integer.parseInt(str.split("\\+")[1]);
		if(opd1==0 || opd2==0)
			throw new AddZeroException();
	}
	
	public void getSubOPD(String str) throws SubtractZeroException {
		opd1 = Integer.parseInt(str.split("-")[0]);
		opd2 = Integer.parseInt(str.split("-")[1]);
		if(opd1==0 || opd2==0)
			throw new SubtractZeroException();
	}
	
	public int arith(int mode) {
		int ret;
		if(mode == 0) ret = opd1+opd2;
		else ret = opd1-opd2;
		if(opd1<0 || opd1>1000 || opd2<0 || opd2>1000 || ret<0 || ret>1000)
			throw new OutOfRangeException();
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleCalculator Cal = new SimpleCalculator();
		Scanner sc = new Scanner(System.in);
		String inpStr = sc.nextLine();
		
		try {
			if(inpStr.contains("+")) {
				Cal.getAddOPD(inpStr);
				System.out.println(Cal.arith(0));
			}
			else {
				Cal.getSubOPD(inpStr);
				System.out.println(Cal.arith(1));
			}
		}
		catch(AddZeroException e) {
			System.out.println("AddZeroException");
		}
		catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
		}
		catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
		}
	}
}
