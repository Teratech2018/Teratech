/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 * Class representing an inbound sms message of unknown type. These messages are
 * not handled by SMSLib, however you are given the chance to delete them.
 * @author BEKO
 */
public class UnknownMessage extends InboundMessage{
    private static final long serialVersionUID = 3172468666650104087L;

	private String pdu;

	public UnknownMessage(String myPdu, int memIndex, String memLocation)
	{
		super(MessageTypes.UNKNOWN, memIndex, memLocation);
		this.pdu = myPdu;
	}

	/**
	 * Returns the PDU data block.
	 * 
	 * @return The PDU data block.
	 */
	public String getPDU()
	{
		return this.pdu;
	}

	@Override
	public String toString()
	{
		String str = "";
		str += "===============================================================================";
		str += "\n";
		str += "<< UNKNOWN MESSAGE DUMP >>";
		str += "\n";
		str += "-------------------------------------------------------------------------------";
		str += "\n";
		str += " Gateway Id: " + getGatewayId();
		str += "\n";
		str += " Memory Index: " + getMemIndex();
		str += "\n";
		str += " Memory Location: " + getMemLocation();
		str += "\n";
		str += "===============================================================================";
		str += "\n";
		return str;
	}
}
