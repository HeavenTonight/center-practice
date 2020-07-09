package cn.yong.center.practice.config.flyway;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

/**
 * @author Tiger-Li
 * @create 2020/5/19 14:01
 * @description
 */
public class V1_5__init_delivery_order_alter_add extends BaseJavaMigration {

    /**
     * 表名
     */
    private static String TABLE_NAME = "delivery_order_";

    /**
     * sql
     */
    private static String EXECUTE_SQL = "  ALTER TABLE TABLE_NAME add door_num varchar(32) NOT NULL DEFAULT '' COMMENT '门牌号';\n";
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
