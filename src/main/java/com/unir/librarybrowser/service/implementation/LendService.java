package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.LendDto;
import com.unir.librarybrowser.domain.entity.BookEntity;
import com.unir.librarybrowser.domain.entity.LendEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.LendRepository;
import com.unir.librarybrowser.service.Lend;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LendService implements Lend {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LendRepository lendRepository;

    @Value("${exception.lend.not_found_all}")
    private String lendNotFoundAll;

    @Value("${exception.lend.not_found}")
    private String lendNotFound;

    @Override
    public List<LendDto> getAll() throws GenericException {
        List<LendDto> lends = new ArrayList<>();
        try {
            List<LendEntity> entityLends = lendRepository.findAll();
            if (entityLends == null || entityLends.isEmpty()) {
                throw new NotFoundException(lendNotFoundAll);
            }
            lends = modelMapper.map(entityLends, new TypeToken<List<LendDto>>() {
            }.getType());
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
        return lends;
    }

    @Override
    public LendDto getById(long id) throws GenericException,NotFoundException {
        LendDto lendDto;
        try {
            Optional<LendEntity> lendEntity = lendRepository.findById(id);
            if (lendEntity.isEmpty()) {
                throw new NotFoundException(MessageFormat.format(lendNotFound, id));
            }
            lendDto = modelMapper.map(lendEntity.get(), LendDto.class);
        } catch (RuntimeException e) {
            throw new GenericException(e.getMessage());
        }
        return lendDto;
    }
}
