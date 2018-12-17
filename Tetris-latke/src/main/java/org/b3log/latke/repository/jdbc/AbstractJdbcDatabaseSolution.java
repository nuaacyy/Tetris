/*
 * Copyright (c) 2009-2017, b3log.org & hacpai.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.repository.jdbc;

import org.b3log.latke.repository.jdbc.mapping.Mapping;
import org.b3log.latke.repository.jdbc.util.Connections;
import org.b3log.latke.repository.jdbc.util.FieldDefinition;
import org.b3log.latke.repository.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract JDBC database solution.
 *
 * @author <a href="mailto:wmainlove@gmail.com">Love Yao</a>
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.2, Oct 16, 2017
 */
public abstract class AbstractJdbcDatabaseSolution implements JdbcDatabase {

    /**
     * the map Mapping type to real database type.
     */
    private Map<String, Mapping> jdbcTypeMapping = new HashMap<>();

    /**
     * register type to mapping solution.
     *
     * @param type    type from json
     * @param mapping {@link Mapping}
     */
    public void registerType(final String type, final Mapping mapping) {
        jdbcTypeMapping.put(type, mapping);
    }

    @Override
    public boolean createTable(final String tableName, final List<FieldDefinition> fieldDefinitions) throws SQLException {
        final Connection connection = Connections.getConnection();

        try {
            final StringBuilder createTableSql = new StringBuilder();
            createTableHead(createTableSql, tableName);
            createTableBody(createTableSql, fieldDefinitions);
            createTableEnd(createTableSql);

            return JdbcUtil.executeSql(createTableSql.toString(), connection);
        } catch (final SQLException e) {
            throw e;
        } finally {
            connection.close();
        }
    }

    /**
     * abstract createTableHead for each DB to impl.
     *
     * @param dropTableSql dropTableSql
     * @param tableName    table name
     */
    protected abstract void createDropTableSql(final StringBuilder dropTableSql, final String tableName);

    /**
     * abstract createTableHead for each DB to impl.
     *
     * @param createTableSql createSql
     * @param tableName      table name
     */
    protected abstract void createTableHead(final StringBuilder createTableSql, final String tableName);

    /**
     * abstract createTableBody for each DB to impl.
     *
     * @param createTableSql   createSql
     * @param fieldDefinitions {@link FieldDefinition}
     */
    protected abstract void createTableBody(final StringBuilder createTableSql, final List<FieldDefinition> fieldDefinitions);

    /**
     * abstract createTableEnd for each DB to impl.
     *
     * @param createTableSql createSql
     */
    protected abstract void createTableEnd(StringBuilder createTableSql);

    @Override
    public boolean clearTable(final String tableName, final boolean ifdrop) throws SQLException {
        final Connection connection = Connections.getConnection();

        try {
            final StringBuilder clearTableSql = new StringBuilder();
            clearTableSql(clearTableSql, tableName, ifdrop);

            return JdbcUtil.executeSql(clearTableSql.toString(), connection);
        } catch (final SQLException e) {
            throw e;
        } finally {
            connection.close();
        }
    }

    /**
     * the clearTableSql for each Db to impl.
     *
     * @param clearTableSql clearTableSql
     * @param tableName     tableName
     * @param ifdrop        ifdrop
     */
    public abstract void clearTableSql(final StringBuilder clearTableSql, final String tableName, final boolean ifdrop);

    /**
     * @return jdbcTypeMapping
     */
    public Map<String, Mapping> getJdbcTypeMapping() {
        return jdbcTypeMapping;
    }
}
