package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

import com.alibaba.common.lang.enumeration.IntegerEnum;

/**
 * @author youshan
 */
public class BjfcCommandEnum extends IntegerEnum{
	private static final long serialVersionUID = 1L;

	/**
	 * 1000 �ύͶע�ӿ�
	 */
	public static final BjfcCommandEnum ORDER_COMMOND = (BjfcCommandEnum) create(1000);
	
	/**
	 * 1003��ѯ����״̬�ӿ�
	 */
	public static final BjfcCommandEnum CHECK_ISSUE = (BjfcCommandEnum) create(1003);

	/**
	 * 1004 ��ѯ��������
	 */
	public static final BjfcCommandEnum GET_LUCKNUMBER = (BjfcCommandEnum) create(1004);

    /**
	 * 2000 ֪ͨ��Ʊ���
	 */
	public static final BjfcCommandEnum ORDERBOOK_RESULT_NOTIFY = (BjfcCommandEnum) create(2000);
	
	/**
	 * 2001 �ں���Ϣ֪ͨ
	 */
	public static final BjfcCommandEnum ISSUE_NOTIFY = (BjfcCommandEnum) create(2001);
	
	/**
	 *  2004 �������֪ͨ
	 */
	public static final BjfcCommandEnum AWARD_ORDER_NOTIFY = (BjfcCommandEnum) create(2004);
	
	/**
	 *  3001 ��ѯ�н��ļ� 
	 */
	public static final BjfcCommandEnum GET_AWARD_ORDER = (BjfcCommandEnum) create(2004);
	
}
