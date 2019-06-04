package utils;

public class JSONComp{
	public int compare(String res1, String res2) {
		int status = 2;

		try {
			//String resbody1 = res1.getBody().asString();
			//String resbody2 = res2.getBody().asString();

			if (res1 == null  || res2 == null) {
				throw new MyException(res1, res2);
			}
			if(res1.equals(res2)) 
				status= 0;

			else 
				status= -1;
		}
		catch(NullPointerException ne) {
			System.out.println("input was null");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}

