package org.springaop.groovy;

public class Hui {
	public static void main(String args[]) {
		StringBuilder sql = new StringBuilder("SELECT");
		sql.append(" BX.ORDER_NO AS BXCODE,mt.MAINTAIN_NO,mt.MY_PAY_MONEY,BX.Check_Time AS GMT_REPAIR_FINISH,cf.LESSEECONTRACTCODE,sf.CONTRACTCODE,sf.ID AS WTID,cf.ID AS CZID,")
		   .append(" cf.ROOMID,CASE WHEN  PERD.TOTAL IS NULL THEN 1 WHEN PERD.TOTAL < 1 THEN 1 WHEN SF.CONTRACTCODE <> BX.CONTRACT_NO THEN 1 ELSE 2 END AS RENTTYPE")
		   .append(" FROM WIWJ_MAINTAIN_ORDERS mt")
		   .append(" LEFT JOIN WIWJ_REPAIR_ORDERS bx ON mt.REPAIR_ORDER_NO = bx.ORDER_NO")
		   .append(" LEFT JOIN wk_cf_contract cf ON ((cf.LESSEECONTRACTCODE=BX.CONTRACT_NO AND (BX.REPAIR_VERSION != 'V2.0' OR BX.REPAIR_VERSION IS NULL)) OR (cf.LESSEECONTRACTCODE = BX.CF_CONTRACT_NO AND BX.REPAIR_VERSION = 'V2.0'))")
		   .append(" LEFT JOIN wk_sf_contract sf ON BX.SF_CONTACT_ID = sf.ID")
		   .append(" LEFT JOIN (SELECT CONTRACT_ID, COUNT(DISTINCT ROOM_ID) AS TOTAL FROM WIWJ_SF_ROOM_PERIOD_PRICE WHERE IS_EFFECTIVE = 'Y' GROUP BY CONTRACT_ID ) PERD ON PERD.CONTRACT_ID = SF.ID")
		   .append(" WHERE mt.CHECK_STATE = ?")
		   .append(" AND sf.contract_type<>'PARK'")
		   .append(" AND mt.MY_PAY_MONEY > ? AND BX.CHECK_STATUS ='1000200460009'")
		   //.append(" AND SF.ID = (SELECT ID FROM WK_SF_CONTRACT WHERE CONTRACTCODE = 'AFWT0000869')")// 测试数据，后期删除
		   ;
		
		System.out.println(sql.toString());
	}
}
