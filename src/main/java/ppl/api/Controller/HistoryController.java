package ppl.api.Controller;


import org.springframework.web.bind.annotation.*;
import ppl.api.DTO.HistoryDTO;
import ppl.api.Entity.History;
import ppl.api.Mappers.Mapper;
import ppl.api.Service.impl.HistoryServiceImpl;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping
public class HistoryController {


    private final HistoryServiceImpl historyServiceImpl;
    private final Mapper<History, HistoryDTO> historyMapper;


    public HistoryController(HistoryServiceImpl historyServiceImpl,Mapper<History, HistoryDTO> historyMapper) {
        this.historyServiceImpl = historyServiceImpl;
        this.historyMapper = historyMapper;

    }



    @GetMapping(path = "/history")
    public List<HistoryDTO> listHistory() {
        List<History> history = historyServiceImpl.findAll();
        return history.stream()
                .map(historyMapper::mapTo)
                .collect(Collectors.toList());
    }
}