package controllers;

import models.Doador;
import repository.DoadorRepository;

import java.util.List;

public class DoadorController {
    private final DoadorRepository repository;

    public DoadorController() {
        this.repository = new DoadorRepository();
    }

    public void cadastrarDoador(Doador doador) {
        repository.salvar(doador);
    }

    public List<Doador> listarDoadores() {
        return repository.listar();
    }
}
