package ppl.api.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppl.api.Entity.History;
import ppl.api.Repository.HistoryRepository;
import ppl.api.Service.HistoryService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History save(History authorEntity) {
        return historyRepository.save(authorEntity);
    }

    @Override
    public List<History> findAll() {
        return StreamSupport.stream(historyRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
