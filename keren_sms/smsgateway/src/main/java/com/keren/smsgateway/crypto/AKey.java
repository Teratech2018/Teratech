/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.crypto;

/**
 *Abstract class representing an encryption key.
 * @author BEKO
 */
public abstract class AKey {
    public static String asHex(byte buf[])
	{
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;
		for (i = 0; i < buf.length; i++)
		{
			if (((int) buf[i] & 0xff) < 0x10) strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}

	public static String asString(byte[] bytes)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i ++)
			buffer.append((char) bytes[i]);
		return buffer.toString();
	}
}
