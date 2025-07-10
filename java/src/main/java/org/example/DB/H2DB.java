package org.example.DB;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DB {
    Connection conn;
    public Statement stmt;

    public H2DB() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        stmt = conn.createStatement();
    }

    public void createTable(String name, Table table) throws SQLException {
        // CREATE TABLE name(item1 VARCHAR, item2 VARCHAR, item3 VARCHAR) // INT?
        var columns = table.headers;
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(name).append("(");
        int i = 0;
        for(; i < columns.size() - 1; i++) {
            sb.append(columns.get(i)).append(" VARCHAR, ");
        }
        sb.append(columns.get(i));
        sb.append(" VARCHAR);");
        System.out.println(sb);
        stmt.execute(sb.toString());
        for (var row : table.rows) {
            insert(name, row.toArray(new String[0]));
        }
    }

    public void insert(String tableName, String... elements) throws SQLException {
        // INSERT INTO Employees VALUES (1, 'Alice', 70000);
        var values = String.join("', '", elements);
        var sql = "INSERT INTO "+tableName+" VALUES ('"+values+"');";
        System.out.println(sql);
        stmt.execute(sql);
    }

    public Table runSql(InputStream in) throws IOException, SQLException {
        var res = stmt.executeQuery(new String(in.readAllBytes(), StandardCharsets.UTF_8));
        return new Table(res);
    }

    public void persistTables(TableEntry... entrees) throws SQLException {
        for (var entree : entrees) createTable(entree.name(), entree.table());
    }
}
