/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.ajwcc.pduUtils.gsm3040.SmsDeliveryPdu;
import org.smslib.SMSLibException;
import org.smslib.crypto.AKey;
import org.smslib.crypto.KeyManager;

/**
 *
 * @author BEKO
 */
public class InboundEncryptedMessage extends InboundBinaryMessage{
    private static final long serialVersionUID = -5295247413817910711L;

    public InboundEncryptedMessage(SmsDeliveryPdu pdu, int memIndex, String memLocation)
    {
            super(pdu, memIndex, memLocation);
    }

    public String getDecryptedText() throws SMSLibException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException
    {
            KeyManager km = KeyManager.getInstance();
            if (km.getKey(getOriginator()) != null) setDataBytes(km.decrypt(getOriginator(), getDataBytes()));
            else throw new SMSLibException("Message is not encrypted, have you defined the key in KeyManager?");
            return AKey.asString(getDataBytes());
    }
}
