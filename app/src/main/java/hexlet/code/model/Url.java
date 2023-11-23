package hexlet.code.model;

import hexlet.code.repository.UrlCheckRepository;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public final class Url {
    private Long id;
    private String name;
    private Timestamp createdAt;

    public Url(String name, Timestamp createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public UrlCheck getLastCheck() {
        List<UrlCheck> checks;
        try {
            checks = UrlCheckRepository.getUrlChecks(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checks.isEmpty() ? null : checks.get(checks.size() - 1);
    }

    public String getCreatedAtToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(createdAt.toLocalDateTime());
    }
}
