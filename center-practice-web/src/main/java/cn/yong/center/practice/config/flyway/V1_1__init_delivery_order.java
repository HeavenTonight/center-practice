package cn.yong.center.practice.config.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

/**
 * @author Tiger-Li
 * @create 2020/5/19 14:01
 * @description
 */
public class V1_1__init_delivery_order extends BaseJavaMigration {

    /**
     * 表名
     */
    private static String TABLE_NAME = "delivery_order_";

    /**
     * sql
     */
    private static String EXECUTE_SQL = "CREATE TABLE TABLE_NAME (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
            "  `code` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '编码',\n" +
            "  `main_order_no` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '主订单号',\n" +
            "  `order_no` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '子订单号',\n" +
            "  `delivery_count` int(11) NOT NULL COMMENT '配送数量',\n" +
            "  `min_unit_count` int(11) NOT NULL COMMENT '最小单位数量',\n" +
            "  `receiver_name` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '收货人姓名',\n" +
            "  `receiver_mobile` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '收货人手机号',\n" +
            "  `receiver_addr` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '收货人地址',\n" +
            "  `delivery_date` date NOT NULL COMMENT '配送日期',\n" +
            "  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '配送状态(1-生成，2-确认，3-已停订，4-送达)',\n" +
            "  `milkman_no` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '送奶工编码',\n" +
            "  `milkman_name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '送奶工名字',\n" +
            "  `goods_name` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '商品名称',\n" +
            "  `goods_money` decimal(10,2) NOT NULL COMMENT '商品金额',\n" +
            "  `milk_station_no` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '奶站编码',\n" +
            "  `milk_station_name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '奶站名称',\n" +
            "  `delivery_way_code` tinyint(2) NOT NULL DEFAULT '0' COMMENT '配送时间类型（上午配，下午配）',\n" +
            "  `dr` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-是',\n" +
            "  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `created_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人',\n" +
            "  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
            "  `updated_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '更新人',\n" +
            "  `remark` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '备注',\n" +
            "  `goods_discount_money` decimal(10,6) DEFAULT '0.000000' COMMENT '优惠金额',\n" +
            "  `sku_id` bigint(20) NOT NULL COMMENT 'skuid',\n" +
            "  `sale_unit` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '销售单位',\n" +
            "  `sap_unit` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'SAP单位',\n" +
            "  `sku_code` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT 'sku编码',\n" +
            "  `community_name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '小区名称',\n" +
            "  `finished_time` timestamp NULL DEFAULT NULL COMMENT '配送完成时间',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单日计划';\n" +
            "\n";

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
