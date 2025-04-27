package ppl.api.Repository;

import ppl.api.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}