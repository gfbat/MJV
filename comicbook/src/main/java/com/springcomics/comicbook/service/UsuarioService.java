package com.springcomics.comicbook.service;

import com.springcomics.comicbook.exceptions.BusinessException;
import com.springcomics.comicbook.mapper.UsuarioMapper;
import com.springcomics.comicbook.model.Usuario;
import com.springcomics.comicbook.model.dto.UsuarioDTO;
import com.springcomics.comicbook.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO){
        Optional<Usuario> optUsuario = usuarioRepository.findByEmailAndCpf(usuarioDTO.getEmail(), usuarioDTO.getCpf());
        if(optUsuario.isPresent()){
            throw new BusinessException("Usuário já cadastrado");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return usuarioMapper.toDto(usuarioRepository.findAll());
    }
}
