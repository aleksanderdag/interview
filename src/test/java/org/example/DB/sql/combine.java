package org.example.DB.sql;

import org.example.DB.H2DB;
import org.example.DB.Table;
import org.example.DB.TableEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class combine {
    static H2DB db;

    @BeforeAll
    public static void setup() throws SQLException {
        db = new H2DB();
    }

    public static Stream<Arguments> combine2() {
        return Stream.of(
                Arguments.of(
                        new Table("""
                                | firstName | lastName | city          | state    |
                                | --------- | -------- | ------------- | -------- |
                                | Allen     | Wang     | null          | null     |
                                | Bob       | Alice    | New York City | New York |
                                """),
                        new TableEntry[] {
                                new TableEntry("Person",
                                        new Table("""
                                | personId | lastName | firstName |
                                | -------- | -------- | --------- |
                                | 1        | Wang     | Allen     |
                                | 2        | Alice    | Bob       |
                                """)),
                                new TableEntry("Address",
                                        new Table("""
                                | addressId | personId | city          | state      |
                                | --------- | -------- | ------------- | ---------- |
                                | 1         | 2        | New York City | New York   |
                                | 2         | 3        | Leetcode      | California |
                                """))
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void combine2(Table expected, TableEntry... entrees) throws SQLException, IOException {
        db.persistTables(entrees);
        var table = db.runSql(Objects.requireNonNull(getClass().getResourceAsStream("Combine2.sql")));
        assertEquals(expected, table);
        System.out.println(table);
    }

    public static Stream<Arguments> bonus() {
        return Stream.of(
                Arguments.of(
                        new Table("""
                                | name | bonus |
                                +------+-------+
                                | Brad | null  |
                                | John | null  |
                                | Dan  | 500   |
                                """),
                        new TableEntry[] {
                                new TableEntry("Employee",
                                        new Table("""
                                | empId | name   | supervisor | salary |
                                | ----- | ------ | ---------- | ------ |
                                | 3     | Brad   | null       | 4000   |
                                | 1     | John   | 3          | 1000   |
                                | 2     | Dan    | 3          | 2000   |
                                | 4     | Thomas | 3          | 4000   |
                                """)),
                                new TableEntry("Bonus",
                                        new Table("""
                                | empId | bonus |
                                | ----- | ----- |
                                | 2     | 500   |
                                | 4     | 2000  |
                                """))
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void bonus(Table expected, TableEntry... entrees) throws SQLException, IOException {
        db.persistTables(entrees);
        var table = db.runSql(Objects.requireNonNull(getClass().getResourceAsStream("Bonus.sql")));
        assertEquals(expected, table);
        System.out.println(table);
    }
}
