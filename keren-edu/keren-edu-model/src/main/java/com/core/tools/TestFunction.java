package com.core.tools;

import java.util.Date;

public class TestFunction {

	public static void main(String[] args) {

		double value = DateHelper.hours("08:00", "10:30", new Date());
		System.out.println("TestFunction.main() hours is " + value);

	}

}
