package com.laurenci.hydrotrack.service.record;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.Record;
import com.laurenci.hydrotrack.service.drink.system.DrinkMapper;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper(uses = {DrinkMapper.class})
public interface RecordMapper extends GeneralNewDtoMapper<NewRecordDto, EditRecordDto, Record> {
    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);

    @Override
    @Mapping(target = "id.userId", source = "newDto.userId")
    @Mapping(target = "id.drinkId", source = "newDto.drinkId")
    @Mapping(target = "drink.id", source = "newDto.drinkId")
    Record fromNewDtoToModel(NewRecordDto newDto);

    @Override
    @Mapping(target = "id.userId", source = "dto.userId")
    @Mapping(target = "id.drinkId", source = "dto.drinkId")
    @Mapping(target = "id.date", source = "dto.date")
    @Mapping(target = "drink.id", source = "dto.drinkId")
    Record fromDtoToModel(EditRecordDto dto);

    @Override
    @Mapping(target = "userId", source = "record.id.userId")
    @Mapping(target = "drinkId", source = "record.id.drinkId")
    @Mapping(target = "date", source = "record.id.date")
    EditRecordDto fromModelToDto(Record record);

    @Mapping(target = "userId", source = "record.id.userId")
    @Mapping(target = "drinkId", source = "record.id.drinkId")
    @Mapping(target = "date", source = "record.id.date")
    @Mapping(target = "drinkData.type", source = "record.drink.type")
    @Mapping(target = "drinkData.brand", source = "record.drink.brand")
    @Mapping(target = "drinkData.name", source = "record.drink.name")
    RecordDto fromModelToOutputDto(Record record);
}
