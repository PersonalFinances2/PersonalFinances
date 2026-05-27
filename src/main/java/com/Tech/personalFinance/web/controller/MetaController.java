package com.Tech.personalFinance.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tech.personalFinance.domain.service.MetaService;
import com.Tech.personalFinance.persistence.entity.MetaEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/metas")
public class MetaController {
    private final MetaService metaService;

    public MetaController(MetaService metaService){
        this.metaService = metaService;
    }

    @GetMapping()
    public ResponseEntity<List<MetaEntity>> getAll() {
        return ResponseEntity.ok(this.metaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaEntity> getById(@PathVariable Integer id) {
        MetaEntity metaEntity = this.metaService.getById(id);

        if (metaEntity == null) 
            return ResponseEntity.notFound().build();
            
        return ResponseEntity.ok(metaEntity);
    }

    @PostMapping()
    public ResponseEntity<MetaEntity> add(@RequestBody MetaEntity metaEntity) {
        MetaEntity metaEntity2 = this.metaService.add(metaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaEntity2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaEntity> update(@PathVariable Integer id, @RequestBody MetaEntity metaEntity) {        
        return ResponseEntity.ok(this.metaService.update(id, metaEntity));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<MetaEntity> delete(@PathVariable Integer id){
        return ResponseEntity.ok(this.metaService.delete(id));
    }

}
