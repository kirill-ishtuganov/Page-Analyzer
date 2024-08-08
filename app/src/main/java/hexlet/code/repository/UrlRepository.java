package hexlet.code.repository;

import hexlet.code.model.Url;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UrlRepository extends BaseRepository {

    public static void save(Url url) throws SQLException {
        var sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, url.getName());
            var createdAt = LocalDateTime.now();
            preparedStatement.setTimestamp(2, Timestamp.valueOf(createdAt));

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
                url.setCreatedAt(createdAt);

            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Url find(Long id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (var resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    var name = resultSet.getString("name");
                    var createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                    var url = new Url(name);
                    url.setId(id);
                    url.setCreatedAt(createdAt);
                    return url;
                }
            }
        }
        return null;
    }

    public static Optional<Url> search(String term) throws SQLException {

        var sql = "SELECT * FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, term);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getLong("id");
                var createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                var url = new Url(term);
                url.setId(id);
                url.setCreatedAt(createdAt);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static boolean existsByName(String name) throws SQLException {
        String sql = "SELECT COUNT(*) FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (var resultSet = stmt.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) > 0;
            }
        }
    }

    public static List<Url> getEntities() throws SQLException {
        var sql = "SELECT * FROM urls";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Url>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                var url = new Url(name);
                url.setId(id);
                url.setCreatedAt(createdAt);
                result.add(url);
            }
            return result;
        }
    }
}
