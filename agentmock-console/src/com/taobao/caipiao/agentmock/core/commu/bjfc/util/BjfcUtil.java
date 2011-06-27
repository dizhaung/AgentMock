package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class BjfcUtil {

	private static final Logger logger = LoggerFactory.getLogger(BjfcUtil.class);
	
	public static String MD5(String base64Xml){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return Tool.bytesToHexString(md5.digest(base64Xml.trim()
					.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			logger.error("md5���ܴ���--->",e);
		}
		return "";
	}
	
	public static String packBody(String requestBodyXml,String digestKey){
		Des des = new Des(digestKey);
		//des.setKey(digestKey);
		return des.getEncString(requestBodyXml);
	}
	
	/**����byte[]��������,String�������
	 * ������ѹ��������,ѹ��ʱ��ʹ��bytesתstring����,ֱ��ʹ��bytes
	 * @author fuguo
	 * @return String 
	 */
	public static String packBodyByte(byte[] requestBodyXml,String digestKey){
		Des des = new Des();
		des.setKey(digestKey);
		return des.getEncStringByte(requestBodyXml);
	}
	
	public static boolean validBody(String md, String body)
			throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		String newMD5 = Tool.bytesToHexString(md5
				.digest(body.trim().getBytes()));
		Tool.getLogger().debug("newMD5::" + newMD5);
		Tool.getLogger().debug("oldMD5::" + md);
		if (!newMD5.equals(md.toUpperCase())){
			logger.error("�������ʽӿ�xml������md5У���쳣 newMD5::" + newMD5+"  oldMD5::" + md );
			return false;
		}
		return true;
			
		
	}
	
	public  static String unpackBodyToXML(String packInfo,String digestKey)
	throws IOException, Exception {
		Des des = new Des();
		des.setKey(digestKey);
		String xml = des.getDesString(packInfo);
		return xml;
	}
	
	/**
	 * ���� ��String��������,byte[]�������
	 * ������ѹ�������Ľ�ѹ��ʱ��ʹ��bytesתstring����,ֱ�ӷ���bytes
	 * @param strMi
	 * @author fuguo
	 * @return
	 */
	public  static byte[] unpackBodyToXMLByte(String packInfo,String digestKey)
	throws IOException, Exception {
		Des des = new Des();
		des.setKey(digestKey);
		byte[] xml = des.getDesStringByte(packInfo);
		return xml;
	}
	
	/**
	 * �н���ϸ�ļ�MD5У�� true:У��ͨ��  ��flase:У�鲻ͨ��
	 * @param fileContents
	 * @param sign
	 * @return
	 */
	public static boolean checkMd5(String fileContents, String sign, String md5Key){
		try {

			String BeginWord = "<head>";
			String EndWord = "<sign>";
			String md5_text = (String) fileContents.subSequence(
					fileContents.indexOf(BeginWord), fileContents.indexOf(EndWord));		
			String MyMd5 = null;
			MyMd5 = getMD5(md5_text.trim() + md5Key);
			if (MyMd5.equals(sign))
				return true;
			else
				logger.warn("md5У���н���ϸ�ļ��쳣 MyMD5::" + MyMd5+"  sign::" + sign );
				return false;
		}
		 catch (Exception e) {
			logger.error("���������н���ϸ�ļ�MD5У�����󣬿�����ϸ�ļ��еĸ�ʽ���ԣ�", e);
			e.printStackTrace();
			return false;
		}
	}
	
	public final static String getMD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));

			}
			return sb.toString();
		} catch (Exception e) {
			logger.error("���������н���ϸ�ļ�MD5У��ʱ���󣬸���<head><body>�������ɵ�MD5����", e);
			return null;
		}
	}
 
	public static void main(String[] args) {
		
	}

}
