/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Library / Version constants.
 * @author BEKO
 */
public class Library {
        private static final String LIB_INFOTEXT = "SMSLib: A Java API library for sending and receiving SMS via a GSM modem or other supported gateways.\nThis software is distributed under the terms of the Apache v2.0 License.\nWeb Site: http://smslib.org";

	private static final int LIB_VERSION = 3;

	private static final int LIB_RELEASE = 4;

	private static final int LIB_SUBRELEASE = 1;

	private static final String LIB_STATUS = "";

	public static final String getLibraryDescription()
	{
		return LIB_INFOTEXT;
	}

	public static final String getLibraryVersion()
	{
		String text;
		text = LIB_VERSION + "." + LIB_RELEASE + "." + LIB_SUBRELEASE;
		if (LIB_STATUS.length() != 0) text = text + "-" + LIB_STATUS;
		return text;
	}
}
