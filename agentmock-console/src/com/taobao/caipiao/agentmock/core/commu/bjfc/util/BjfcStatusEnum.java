package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

public enum BjfcStatusEnum {
	/**
	 * "00", "�����ɹ�"
	 */
	OPERATION_SUCCESS_CODE("00", "�����ɹ�"),
	/**
	 * "100001","�������"
	 */
	PROCEDURE_ERROR_CODE("100001","�������"),
	/**
	 * "100002","�������"
	 */
	DECODE_ERROR_CODE("100002","�������"),
	/**
	 * "100003","��Ч����"
	 */
	INVALID_PARAMETER_CODE("100003","��Ч����"),
	/**
	 * "100004","�̻���Ϣ������/״̬����ȷ"
	 */
	SYSTEM_EXCEPTION_CODE("100004","�̻���Ϣ������/״̬����ȷ"),
	/**
	 * "100005","δ��ͨ����Ϸ"
	 */
	VALID_GAME("100005","δ��ͨ����Ϸ"),
	/**
	 * "100006","δ��ͨ����Ϸ"
	 */
	VALID_PAUSE_GAME("100006","����Ϸ����ͣ"),
	
	/**
	 * "200001","Ͷע������"
	 */
	INVEST_MONEY_LACK_CODE("200001","Ͷע������"),
	/**
	 * "200002","ע���ʽ����"
	 */
	STAKECODE_FORMAT_ERROR_CODE("200002","ע���ʽ����"),
	/**
	 * "200003","Ͷע���к��ظ�"
	 */
	INVEST_SEQ_DUPLICATE_CODE("200003","Ͷע���к��ظ�"),
	
	/**
	 * "200004","��Ч�淨����"
	 */
	INVALID_PLAYTYPE_CODE("200004","��Ч�淨����"),
	
	/**
	 * "200005","�淨�ڲ���ȷ"
	 */
	INVALID_PLAYTYPE_ISSUE("200005","�淨�ڲ���ȷ"),
	
	/**
	 * "200009", "�޺�"
	 */
	LIMIT_NUMBER("200009", "�޺�"),
	
	/**
	 * "200010", "�޴�Ͷע������"
	 */
	INVALID_BOOK_ORDER("200010", "�޴�Ͷע������"),
	
	/**
	 * "200020","��Ʊʧ��"
	 */
	 OUT_TICKET_FAIL("200020","��Ʊʧ��"),
	
	/**
	 * "200022","��δ��Ʊ"
	 */
	 NO_OUT_TICKET("200022","��δ��Ʊ"),
	
	/**
	 * "200023","Ͷע�ɹ�"
	 */
	INVEST_SUCCESS("200023","���ύ�ɹ�"),
	
	/**
	 * "200023","Ͷע�ɹ�"
	 */
	INVEST_FAIL("200024","���ύʧ��"),
	
	/**
	 * "200025","Ͷע�ɹ�"
	 */
	NOT_DRAWED("200025","δ����"),
	
	/**
	 * "200027","����һ������Ʊ��"
	 */
	EXCEED_ONE_ORDER_TICKETS("200027","����һ������Ʊ��"),
	
	/**
	 * "200090","��Ʊ���δ֪"
	 */
	UNKNOWN_BOOK_RESULT("200090","��Ʊ���δ֪"),
	
	/**
	 * "��������chipinresult"
	 */
	BJFC_CHIPIN_RET_SUCCESS("00","�ӵ��ɹ�"),
	
	
	/**
	 * "��������printresult"��ֻ��chipinresultʧ�ܵ�����£���������
	 */
	BJFC_PRINT_RET_NOT_BOOK("0","δ��Ʊ"),
	BJFC_PRINT_RET_IN_PROCESS("1","��Ʊ��"),
	BJFC_PRINT_RET_SUCCESS("2","��Ʊ�ɹ�"),
	BJFC_PRINT_RET_LIMIT_CODE("4","�޺�"),
	BJFC_PRINT_RET_BOOK_FAIL("7","��Ʊʧ��"),
	
	/**
	 * ���÷���������룬0-�ɹ���
	 */
	FEEDBACK_SUCCESS("00","�ɹ�"),
	
	/**
	 * 1-ʧ��
	 */
    FEEDBACKFAIL("99","ʧ��"),
	/**
	 * 2-������ֹͣ
	 */
   ISSUESTOP("2","������ֹͣ"),
	
   /**
    * δ����
    */
	NOT_OPEN_AWARD("200025","δ����");	
		
	private BjfcStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	private String code;

	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
