/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author BEKO
 */
public abstract class ASymmetricKey extends AKey{
    private SecretKeySpec key;

	/**
	 * Returns the encryption key.
	 * 
	 * @return The encryption key.
	 */
	public SecretKeySpec getKey()
	{
		return key;
	}

	/**
	 * Sets the encryption key.
	 * 
	 * @param key
	 *            The encryption key.
	 */
	public void setKey(SecretKeySpec key)
	{
		this.key = key;
	}

	/**
	 * Key generation.<br>
	 * The method should be implemented in the descending classes, according to
	 * the implementation.
	 * 
	 * @return The generated encryption key.
	 * @throws NoSuchAlgorithmException
	 */
	public abstract SecretKeySpec generateKey() throws NoSuchAlgorithmException;

	/**
	 * Message encryption.<br>
	 * The method should be implemented in the descending classes, according to
	 * the implementation.
	 * 
	 * @param message
	 *            The message to be encrypted.
	 * @return The encrypted message.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 */
	public abstract byte[] encrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException;

	/**
	 * Message decryption.<br>
	 * The method should be implemented in the descending classes, according to
	 * the implementation.
	 * 
	 * @param message
	 *            The message to be decrypted.
	 * @return The decrypted message.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 */
	public abstract byte[] decrypt(byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException;
}
