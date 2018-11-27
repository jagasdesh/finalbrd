package com.brd.fileoperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Program {

	public static void main(String[] args) throws IOException, SQLException {

		javaconn obj = new javaconn();

		String file = "D:\\BRD-File Upload\\BRD-File Upload\\Test Cases\\File1.txt";

		if (file.endsWith(".txt")) {
			System.out.println("valid extension");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			int autoGeneratedId = 0;
			// iterating for each line.

			while ((line = reader.readLine()) != null) {
				line += "~";

				String[] parts = line.split("(?<=~)");

				for (int ctr = 0; ctr < parts.length; ctr++) {
					while (parts[ctr].length() >= 1 && parts[ctr].charAt(parts[ctr].length() - 1) == '~') {
						parts[ctr] = parts[ctr].substring(0, parts[ctr].length() - 1);
					}
				}
				boolean result = mainvalidation(parts);

				if (result == true) {
					autoGeneratedId++;
					obj.connmethod(Integer.toString(autoGeneratedId), parts[0], parts[1], parts[2], parts[3], parts[4],
							parts[5], parts[6], parts[7], parts[8], parts[9], parts[10], parts[11], parts[12],
							parts[13], parts[14], parts[15]);
					for (String part : parts) {
						System.out.println(part);
					}

				} else {
					System.out.println("");
				}

			}
		} else {
			System.out.println("EXTENSION NOT SUPPORTED TRY WITH .TXT FORMAT");

		}

	}

	public static boolean mainvalidation(String parts[]) {
		if (validateLength(parts[4]) && validateemail(parts[5]) && RecordStatus(parts[8]) && validDataType(parts[1])
				&& RecordAInactive(parts[9])) {

			return true;

		} else {
			return false;

		}

	}

	public static boolean validateLength(String parts) {

		if (parts.length() <= 6) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean validateemail(String parts) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (parts == null)
			System.out.println("email not avalible");
		// System.out.println(parts);
		boolean check = pat.matcher(parts).matches();
		if (check == true) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean RecordStatus(String parts) {

		if (parts.equals("N") || parts.equals("D") || parts.equals("R") || parts.equals("M")
				|| parts.equals("A") == true) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean validDataType(String parts) {
		String datatypeRegex = "^[a-zA-Z0-9\\s]+$";
		Pattern pat = Pattern.compile(datatypeRegex);
		if (parts == null)
			System.out.println("incorrect datatype");

		boolean match = pat.matcher(parts).matches();
		if (match == true) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean RecordAInactive(String parts) {

		if (parts.equals("A") || parts.equals("I") == true) {
			return true;
		} else {
			return false;
		}
	}

}
