package com.springcomics.comicbook.mapper;

import com.springcomics.comicbook.model.Usuario;
import com.springcomics.comicbook.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataNasc(usuarioDTO.getDataNasc());
        return usuario;
    }

    public UsuarioDTO toDto (Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setDataNasc(usuario.getDataNasc());
        return usuarioDTO;
    }

    public List<UsuarioDTO> toDto(List<Usuario> listaUsuarios){
        return listaUsuarios.stream().map(this::toDto).collect(Collectors.toList());
    }
}
