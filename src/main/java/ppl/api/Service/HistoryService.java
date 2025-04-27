package ppl.api.Service;

import ppl.api.Entity.History;

import java.util.List;

public interface HistoryService {
    History save(History history);

    List<History> findAll();
}
