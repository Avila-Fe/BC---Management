package com.project.bullcare.service;

import com.project.bullcare.domain.Endereco;
import com.project.bullcare.domain.dto.FazendaDTO;
import com.project.bullcare.domain.dto.UsuarioDTO;
import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.EventoDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.UsuarioModel;
import com.project.bullcare.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.project.bullcare.util.Constantes.*;

@Service
public class ValidacaoService {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    RacaRepository racaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    TipoEventoRepository tipoEventoRepository;

    public List<String> validaDadosAnimal(AnimalDTO animalDTO){
        List<String> erros = new ArrayList<>();

        existeAnimal(animalDTO.getIdentificacao(), erros);
        existeRaca(animalDTO.getRaca(), erros);

        return erros;
    }
    public List<String> validaDadosEvento(EventoDTO eventoDTO){
        List<String> erros = new ArrayList<>();

        existeTipo(eventoDTO.getTipoEvento(), erros);
        existeData(eventoDTO.getDataEvento(), erros);
        existeDescricao(eventoDTO.getDescricao(), erros);

        return erros;
    }

    public List<String> validaDadosUsuario(UsuarioDTO usuarioDTO){
        List<String> erros = new ArrayList<>();

        existeUsuario(usuarioDTO.getCpf(), erros);
        validaNome(usuarioDTO.getNome(), erros);
        validaSobreNome(usuarioDTO.getSobreNome(), erros);
        validaCpf(usuarioDTO.getCpf(), erros);
        validaEndereco(usuarioDTO.getEndereco(), erros);
        validaEmail(usuarioDTO.getEmail(), erros);
        validaTelefone(usuarioDTO.getTelefone(), erros);
        validaSenha(usuarioDTO.getSenha(), erros);
        validaStatus(usuarioDTO.getStatus(), erros);
        validaTipoUsuario(usuarioDTO.getTipoUsuario(), erros);

        return erros;
    }

    public List<String> validaFazenda(FazendaDTO fazendaDTO){
        List<String> erros = new ArrayList<>();

        validaCpf(fazendaDTO.getCpfUsuario(), erros);
        validaNomeFazenda(fazendaDTO.getNomeFazenda(), erros);
        validaReferencia(fazendaDTO.getReferencia(), erros);
        validaArea(fazendaDTO.getArea(), erros);

        return erros;
    }

    public void existeAnimal(String identificacao, List<String> erro){
        AnimalModel animal = animalRepository.findByIdentificacao(identificacao);
        if (animal == null){
            erro.add(ANIMAL_EXISTENTE);
        }
    }

    public void existeRaca(String raca, List<String> erro){
        RacaModel racaModel = racaRepository.findByRaca(raca);
        if (racaModel == null){
            erro.add(RACA_NAO_ENCONTRADA);
        }
    }

    public void existeUsuario(String cpf, List<String> erro){
        UsuarioModel usuario = usuarioRepository.findByCpf(cpf);
        if (usuario != null){
            erro.add(USUARIO_EXISTENTE);
        }
    }

    public void existeTipo(String tipo, List<String> erro){
        if (tipo == null || tipo.isEmpty()){
            erro.add(TIPO_EVENTO_VAZIO);
        }
    }

    public void existeData(String data, List<String> erro){
        if (data == null || data.isEmpty()){
            erro.add(CAMPO_DATA_VAZIO);
        }
    }

    public void existeDescricao(String descricao, List<String> erro){
        if (descricao == null || descricao.isEmpty()){
            erro.add(CAMPO_DESCRICAO_VAZIO);
        }
    }

    public void validaNome(String nome, List<String> erro){
        if(isNullOrEmpty(nome)){
            erro.add(CAMPO_NOME_VAZIO);
        }
    }

    public void validaSobreNome(String sobreNome, List<String> erro){
        if(isNullOrEmpty(sobreNome)){
            erro.add(CAMPO_SOBRENOME_VAZIO);
        }
    }

    public void validaCpf(String cpf, List<String> erro){
        if(isNullOrEmpty(cpf)){
            erro.add(CAMPO_CPF_VAZIO);
        } else {
            String cpfNormalizado = cpf.replaceAll("[^0-9]", "");
            if(cpfNormalizado.length() != 11){
                erro.add(CPF_NORMA_PADRAO);
            }
        }
    }

    public void validaEndereco(Endereco endereco, List<String> erro){
        if(endereco == null){
            erro.add(CAMPO_ENDERECO_VAZIO);
        } else {
            if(isNullOrEmpty(endereco.getLogradouro())){
                erro.add(CAMPO_LOGRADOURO_VAZIO);
            }
            if(isNullOrEmpty(endereco.getNumero())){
                erro.add(CAMPO_NUMERO_VAZIO);
            }
            if(isNullOrEmpty(endereco.getBairro())){
                erro.add(CAMPO_BAIRRO_VAZIO);
            }
            if(isNullOrEmpty(endereco.getCidade())){
                erro.add(CAMPO_CIDADE_VAZIO);
            }
            if(isNullOrEmpty(endereco.getEstado())){
                erro.add(CAMPO_ESTADO_VAZIO);
            }
            if(isNullOrEmpty(endereco.getPais())){
                erro.add(CAMPO_PAIS_VAZIO);
            }
        }
    }

    public void validaEmail(String email, List<String> erro){
        if(isNullOrEmpty(email)){
            erro.add(CAMPO_EMAIL_VAZIO);
        } else {
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if(!matcher.matches()){
                erro.add(CAMPO_EMAIL_NORMA_PADRAO);
            }
        }
    }

    public void validaTelefone(String telefone, List<String> erro){
        if(isNullOrEmpty(telefone)){
            erro.add(CAMPO_TELEFONE_VAZIO);
        } else {
            String telefoneNormalizado = telefone.replaceAll("[^0-9]", "");
            if(telefoneNormalizado.length() != 11 && telefoneNormalizado.length() != 10){
                erro.add(CAMPO_TELEFONE_NORMA_PADRAO);
            }
        }
    }

    public void validaSenha(String senha, List<String> erro){
        if(isNullOrEmpty(senha)){
            erro.add(CAMPO_SENHA_VAZIO);
        } else {
            if(senha.length() < 6){
                erro.add(CAMPO_SENHA_PEQUENO);
            }
            String regex = "(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senha);
            if(!matcher.matches()){
                erro.add(CAMPO_SENHA_INVALIDO);
            }
        }
    }

    public void validaStatus(String status, List<String> erro){
        if(isNullOrEmpty(status)){
            erro.add(CAMPO_STATUS_VAZIO);
        }
    }

    public void validaTipoUsuario(String tipoUsuario, List<String> erro){
        if(isNullOrEmpty(tipoUsuario)){
            erro.add(CAMPO_TIPO_USUARIO_VAZIO);
        }
    }

    public void validaNomeFazenda(String nomeFazenda, List<String> erro){
        if(isNullOrEmpty(nomeFazenda)){
            erro.add(CAMPO_NOME_FAZENDA_VAZIO);
        }
    }

    public void validaReferencia(String referencia, List<String> erro){
        if(isNullOrEmpty(referencia)){
            erro.add(CAMPO_REFERENCIA_VAZIO);
        }
    }

    public void validaArea(String area, List<String> erro){
        if(isNullOrEmpty(area)){
            erro.add(CAMPO_AREA_VAZIO);
        } else {
            if(!area.matches("\\d+")){
                erro.add(CAMPO_AREA_INVALIDO);
            }
        }
    }

    public boolean isNullOrEmpty(String dado){
        if(dado == null || dado.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
