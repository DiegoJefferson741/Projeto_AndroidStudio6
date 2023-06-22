package br.com.ifsudestemg.sistemapdvif.domain.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Paciente implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    public int id;

    @ColumnInfo(name = "NOME", defaultValue = "")
    public String nome;

    @ColumnInfo(name = "EMAIL", defaultValue = "")
    public String email;

    @ColumnInfo(name = "TELEFONE", defaultValue = "")
    public String telefone;

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
