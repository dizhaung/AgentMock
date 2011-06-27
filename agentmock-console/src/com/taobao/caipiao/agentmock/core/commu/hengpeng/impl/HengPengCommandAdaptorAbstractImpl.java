package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.HengPengCommandAdaptor;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.util.CalendarUtil;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.util.MD5;

/**
 * @author youshan
 */
public abstract class HengPengCommandAdaptorAbstractImpl implements HengPengCommandAdaptor{
	protected static final String TaobaoAgentIdSSQ = "023005";
	protected String inputFile;
	protected XPathFactory factory = XPathFactory.newInstance();
	protected AgentCommConfig config;
	protected final static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
	protected static ConcurrentHashMap<String,String> ticketNumberMap = 
		new ConcurrentHashMap<String, String>();
	
	
	public void setXmlMsg(String xml) {
		this.inputFile = xml;
	}
	
	public void setAgentCommConfig(AgentCommConfig config){
		this.config = config;
	}
	
	public final static StringBuilder createRequestXmlHead(
			final String tranType, final String requestXmlBody,
			String taobaoAgentId, String digestKey) {
		StringBuilder sb = new StringBuilder(XML_HEAD);
		// ��� ��ǰ ��ʽ Ϊ yyyyMMddHHmmss �� ����
		String date = CalendarUtil.toString(CalendarUtil.getCurrentDate(),
				CalendarUtil.TIME_PATTERN_SESSION);
		String id = taobaoAgentId + date + System.nanoTime()
				+ Thread.currentThread().getId();// agentID + 8λʱ���(yyyyMMdd) +
		// ϵͳʱ���������+��ǰ�̵߳�id
		// XXX: ע�����츣�ʵĽӿڰ汾����1.1�����ǽ������ʵ�1.0��
		sb.append("<message version=\"1.1\" id=\"").append(id).append("\">");
		sb.append("<header>");
		sb.append("<messengerID>");
		sb.append(taobaoAgentId);
		sb.append("</messengerID>");
		sb.append("<timestamp>");
		sb.append(date);
		sb.append("</timestamp>");
		sb.append("<transactionType>");
		sb.append(tranType);
		sb.append("</transactionType>");
		sb.append("<digest>");
		sb.append(MD5.encode(id + date + digestKey + requestXmlBody));
		sb.append("</digest>");
		sb.append("</header>");
		return sb;
	}
	
	/**
	 * �������츣�ʺ���ӿڵ�ǩ���淶��֤����Ϸ���
	 * 
	 * @param xml
	 * @return
	 */
	public boolean checkXml(String xml, String digestKey) {
		try {
			String id = factory.newXPath().evaluate(
					"/message/@id",
					new InputSource(new StringReader(xml))
					);
			String timestamp = factory.newXPath().evaluate(
					"/message/header/timestamp",
					new InputSource(new StringReader(xml))
					);
			// ��������������ȡ<body>����
			int beginIndex = xml.indexOf("<body>");
			int endIndex = xml.indexOf("</body>");
			String body = xml.substring(beginIndex, endIndex) + "</body>";
			// ��������������ȡ������ժҪ
			String digest = factory.newXPath().evaluate(
					"/message/header/digest",
					new InputSource(new StringReader(xml))
					);
			// ���м���������ժҪ�����бȶ�
			String md5 = MD5.encode(id + timestamp + digestKey + body);
			if (digest.equalsIgnoreCase(md5)) {
				// �ȶ�һ�£���֤ͨ��
				return true;
			}
		} catch (XPathExpressionException e) {
		}
		
		// ��֤δͨ��
		return false;
	}
	
}

