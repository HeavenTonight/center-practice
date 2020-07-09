package cn.yong.center.practice.utils;

import com.deepexi.util.StringUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: ogy
 */
public class SapUtils {

    //调拨单要货单
    private static final String SYS_NAME_GO_S01 = "GOS01";

    //调拨单类型
    private static final String ALLOCATION_TYPE = "B";

    //销售类型
    private static final String SALES_TYPE = "A";

    protected SapUtils() {
    }

    /**
     * 采购凭证编码补全
     * @param code 编码
     * @param len 长度
     * @return String
     */
    public static String purchasingDocuments(String code, int len){
        if (StringUtil.isNotEmpty(code) && len > 0) {
            StringBuilder codeBuilder = new StringBuilder(code);
            for (int i = 0; i < len-code.length(); i++) {
                codeBuilder.insert(0, "0");
            }
            code = codeBuilder.toString();
        }
        return code;
    }

    /**
     * 自营奶站调拨单传输编码规则
     * 系统名(5位)-B（为调拨单）+公司代码-库存地点编号-日期+序列号（序列号自编）
     * 一张订单一个单号，不能有重复编号，否则单据不能传输(注意序列号的生成)
     * @param companyCode 公司代码
     * @param inventoryCode 库存地点编号
     * @param serialNumber 序列号
     * @return String
     */
    public static String selfMilkStationTransmissionCode(String companyCode, String inventoryCode, String serialNumber){
        return SYS_NAME_GO_S01
                + ALLOCATION_TYPE
                + companyCode
                + inventoryCode
                + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                + serialNumber;
    }

    /**
     * 销售订单传输编码规则
     * 系统名(5位)-A（为销售单）+公司代码-送达方编号-日期+序列号（序列号自编）
     * 一张订单一个单号，不能有重复编号，否则单据不能传输(注意序列号的生成)
     * @param companyCode 公司代码
     * @param serviceCode 送达方编码
     * @param serialNumber 序列号
     * @return String
     */
    public static String salesTransmissionCode(String companyCode, String serviceCode, String serialNumber){
        return SYS_NAME_GO_S01
                + SALES_TYPE
                + companyCode
                + serviceCode
                + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                + serialNumber;
    }
}
