package com.Tech.personalFinance.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.TipoDocumentoDto;
import com.Tech.personalFinance.domain.repository.ITipoDocumentoRepository;

@Service
public class TipoDocumentoService {
    private final ITipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(ITipoDocumentoRepository tipoDocumentoRepository){
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public List<TipoDocumentoDto> getAll(){
        return this.tipoDocumentoRepository.getAll();
    }

}
