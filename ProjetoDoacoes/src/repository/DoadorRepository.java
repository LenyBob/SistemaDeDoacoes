package repository;

import config.DbConnection;
import models.Doador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorRepository {
    public void salvar(Doador doador) {
        String sql = "INSERT INTO doadores (nome, tipo_sanguineo, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getTipoSanguineo());
            stmt.setString(3, doador.getDataNascimento());
            stmt.setString(4, doador.getTelefone());
            stmt.setString(5, doador.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar doador: " + e.getMessage());
        }
    }

    public List<Doador> listar() {
        List<Doador> doadores = new ArrayList<>();
        String sql = "SELECT * FROM doadores";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doador doador = new Doador();
                doador.setId(rs.getInt("id"));
                doador.setNome(rs.getString("nome"));
                doador.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                doador.setDataNascimento(rs.getString("data_nascimento"));
                doador.setTelefone(rs.getString("telefone"));
                doador.setEmail(rs.getString("email"));
                doadores.add(doador);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar doadores: " + e.getMessage());
        }

        return doadores;
    }
}
