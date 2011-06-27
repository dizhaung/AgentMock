package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Des {
	Key key;

	public Des(String str) {
		setKey(str);// �����ܳ�
	}

	public Des() {
		setKey("1234567890ABCDEF");
	}

	/**
	 * ���ݲ�������KEY
	 */
	public void setKey(String strKey) {
		DESKeySpec desKeySpec;
		try {
			desKeySpec = new DESKeySpec(Tool.hexStringToByte(strKey));
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	        key = keyFactory.generateSecret(desKeySpec);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ����String��������,String�������
	 */
	public String getEncString(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.trim().getBytes("UTF8");
			byteMi = this.getEncCode(byteMing);
			strMi = base64en.encode(byteMi);
			strMi = strMi.replace("\r\n", "");
			strMi = strMi.replace("\n", "");
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}
	
	/**����byte[]��������,String�������
	 * ������ѹ��������,ѹ��ʱ��ʹ��bytesתstring����,ֱ��ʹ��bytes
	 * @author fuguo
	 * @return String 
	 */
	public String getEncStringByte(byte[] strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing;
			byteMi = this.getEncCode(byteMing);
			strMi = base64en.encode(byteMi);
			strMi = strMi.replace("\r\n", "");
			strMi = strMi.replace("\n", "");
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}


	/**
	 * ���� ��String��������,String�������
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString(String strMi) {

		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			Tool.getLogger().debug("-------���� start-------------------");
			Tool.getLogger().debug(strMi);
			byteMi = base64De.decodeBuffer(strMi.replace(" ", ""));

			byteMing = this.getDesCode(byteMi);
			Tool.getLogger().debug("----------���� �ֽ�----------------");
			Tool.getLogger().debug(Tool.bytesToHexString(byteMing));
			Tool.getLogger().debug("----------���� start----------------");

			strMing = new String(byteMing, "UTF8");
			Tool.getLogger().debug(strMing);
			Tool.getLogger().debug("----------end----------------");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * ���� ��String��������,byte[]�������
	 * ������ѹ�������Ľ�ѹ��ʱ��ʹ��bytesתstring����,ֱ�ӷ���bytes
	 * @param strMi
	 * @author fuguo
	 * @return
	 */
	public byte[] getDesStringByte(String strMi) {

		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		
		try {
			Tool.getLogger().debug("-------���� start-------------------");
			Tool.getLogger().debug(strMi);
			byteMi = base64De.decodeBuffer(strMi.replace(" ", ""));

			byteMing = this.getDesCode(byteMi);
			Tool.getLogger().debug("----------���� �ֽ�----------------");
			Tool.getLogger().debug(Tool.bytesToHexString(byteMing));
			Tool.getLogger().debug("----------���� start----------------");

			Tool.getLogger().debug("----------end----------------");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64De = null;			
			byteMi = null;
		}
		return byteMing;
	}

	/**
	 * ������byte[]��������,byte[]�������
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * ������byte[]��������,��byte[]�������
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			        
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	// public static void main(String args[]) {
	// DES des = new DES();
	// // ������Կ
	// //des.setKey("12345678");
	//
	// String str1 = "����";
	// //DES����
	// String str2 = des.getEncString(str1);
	// String deStr = des.getDesString(str2);
	// System.out.println("����:" + str2);
	// //DES����
	// System.out.println("����:" + deStr);
	// }
}
