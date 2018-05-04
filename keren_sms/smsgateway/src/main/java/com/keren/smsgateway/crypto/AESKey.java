/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.smslib.crypto.ASymmetricKey;

/**
 *Class representing an AES algorithm encryption key.
 * The class is based on standard JDK AES implementation (128 bit key). 
 * @author BEKO
 */
public class AESKey extends ASymmetricKey{
    public AESKey() throws NoSuchAlgorithmException
	{
		setKey(generateKey());
	}

	public AESKey(SecretKeySpec key)
	{
		setKey(key);
	}

	public SecretKeySpec generateKey() throws NoSuchAlgorithmException
	{
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		byte[] raw = secretKey.getEncoded();
		return new SecretKeySpec(raw, "AES");
	}

	public byte[] encrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, getKey());
		return cipher.doFinal(message);
	}

	public byte[] decrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException	
	{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, getKey());
		return cipher.doFinal(message);
	}

	public static void main(String[] args)
	{
		try
		{
			AESKey k = new AESKey();
			k.setKey(k.generateKey());
			
			String message = "Hello from Thanasis :)";
			System.out.println(">>> " + message);
			byte[] enc = k.encrypt(message.getBytes());
			byte[] dec = k.decrypt(enc);
			System.out.println(">>> " + asString(dec));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
