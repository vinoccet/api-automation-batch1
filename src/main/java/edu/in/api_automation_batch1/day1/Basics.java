package edu.in.api_automation_batch1.day1;

public class Basics {
	
	// Primitive datatypes
	// int, String, char, boolean, float, double

    String baseURL="https://reqres.in";
    String endPoint="/api/users";
    int statusCode= 200;

	public static void main(String[] args) {
		Basics basic=new Basics();
		System.out.println(basic.baseURL);
		System.out.println(basic.endPoint);
		System.out.println(basic.statusCode);
	}

	// The baseurl is https://reqres.in with end point /api/users returns 200 status with token <token value>
	//Token is ready to be used for API calls".
	

}
