package hexlet.code.repository;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
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

    public static Optional<Url> findName(String name) throws SQLException {

        var sql = "SELECT * FROM urls WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                var id = resultSet.getLong("id");
                var created = resultSet.getTimestamp("created_at");
                var url = new Url(name);
                url.setCreatedAt(created.toLocalDateTime());
                url.setId(id);
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
        var sql = "SELECT id, name,(SELECT status_code FROM url_checks "
                + "WHERE url_checks.url_id = urls.id ORDER BY id DESC LIMIT 1) AS status_code,"
                + "(SELECT created_at FROM url_checks "
                + "WHERE url_checks.url_id = urls.id ORDER BY id DESC LIMIT 1) AS last FROM urls";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Url>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var statusCode = resultSet.getInt("status_code");
                var last = resultSet.getTimestamp("last");
                var url = new Url(name);
                if (statusCode != 0) {
                    UrlCheck urlCheck = new UrlCheck();
                    urlCheck.setUrlId(id);
                    urlCheck.setStatusCode(statusCode);
                    urlCheck.setCreatedAt(last.toLocalDateTime());
                    url.setLastCheck(urlCheck);
                }
                url.setId(id);
                result.add(url);
            }
            return result;
        }
    }
}
