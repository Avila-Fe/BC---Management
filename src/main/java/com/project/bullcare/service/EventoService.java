package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.EventoDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.EventoMapper;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.EventoModel;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.TipoEventoModel;
import com.project.bullcare.repository.EventoRepository;
import com.project.bullcare.repository.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    TipoEventoRepository tipoEventoRepository;
    @Autowired
    EventoMapper eventoMapper;
    @Autowired
    ValidacaoService validacaoService;

    public ResponseDTO pesquisaEvento(String tipo) {
        if (tipo != null) {
            TipoEventoModel tipoEvento =  new TipoEventoModel(tipo);
            EventoModel evento = eventoRepository.findByTipoEvento(tipoEvento);
            return new ResponseDTO(CONCLUIDO, evento);
        }
        return new ResponseDTO(ERRO, EVENTO_NAO_ENCONTRADO, CAMPO_TIPO_EVENTO_VAZIO);
    }

    public ResponseDTO cadastraEvento(EventoDTO eventoDTO) {
        List<String> erros = validacaoService.validaDadosEvento(eventoDTO);
        if (!erros.isEmpty()){

            TipoEventoModel racaModel = tipoEventoRepository.findByTipo(eventoDTO.getTipoEvento());
            EventoModel eventoModel = eventoMapper.parse(eventoDTO, racaModel);
            eventoRepository.save(eventoModel);

            return new ResponseDTO(CONCLUIDO, EVENTO_ADICIONADO);
        }
        return new ResponseDTO(ERRO, ERRO_VALIDACAO, erros);
    }
}
