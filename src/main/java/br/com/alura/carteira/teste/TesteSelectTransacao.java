package br.com.alura.carteira.teste;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class TesteSelectTransacao {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/carteira";
            String usuario = "root";
            String senha = "";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            TransacaoDao dao = new TransacaoDao(conexao);
            List<Transacao> transacaos = dao.listar();

            transacaos.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro!");
        }
    }
}
