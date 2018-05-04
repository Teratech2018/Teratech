/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import org.ajwcc.pduUtils.gsm3040.SmsSubmitPdu;

/**
 *Class representing an outbound binary (forced 8bit encoded) sms message.
 * @author BEKO
 */
public class OutboundBinaryMessage extends OutboundMessage{
    
        private static final long serialVersionUID = 6449191177648891555L;

	private byte[] dataBytes;

	public OutboundBinaryMessage()
	{
		super();
		setEncoding(MessageEncodings.ENC8BIT);
	}

	/**
	 * Outbound message constructor.
	 * 
	 * @param myRecipient
	 *            The recipient of the message.
	 * @param bytes
	 *            The bytes (binary data) of the message.
	 */
	public OutboundBinaryMessage(String myRecipient, byte[] bytes)
	{
		super();
		this.recipient = myRecipient;
		setEncoding(MessageEncodings.ENC8BIT);
		setDataBytes(bytes);
	}

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
		if (this.dataBytes != null)
		{
			byte[] newArray = new byte[this.dataBytes.length + myDataBytes.length];
			System.arraycopy(this.dataBytes, 0, newArray, 0, this.dataBytes.length);
			System.arraycopy(myDataBytes, 0, newArray, this.dataBytes.length, this.dataBytes.length);
			setDataBytes(newArray);
		}
		else
		{
			setDataBytes(this.dataBytes);
		}
	}

	@Override
	protected void setPduPayload(SmsSubmitPdu pdu)
	{
		pdu.setDataBytes(this.dataBytes);
	}
    
}
