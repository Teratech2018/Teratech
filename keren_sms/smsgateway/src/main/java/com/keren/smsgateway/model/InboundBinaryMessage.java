/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import org.ajwcc.pduUtils.gsm3040.PduUtils;
import org.ajwcc.pduUtils.gsm3040.SmsDeliveryPdu;

/**
 *Class representing an inbound binary sms message.
 * @author BEKO
 */
public class InboundBinaryMessage extends InboundMessage{
    
    private static final long serialVersionUID = -5295242414817410716L;

	private byte[] dataBytes;

	@Override
	public String getText()
	{
		throw new RuntimeException("getText() not supported");
	}

	@Override
	public void setText(String s)
	{
		throw new RuntimeException("setText() not supported");
	}

	@Override
	public void addText(String s)
	{
		throw new RuntimeException("addText() not supported");
	}

	public byte[] getDataBytes()
	{
		return this.dataBytes;
	}

	public void setDataBytes(byte[] myDataBytes)
	{
		this.dataBytes = myDataBytes;
		setEncoding(MessageEncodings.ENC8BIT);
	}

	public void addDataBytes(byte[] myDataBytes)
	{
		byte[] newArray = new byte[this.dataBytes.length + myDataBytes.length];
		System.arraycopy(this.dataBytes, 0, newArray, 0, this.dataBytes.length);
		System.arraycopy(myDataBytes, 0, newArray, this.dataBytes.length, myDataBytes.length);
		this.dataBytes = newArray;
	}

	public InboundBinaryMessage(SmsDeliveryPdu pdu, int memIndex, String memLocation)
	{
		super(pdu, memIndex, memLocation);
	}

	@Override
	protected void extractData(SmsDeliveryPdu pdu)
	{
		// binary messages belong in the InboundBinaryMessage subclass not here
		if (pdu.isBinary())
		{
			this.setDataBytes(pdu.getUserDataAsBytes());
		}
		else
		{
			throw new RuntimeException("Trying to apply a text pdu to an InboundBinaryMessage");
		}
	}

	@Override
	public String getPduUserData()
	{
		return PduUtils.bytesToPdu(getDataBytes());
	}
}
