package org.brd.EMICalculator;

import java.util.Scanner;

import java.lang.Math;

public class EMIcaluclator {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		EMIcaluclator EC = new EMIcaluclator();

		System.out.println("Equated Monthly Installment (EMI)");

		System.out.println("Enter the principle amount");
		int PrincipleAmount = scanner.nextInt();

		System.out.println("Enter the interest value");
		float InterestRate = scanner.nextFloat();

		System.out.println("Enter the tenure");
		int Tenure = scanner.nextInt();

		System.out.println("Enter the number of installments in a year");
		int NumberOfInstallments = scanner.nextInt();

		if ((Tenure > 0) && (Tenure >= NumberOfInstallments)) {
			double EPay = EC.emiProcressing(PrincipleAmount, InterestRate, Tenure, NumberOfInstallments);

			System.out.println("EMI Value" + String.format("%.2f", EPay));
			System.out.println("Enter Installment Number");
			EC.repayment(EPay, PrincipleAmount, InterestRate, Tenure, NumberOfInstallments);
			scanner.close();

		} else {
			System.out.println("enter valid tenure or tenure should be greater than  number of installments ");
		}
	}

	float emiProcressing(int PrincipleAmount, float InterestRate, int Tenure, int NumberOfInstallments) {

		InterestRate = InterestRate / 100;
		double numerator1 = InterestRate / NumberOfInstallments;
		double numerator2 = PrincipleAmount * numerator1;
		double denominator1 = Math.pow(1 + numerator1, Tenure);
		double denominator2 = (1 - (1 / denominator1));
		float emi = (float) (numerator2 / denominator2);
		return emi;

	}

	void repayment(double ePay, int PrincipleAmount, float InterestValue, int Tenure, int NumberOfInstallments) {
		// double EMI = ePay;

		double Interest[] = new double[125];
		double PAmount[] = new double[125];
		double OutstandAmount[] = new double[125];
		PAmount[1] = PrincipleAmount;
		for (int i = 1; i <= Tenure; i++) {

			Interest[i] = (PAmount[i] * (InterestValue / 1200));
			OutstandAmount[i] = (ePay - Interest[i]);
			PAmount[i + 1] = PAmount[i] - OutstandAmount[i];

			System.out.println(i + " " + String.format("%.2f", Interest[i]) + "  "
					+ String.format("%.2f", OutstandAmount[i]) + "   " + String.format("%.2f", PAmount[i]));

		}
		System.out.println("Enter the installment number");
		int INumber = scanner.nextInt();

		System.out.println(INumber + " " + String.format("%.2f", Interest[INumber]) + "  "
				+ String.format("%.2f", OutstandAmount[INumber]) + "   " + String.format("%.2f", PAmount[INumber]));

	}

}
