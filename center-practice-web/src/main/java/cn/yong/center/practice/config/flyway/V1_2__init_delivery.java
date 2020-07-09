package cn.yong.center.practice.config.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

/**
 * @author Tiger-Li
 * @create 2020/5/19 14:01
 * @description
 */
public class V1_2__init_delivery extends BaseJavaMigration {

    /**
     * 表名
     */
    private static String TABLE_NAME = "delivery_";

    /**
     * sql
     */
    private static String EXECUTE_SQL =  "CREATE TABLE `TABLE_NAME` (\n"+
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n"+
            "  `delivery_no` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '配送单编号',\n"+
            "  `delivery_count` int(11) NOT NULL COMMENT '配送数量',\n"+
            "  `receiver_name` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '收货人姓名',\n"+
            "  `receiver_mobile` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '收货人手机号',\n"+
            "  `receiver_addr` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '收货人地址',\n"+
            "  `delivery_date` date NOT NULL COMMENT '配送日期',\n"+
            "  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '配送状态(配送状态(0-待分配，1-待配送，2-配送中，3-配送已完成，4-配送异常))',\n"+
            "  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '配送单类型(配送状态(0-普通配送单，1-临时配送单))',\n"+
            "  `export_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '导出状态(0-未导出 1-导出)',\n"+
            "  `milkman_no` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '送奶工编码',\n"+
            "  `milkman_name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '送奶工名字',\n"+
            "  `milk_station_no` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '奶站编码',\n"+
            "  `milk_station_name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '奶站名称',\n"+
            "  `community_name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '小区名称',\n"+
            "  `door_num` varchar(32) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '门牌号'\n"+
            "  `company_id` bigint(20) NOT NULL COMMENT '子公司ID',\n"+
            "  `delivery_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '配送时间类型（上午配，下午配）',\n"+
            "  `finished_time` timestamp NULL DEFAULT NULL COMMENT '配送完成时间',\n"+
            "  `dr` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-是',\n"+
            "  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n"+
            "  `created_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人',\n"+
            "  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',\n"+
            "  `updated_by` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '更新人',\n"+
            "  `remark` varchar(255) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '备注',\n"+
            "  PRIMARY KEY (`id`)\n"+
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='配送单';";


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
