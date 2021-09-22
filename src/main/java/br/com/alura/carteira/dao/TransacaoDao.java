package br.com.alura.carteira.dao;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

    private Connection conexao;

    public TransacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Transacao transacao) {
        try {
            String sql = "insert into transacoes(ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, transacao.getTicker());
            ps.setBigDecimal(2, transacao.getPreco());
            ps.setInt(3, transacao.getQuantidade());
            ps.setDate(4, Date.valueOf(transacao.getData()));
            ps.setString(5, transacao.getTipo().toString());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Transacao> listar() {
        try {
            String sql = "select * from transacoes";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Transacao> transacaos = new ArrayList<>();

            while (rs.next()) {
                Transacao t = new Transacao();

                t.setTicker(rs.getString("ticker"));
                t.setData(rs.getDate("data").toLocalDate());
                t.setPreco(rs.getBigDecimal("preco"));
                t.setQuantidade(rs.getInt("quantidade"));
                t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));

                transacaos.add(t);
            }
            return transacaos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
