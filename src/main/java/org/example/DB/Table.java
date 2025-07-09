package org.example.DB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class Table {
    List<String> headers = new ArrayList<>();
    List<List<String>> rows = new ArrayList<>();

    public Table(String str) {
        var rawRows = str.split("\\n");
        headers = toArray(rawRows[0]);
        for (int i = 2; i < rawRows.length; i++) {
            rows.add(toArray(rawRows[i]));
        }
    }

    private List<String> toArray(String rowStr) {
        return Arrays.stream(rowStr.trim().split("\\s*\\|\\s*"))
                .filter(s -> !s.isEmpty())
                .map(s -> "null".equals(s) ? null : s)
                .toList();
    }

    public Table(ResultSet res) throws SQLException {
        var meta = res.getMetaData();
        int columnCount = meta.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            headers.add(meta.getColumnLabel(i));
        }

        while (res.next()) {
            var row = new ArrayList<String>();
            for (int i = 1; i <= columnCount; i++) {
                String val = res.getString(i);
//                if(Objects.equals(val, "null")) val = null;
                row.add(val);
            }
            rows.add(row);
        }
    }

    public void insert(String... elements) throws SQLException {
//        Arrays.stream(elements).map();
//        stmt.execute("INSERT INTO Employees VALUES (1, 'Alice', 70000);");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        System.out.println(rows);
        System.out.println(table.rows);
        return Objects.equals(rows, table.rows);
    }

    // TODO: add ---- to 2nd line
    @Override
    public String toString() {
        var columnLen = new int[headers.size()];

        // count the longest row
        for (int i = 0; i < headers.size(); i++) {
            var item = headers.get(i);
            columnLen[i] = Math.max(columnLen[i], item.length());
        }

        // count the longest row
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).size(); j++) {
                var item = rows.get(i).get(j);
                var itemLen = item != null ? item.length() : 4;
                columnLen[j] = Math.max(columnLen[j], itemLen);
            }
        }

        StringBuilder sb = new StringBuilder();

        // print headers
        for (int i = 0; i < headers.size(); i++) {
            sb.append("| ");
            var header = headers.get(i).toLowerCase();
            sb.append(header);
            int l = header.length();
            while (l++ < columnLen[i]) sb.append(" ");
            sb.append(" ");
        }
        sb.append("|");
        sb.append("\n");

        // add dash line
        for (var len : columnLen) {
            sb.append("| ");
            while (len-- > 0) sb.append("-");
            sb.append(" ");
        }
        sb.append("|");

        // print rows
        for (int i = 0; i < rows.size(); i++) {
            sb.append("\n");
            for (int j = 0; j < rows.get(i).size(); j++) {
                sb.append("| ");
                var item = rows.get(i).get(j);
                var word = item != null ? item : "null";
                sb.append(word);
                int l = word.length();
                while (l++ < columnLen[j]) sb.append(" ");
                sb.append(" ");
            }
            sb.append("|");
        }

        return sb.toString();
    }
}
