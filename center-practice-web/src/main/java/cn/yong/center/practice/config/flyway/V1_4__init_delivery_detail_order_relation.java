package cn.yong.center.practice.config.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

/**
 * @author Tiger-Li
 * @create 2020/5/19 14:01
 * @description
 */
public class V1_4__init_delivery_detail_order_relation extends BaseJavaMigration {

    /**
     * 表名
     */
    private static String TABLE_NAME = "delivery_detail_order_relation_";

    /**
     * sql
     */
    private static String EXECUTE_SQL = "CREATE TABLE TABLE_NAME (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
            "  `delivery_no` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '配送单编号',\n" +
            "  `delivery_detail_no` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '配送明细编号',\n" +
            "  `delivery_order_no` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '配送日历编号',\n" +
            "  `dr` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-是',\n" +
            "  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `created_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人',\n" +
            "  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
            "  `updated_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '更新人',\n" +
            "  `remark` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '备注',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='配送单明细-配送单日历关系表';";

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
