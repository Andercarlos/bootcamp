package com.santander.demo.service;

import com.santander.demo.exceptions.BusinessException;
import com.santander.demo.exceptions.NotFoundException;
import com.santander.demo.mapper.StockMapper;
import com.santander.demo.model.Stock;
import com.santander.demo.model.dto.StockDTO;
import com.santander.demo.repository.StockRepository;
import com.santander.demo.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {



    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
    Optional<Stock> optionaStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
    if (optionaStock.isPresent()){
        throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
    }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionaStock = repository.FindByStockUpate(dto.getName(),dto.getDate(),dto.getId());
        if (optionaStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDto(list);
    }
    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(id);
        return dto;
        }
}


