/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.security;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;

/**694559977
 *This class implement the encrytion algorithm for cryptin password a
 * @author BEKONDO KANGUE DIEUNEDORT <bekondo_dieu@yahoo.fr  tel : 695 42 7874>
 * @since  24/10/2018
 */
public class DESEncrypter {
    
    
            /**
             * 
             */
            private static final String DES_ALG = "DESede" ;
            
         

            private String stringKey ="akatuky";
            /**
             * Reference sur l'instance unique de l'encrypteur
             */
            private static DESEncrypter _instance = null;

            /**
             * Le cypher d'encryption
             */
            private static Cipher encryptCipher = null ;
            /**
             * Le cypher de decryption
             */
            private static Cipher decryptCipher = null ;
            /**
             * Cle secret
             */
            private SecretKey passwordKey =null;

            /**
             * Constructeur par defaut
             * @throws NoSuchAlgorithmException 
             * @throws NoSuchPaddingException 
             * @throws InvalidKeyException 
             */
            private DESEncrypter() {

                    try{	
                        //Generation de la cle DES base sur le mot de passe
                        KeyGenerator keyGenerator= KeyGenerator.getInstance(DES_ALG) ;
                        //Definition de la taille de la cle compri entre 112 ou 168
                        keyGenerator.init(168);
                        passwordKey = keyGenerator.generateKey();
                        //Initialisation du cipher d'encryption
                        encryptCipher = Cipher.getInstance(DES_ALG);
                        encryptCipher.init(Cipher.ENCRYPT_MODE, passwordKey);
                        //Initialisation du ciphr de decryption
                        decryptCipher =  Cipher.getInstance(DES_ALG);
                        decryptCipher.init(Cipher.DECRYPT_MODE, passwordKey);
                    }catch(Exception ex){
                         throw new RuntimeException("Erreur lors de l'initialisation de l'Encrypteur", ex);
                    }
            }

            public synchronized static DESEncrypter getInstance(){

                //Si instance est null 
                if(_instance==null){

                    _instance = new DESEncrypter();
                }

                return _instance;
            }
            

            /**
             * Fonction d'encryption du text
             * @param text
             * @return
             */
            public synchronized String encryptText(String text){

                return md5encryption(text);
        //        try {
        //        	//Optention de byte
        //			byte[] plainTextByte = text.getBytes("UTF8");
        //			//Encodage
        //			byte[] encryptedBytes = encryptCipher.doFinal(plainTextByte);
        //			
        //			//Retourner la chaine encrypte
        //			return new String(Base64.encodeBase64(encryptedBytes));
        //			
        //		} catch (Exception e) {
        //			// TODO Auto-generated catch block
        //			e.printStackTrace();
        //			throw new RuntimeException("Erreur lors de l'encryptage de la chaîne", e);
        //		}

            }

            public synchronized String decryptText(String text){


                try {

                        //Obtention des bytes
                        byte[] encodedBytetext = Base64.decodeBase64(text.getBytes());

                        //Decryption
                                byte[] byteText = decryptCipher.doFinal(encodedBytetext);

                                //Retour de la chaîne
                                return new String(byteText , "UTF-8");
                        } catch (Exception e) {
                            ;
                                e.printStackTrace();
                                throw new RuntimeException("Erreur lors du décryptage de la chaîne", e);
                        } 
            }

            public synchronized String md5encryption(String text){
                MessageDigest md = null;
                    try {
                        md = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(DESEncrypter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    byte[] passwordBytes = text.getBytes();
                    byte[] hash = md.digest(passwordBytes);
                    String passwordhash = Base64.encodeBase64String(hash);
                    return passwordhash;
            }
            
            public synchronized  File encryptFile(File fichier){
                if(fichier==null||!fichier.exists()){
                    return null;
                }
                String filename = fichier.getName();
                StringBuffer ciblenamebuf = new StringBuffer(filename.split(".")[0]);
                Date now = new Date();
                ciblenamebuf.append(Long.toString(now.getTime()));
                ciblenamebuf.append("."+filename.split(".")[1]);
                File cible = new File(ciblenamebuf.toString());
                return cible;
            }
}
