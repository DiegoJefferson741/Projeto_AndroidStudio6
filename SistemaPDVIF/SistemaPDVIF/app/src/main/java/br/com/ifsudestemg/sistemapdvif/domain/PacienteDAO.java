package br.com.ifsudestemg.sistemapdvif.domain;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import br.com.ifsudestemg.sistemapdvif.domain.entities.Paciente;

@Dao
public interface PacienteDAO extends BaseDAO<Paciente>{

    @Query("SELECT * FROM paciente")
    public List<Paciente> buscarTodos();

}
