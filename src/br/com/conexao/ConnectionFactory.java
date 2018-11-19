/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Felipe-Sistema
 */
public class ConnectionFactory {

    private static Connection conexao;

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/testedemesabd", "root", "");
    }

    public static void criarBd() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
            PreparedStatement statement = conexao.prepareStatement("CREATE SCHEMA IF NOT EXISTS `testedemesabd` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate();
            criarTeste();
            criarPergunta();
            criarAlternativa();
            criarUsuario();
            criarUsuario_pergunta();
            addInformacoes();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    private static void addInformacoes() throws Exception {
        addInfo("INSERT INTO `testedemesabd`.`usuario` (`nome`, `senha`, `admin`, `pontos`) VALUES ('admin', 'admin', '1', '0');");
        addInfo("INSERT INTO `testedemesabd`.`teste` (`nome`) VALUES ('java');");
        addInfo("INSERT INTO `testedemesabd`.`pergunta` (`descricao`, `nivel`, `teste_id`) VALUES ('>> 5 + 1;', '1', '1');");
        addInfo("INSERT INTO `testedemesabd`.`pergunta` (`descricao`, `nivel`, `teste_id`) VALUES ('>> 1 * 3;', '2', '1');");
        addInfo("INSERT INTO `testedemesabd`.`pergunta` (`descricao`, `nivel`, `teste_id`) VALUES ('var a = 4;\\r\\n>> a + 2;', '3', '1');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('5', '0', '1');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('4', '0', '1');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('6', '1', '1');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('3', '0', '1');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('3', '1', '2');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('1', '0', '2');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('2', '0', '2');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('6', '0', '2');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('2', '0', '3');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('4', '0', '3');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('6', '1', '3');");
        addInfo("INSERT INTO `testedemesabd`.`alternativa` (`descricao`, `verdadeiro`, `pergunta_id`) VALUES ('a2', '0', '3');");
    }

    private static void criarTeste() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`teste` (`id` INT(11) NOT NULL AUTO_INCREMENT, `nome` VARCHAR(45) NULL DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    
    private static void criarPergunta() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`pergunta` ("
                    + "  `id` INT(11) NOT NULL AUTO_INCREMENT,"
                    + "  `descricao` LONGTEXT NOT NULL,"
                    + "  `nivel` INT(11) NULL DEFAULT NULL,"
                    + "  `teste_id` INT(11) NOT NULL,"
                    + "  PRIMARY KEY (`id`),"
                    + "  CONSTRAINT `fk_pergunta_teste1`"
                    + "    FOREIGN KEY (`teste_id`)"
                    + "    REFERENCES `testedemesabd`.`teste` (`id`))"
                    + "AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }
    
    private static void criarPerguntaOld() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`pergunta` ("
                    + "  `id` INT(11) NOT NULL AUTO_INCREMENT,"
                    + "  `descricao` LONGTEXT NOT NULL,"
                    + "  `nivel` INT(11) NULL DEFAULT NULL,"
                    + "  `teste_id` INT(11) NOT NULL,"
                    + "  PRIMARY KEY (`id`),"
                    + "  CONSTRAINT `fk_pergunta_teste1`"
                    + "    FOREIGN KEY (`teste_id`)"
                    + "    REFERENCES `testedemesabd`.`teste` (`id`))"
                    + "AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    private static void criarAlternativa() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`alternativa` ("
                    + "  `id` INT(11) NOT NULL AUTO_INCREMENT,"
                    + "  `descricao` VARCHAR(100) NOT NULL,"
                    + "  `verdadeiro` TINYINT(4) NULL DEFAULT '0',"
                    + "  `pergunta_id` INT(11) NOT NULL,"
                    + "  PRIMARY KEY (`id`),"
                    + "  CONSTRAINT `fk_alternativas_pergunta1`"
                    + "    FOREIGN KEY (`pergunta_id`)"
                    + "    REFERENCES `testedemesabd`.`pergunta` (`id`))"
                    + "AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    private static void criarUsuario() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`usuario` ("
                    + "  `id` INT(11) NOT NULL AUTO_INCREMENT,"
                    + "  `nome` VARCHAR(45) NOT NULL,"
                    + "  `senha` VARCHAR(18) NOT NULL,"
                    + "  `admin` TINYINT(4) NULL DEFAULT '0',"
                    + "  `pontos` INT(11) NULL DEFAULT '0',"
                    + "  PRIMARY KEY (`id`))"
                    + "AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    private static void criarUsuario_pergunta() throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS `testedemesabd`.`usuario_pergunta` ("
                    + "  `id` INT(11) NOT NULL AUTO_INCREMENT,"
                    + "  `correto` TINYINT(4) NULL DEFAULT '0',"
                    + "  `dataResposta` DATETIME NULL DEFAULT NULL,"
                    + "  `usuario_id` INT(11) NOT NULL,"
                    + "  `pergunta_id` INT(11) NOT NULL,"
                    + "  PRIMARY KEY (`id`),"
                    + "  CONSTRAINT `fk_usuario_pergunta_pergunta1`"
                    + "    FOREIGN KEY (`pergunta_id`)"
                    + "    REFERENCES `testedemesabd`.`pergunta` (`id`),"
                    + "  CONSTRAINT `fk_usuario_pergunta_usuario`"
                    + "    FOREIGN KEY (`usuario_id`)"
                    + "    REFERENCES `testedemesabd`.`usuario` (`id`))"
                    + "AUTO_INCREMENT = 1 DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    private static void addInfo(String sql) throws Exception {
        try {
            conexao = getConnection();
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
    }
}
