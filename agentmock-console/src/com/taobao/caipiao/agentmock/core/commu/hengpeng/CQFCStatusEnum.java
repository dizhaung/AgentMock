package com.taobao.caipiao.agentmock.core.commu.hengpeng;

public enum CQFCStatusEnum {

	/**
	 * "0000", "�ɹ�"
	 */
	CALL_SUCCESS_CODE("0000", "�ɹ�"),
	
	/**
	 * "1008","�淨������"
	 */
	CALL_PLAY_CODE("1008","�淨������"),
	/**
	 * "1009","���ڲ�����"
	 */
	CALL_ISSUE_CODE("1009","���ڲ�����"),
	/**
	 * "2011","��������ֵ��������Χ"
	 */
	CALL_SIMPLE_CODE("2011","��������ֵ��������Χ"),
	/**
	 * "2032", "�������빺��ע����������Χ"
	 */
	CALL_RESTRICT_CODE("2032", "�������빺��ע����������Χ"),
	/**
	 * "2040","Ʊ�����"
	 */
	CALL_TICK_CODE("2040","Ʊ�����"),
	/**
	 * "2043","��֧�ֵ�Ͷע��ʽ"
	 */
	CALL_SUPPORT_CODE("2043","��֧�ֵ�Ͷע��ʽ"),
	/**
	 * "2044","Ͷע�����ʽ����"
	 */
	CALL_FORMAT_CODE("2044","Ͷע�����ʽ����"),
	
	/**
	 * "2048","�ظ�ͶƱ"
	 */
	DUPLICATE_SALE_SUCCESS("2048","�ظ�ͶƱ"),
	
	/**
	 * "2052","Ͷע��"
	 * */
	IN_PROGRESS("2052","Ͷע��"),
	
	/**
	 * "9999","δ֪ʧ��ԭ��"
	 */
	CALL_FAILE_CODE("9999","δ֪ʧ��ԭ��");

	private CQFCStatusEnum(String code, String desc) {
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
