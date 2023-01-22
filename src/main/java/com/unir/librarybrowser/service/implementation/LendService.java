package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.LendDto;
import com.unir.librarybrowser.domain.entity.LendEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.repository.LendRepository;
import com.unir.librarybrowser.service.Lend;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LendService implements Lend {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LendRepository lendRepository;


    @Override
    public List<LendDto> getAll() throws GenericException {

        List<LendDto> lends = new ArrayList<>();
        try {
            List<LendEntity> entityLends = lendRepository.findAll();
            lends = modelMapper.map(entityLends, new TypeToken<List<LendDto>>() {
            }.getType());
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
        return lends;
    }

    @Override
    public LendDto getById(long id) {
        Optional<LendEntity> lendOpt = lendRepository.findById(id);
        if (lendOpt.isPresent()) {
            LendDto lend = modelMapper.map(lendOpt.get(), LendDto.class);
            return lend;
        }
        return null;
    }
}
