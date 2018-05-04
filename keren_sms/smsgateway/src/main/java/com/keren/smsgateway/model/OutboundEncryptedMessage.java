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
import org.smslib.crypto.KeyManager;

/**
 *Class representing an outbound encrypted message.
 * @author BEKO
 */
public class OutboundEncryptedMessage extends OutboundBinaryMessage{
    private static final long serialVersionUID = 6949191877648893555L;

    public OutboundEncryptedMessage(String recipient, byte[] dataBytes) throws SMSLibException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, org.smslib.SMSLibException
    { 
            setRecipient(recipient);
            KeyManager km = KeyManager.getInstance();
            setDataBytes(km.encrypt(recipient, dataBytes));
    }
}
