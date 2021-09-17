package br.com.alura.carteira.teste;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class TesteSelectTransacao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/carteira";
        String usuario = "root";
        String senha = "";
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            String sql = "select * from transacoes";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transacao t = new Transacao();
                t.setTicker(rs.getString("ticker"));
                t.setData(rs.getDate("data").toLocalDate());
                t.setPreco(rs.getBigDecimal("preco"));
                t.setQuantidade(rs.getInt("quantidade"));
                t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));

                System.out.println(t);
                System.out.println("==========================================");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no MySQL");
        }
    }
}
