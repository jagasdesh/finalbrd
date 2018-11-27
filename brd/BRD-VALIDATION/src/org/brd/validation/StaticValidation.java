package org.brd.validation;

import java.util.regex.Matcher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.regex.Pattern;

public class StaticValidation {
	public static void main(String args[]) {
		System.out.println("id validation");
		System.out.println(getId(5, "Integer"));
		System.out.println("length validation");
		System.out.println(getLength("1234567", "Integer"));
		System.out.println("emailid validation");
		String email = "mjranganath444@gmail.com";
		System.out.println((getEmail(email)));
		System.out.println("validate date");
		System.out.println(getDate("03-30-1996"));
		System.out.println("validate special char");
		System.out.println(getchar("jagadesh"));
		System.out.println("domainvalue");
		System.out.println(DomainValue());

	}

	public static boolean getId(Object object, String Integer) {
		if (object.getClass().getSimpleName().equals("Integer")) {

			return true;

		}
		return false;
	}

	public static boolean getLength(Object object, String datatype) {
		if (object.getClass().getSimpleName().equals("String")) {

			if (datatype.length() == 7)

			{
				return true;
			}
		}

		return false;
	}

	public static boolean getEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();

	}

	public static boolean getDate(String date) {
		String regex = "^(1[0-2]|0[1-9])-(3[01]" + "|[12][0-9]|0[1-9])-[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) date);
		return matcher.matches();
	}

	public static boolean getchar(String strtest) {
		if (strtest.contains("@)") || strtest.contains("#") || strtest.contains("$") || strtest.contains("%")
				|| strtest.contains("^")) {
			return false;
		}
		return true;

	}

	public static boolean DomainValue() {
		ArrayList<String> AI = new ArrayList<String>();
		AI.add("SUNDAY");
		AI.add("MONDAY");
		AI.add("TUESDAY");
		AI.add("WENDNESDAY");
		AI.add("THURSDAY");
		AI.add("FRIDAY");
		AI.add("SATURDAY");
		if (AI.contains("MONDAY")) {
			return true;
		} else {
			return false;

		}

	}

}
