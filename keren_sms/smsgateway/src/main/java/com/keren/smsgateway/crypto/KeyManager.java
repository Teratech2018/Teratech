/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.smslib.SMSLibException;

/**
 *The KeyManager class handles the association of a number (originator or
 * recipient) with a cryptographic key.
 * @author BEKO
 */
public class KeyManager {
    static private KeyManager _instance = null;

	HashMap<String, AKey> keys;

	private KeyManager()
	{
		keys = new HashMap<String, AKey>();
	}

	static public KeyManager getInstance()
	{
		if (_instance == null) _instance = new KeyManager();
		return _instance;
	}

	/**
	 * Associates a mobile number with an encryption key.
	 * 
	 * @param mobileNumber
	 *            The mobile number which will be associated with the encryption
	 *            key.
	 * @param key
	 *            The encryption key.
	 * @see AKey
	 * @see #registerKey(String, AKey)
	 * @see #unregisterAllKeys()
	 */
	public void registerKey(String mobileNumber, AKey key)
	{
		keys.put((mobileNumber.charAt(0) == '+' ? mobileNumber.substring(1) : mobileNumber), key);
	}

	/**
	 * Removes the association of a mobile number with a key.
	 * 
	 * @param mobileNumber
	 *            The mobile number which will be removed from the key
	 *            associations.
	 * @return The encryption key which was associated with the specific mobile
	 *         number.
	 * @see AKey
	 * @see #registerKey(String, AKey)
	 */
	public AKey unregisterKey(String mobileNumber)
	{
		return keys.remove((mobileNumber.charAt(0) == '+' ? mobileNumber.substring(1) : mobileNumber));
	}

	/**
	 * Removes all associations of mobile numbers and encryption keys.
	 */
	public void unregisterAllKeys()
	{
		keys.clear();
	}

	/**
	 * Returns the encryption key of the specified mobile number. Returns null
	 * if there is no association.
	 * 
	 * @param mobileNumber
	 *            The mobile number to look for.
	 * @return The encryption key, null if no key was previously associated.
	 */
	public AKey getKey(String mobileNumber)
	{
		return keys.get((mobileNumber.charAt(0) == '+' ? mobileNumber.substring(1) : mobileNumber));
	}

	/**
	 * Encrypts the specified message with the encryption key already associated
	 * with the specified mobile number.
	 * 
	 * @param mobileNumber
	 *            The mobile number which the message will be send to / received
	 *            from.
	 * @param message
	 *            The decrypted message.
	 * @return The encrypted message.
	 * @throws SMSLibException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] encrypt(String mobileNumber, byte[] message) throws SMSLibException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException
	{
		AKey k = getKey(mobileNumber);
		if (k == null) throw new SMSLibException("Could not find Encryption Key for the specific number.");
		else if (k instanceof ASymmetricKey) return ((ASymmetricKey) k).encrypt(message);
		else return new byte[0];
	}

	/**
	 * Decrypts the specified message with the encryption key already associated
	 * with the specified mobile number.
	 * 
	 * @param mobileNumber
	 *            The mobile number which the message received from.
	 * @param message
	 *            The encrypted message.
	 * @return The decrypted message.
	 * @throws SMSLibException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] decrypt(String mobileNumber, byte[] message) throws SMSLibException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException
	{
		AKey k = getKey(mobileNumber);
		if (k == null) throw new SMSLibException("Could not find Encryption Key for the specific number.");
		else if (k instanceof ASymmetricKey) return ((ASymmetricKey) k).decrypt(message);
		else return new byte[0];
	}
}
