package cn.yong.center.practice.config.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

/**
 * @author Tiger-Li
 * @create 2020/5/19 14:01
 * @description
 */
public class V1_3__init_delivery_detail extends BaseJavaMigration {

    /**
     * 表名
     */
    private static String TABLE_NAME = "delivery_detail_";

    /**
     * sql
     */
    private static String EXECUTE_SQL = "CREATE TABLE TABLE_NAME ( " +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id', " +
            "  `delivery_no` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配送单编号', " +
            "  `delivery_detail_no` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '配送明细编号', " +
            "  `should_sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '应送sku_id', " +
            "  `should_sku_code` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '应送sku_code', " +
            "  `should_goods_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '应送商品名称', " +
            "  `should_delivery_count` int(11) NOT NULL COMMENT '应该配送数量', " +
            "  `actual_sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '实际sku_id', " +
            "  `actual_sku_code` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '实际sku_code', " +
            "  `actual_goods_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '实际商品名称', " +
            "  `actual_delivery_count` int(11) NOT NULL COMMENT '实际配送数量', " +
            "  `unit` varchar(10) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '单位', " +
            "  `order_source` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单来源(0-鲜活go订单,1-订户宝订单,2-电商,3-征订,4-奶站,5-牛奶钱包,6-送奶工App)', " +
            "  `delivery_abnormal_reason` tinyint(1) DEFAULT NULL COMMENT '配送异常原因: 1换货 2缺货 3拒收 4拒收复送', " +
            "  `delivery_note` tinyint(1) DEFAULT NULL COMMENT '配送说明: 1公司原因 2质量问题 3运输损坏', " +
            "  `dr` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-是', " +
            "  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', " +
            "  `created_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人', " +
            "  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', " +
            "  `updated_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '更新人', " +
            "  `remark` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '备注', " +
            "  PRIMARY KEY (`id`) " +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='配送单明细'; ";

    @Override
    public void migrate(Context context) throws Exception {

        StringBuffer executeSql = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            String tableName = TABLE_NAME.concat(String.valueOf(i));
            executeSql.append(EXECUTE_SQL.replace("TABLE_NAME", tableName));
        }
        try (PreparedStatement statement =
                     context
                             .getConnection()
                             .prepareStatement(executeSql.toString())) {
            statement.execute();
        }
    }
}
