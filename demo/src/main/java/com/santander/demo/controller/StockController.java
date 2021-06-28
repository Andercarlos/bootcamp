package com.santander.demo.controller;

import com.santander.demo.model.dto.StockDTO;
import com.santander.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
         return ResponseEntity.ok(service.save(dto));
}

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> lista = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine");
        dto.setPrice(100D);
        dto.setDate(LocalDate.now());
        dto.setVariation(10D);
        lista.add(dto);

    return ResponseEntity.ok(lista);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        List<StockDTO> lista = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine");
        dto.setPrice(100D);
        dto.setDate(LocalDate.now());
        dto.setVariation(10D);
        lista.add(dto);

        StockDTO dto1 = new StockDTO();
        dto1.setId(2L);
        dto1.setName("Kabum");
        dto1.setPrice(200D);
        dto1.setDate(LocalDate.now());
        dto1.setVariation(20D);
        lista.add(dto1);
        StockDTO selecionado = lista.stream().filter(x -> x.getId().compareTo(id)==0).findFirst().get();
        return ResponseEntity.ok(selecionado);
    }

}
