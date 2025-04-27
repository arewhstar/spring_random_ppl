package ppl.api.Mappers;

import ppl.api.DTO.HistoryDTO;
import ppl.api.Entity.History;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HistoryMapper implements Mapper<History, HistoryDTO>{

    private ModelMapper modelMapper;

    public HistoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HistoryDTO mapTo(History history) {
        return modelMapper.map(history, HistoryDTO.class);
    }

    @Override
    public History mapFrom(HistoryDTO historyDTO) {
        return modelMapper.map(historyDTO, History.class);
    }
}
