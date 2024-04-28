package com.project.bullcare.service;

import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.domain.dto.TipoEventoDTO;
import com.project.bullcare.mapper.TipoEventoMapper;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.TipoEventoModel;
import com.project.bullcare.repository.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;
import static com.project.bullcare.util.Constantes.CAMPOS_VAZIOS;

@Service
public class TipoEventoService {

    @Autowired
    TipoEventoRepository tipoEventoRepository;
    @Autowired
    TipoEventoMapper mapper;

    public ResponseDTO pesquisaTipoEvento() {
        List<TipoEventoModel> tipo = tipoEventoRepository.findAll();
        if (tipo != null) {
            return new ResponseDTO(CONCLUIDO, tipo.toString());
        }
        return new ResponseDTO(ERRO, TIPO_EVENTO_NAO_ENCONTRADO);
    }

    public ResponseDTO cadastraTipoEvento(TipoEventoDTO tipoEventoDTO) {
        if (tipoEventoDTO != null) {
            TipoEventoModel tipoEventoModel = mapper.parse(tipoEventoDTO);
            tipoEventoRepository.save(tipoEventoModel);
            return new ResponseDTO(CONCLUIDO, TIPO_EVENTO_ADICIONADO);
        }
        return new ResponseDTO(ERRO, TIPO_EVENTO_NAO_ADICIONADA, CAMPOS_VAZIOS);
    }
}
