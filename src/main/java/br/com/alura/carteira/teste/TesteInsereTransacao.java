package br.com.alura.carteira.teste;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class TesteInsereTransacao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/carteira";
        String usuario = "root";
        String senha = "";
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            Transacao t = new Transacao(
                    "XPTO1",
                    LocalDate.of(2021, 7, 1),
                    new BigDecimal("100"),
                    100,
                    TipoTransacao.COMPRA);

            String sql = "insert into transacoes(ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, t.getTicker());
            ps.setBigDecimal(2, t.getPreco());
            ps.setInt(3, t.getQuantidade());
            ps.setDate(4, Date.valueOf(t.getData()));
            ps.setString(5, t.getTipo().toString());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no MySQL");
        }
    }
}
