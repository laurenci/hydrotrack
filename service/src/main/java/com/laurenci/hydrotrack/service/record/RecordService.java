package com.laurenci.hydrotrack.service.record;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrinkRepository;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;
import com.laurenci.hydrotrack.core.record.Record;
import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.core.record.RecordRepository;

@AllArgsConstructor
public class RecordService {
    private final RecordRepository repository;

    private final DrinkRepository drinkRepository;
    private final CustomDrinkRepository customDrinkRepository;

    public RecordDto addNewRecord(NewRecordDto newRecord) {
        return RecordMapper.INSTANCE.fromModelToOutputDto(
                addDrinkData(repository.create(RecordMapper.INSTANCE.fromNewDtoToModel(newRecord)))
        );
    }

    public RecordDto getRecordById(RecordId id) {
        return RecordMapper.INSTANCE.fromModelToOutputDto(addDrinkData(repository.readById(id)));
    }

    public List<RecordDto> getRecordsByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(this::addDrinkData)
                .map(RecordMapper.INSTANCE::fromModelToOutputDto)
                .toList();
    }

    public List<RecordDto> getRecordsByUserIdAndDateRange(Long userId, LocalDateTime from, LocalDateTime to) {
        return repository.findByUserIdAndDateRange(userId, from, to).stream()
                .map(this::addDrinkData)
                .map(RecordMapper.INSTANCE::fromModelToOutputDto)
                .toList();
    }

    public void deleteRecordById(RecordId recordId) {
        repository.deleteById(recordId);
    }

    private Record addDrinkData(Record record) {
        var drinkId = record.getId().getDrinkId();
        var drink = switch (record.getArea()) {
            case SYSTEM -> drinkRepository.readById(drinkId);
            case CUSTOM -> customDrinkRepository.readById(drinkId);
        };
        record.setDrink(drink);
        return record;
    }
}
