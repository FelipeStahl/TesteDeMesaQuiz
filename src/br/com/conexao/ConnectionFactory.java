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
        addInfo("INSERT INTO `pergunta` VALUES (1,'>> 5 + 1;',1,1),(2,'>> 1 * 3;',2,1),(3,'var a = 4;\\r\\n>> a + 2;',3,1),(4,'var a = 2;\\r\\nvar b = 4;\\r\\n>> a + b;',4,1),(5,'var a = \\'uk\\';\\r\\nvar b = \\'qx\\';\\r\\n>> a + b;',5,1),(6,'var a = \\'me\\';\\r\\nvar b = \\'it\\';\\r\\n>>a + b;',6,1),(7,'var a = \\'vd\\';\\r\\nvar b = \\'70\\';\\r\\na + b;',7,1),(8,'var a = \\'qrq\\';\\r\\nvar b = \\'p13\\';\\r\\n>>a + b;',8,1),(9,'var a = \\'0\\';\\r\\nvar b = \\'2\\';\\r\\n>>a + b;',9,1),(10,'var a = \\'2\\';\\r\\nvar b = \\'0\\';\\r\\na + b;',10,1),(11,'var a = 2;\\r\\nvar b = 4;\\r\\n>>a + b;',11,1),(12,'var a = \\'0\\';\\r\\nvar b = \\'4\\';\\r\\n>>a + b;',12,1);");
        addInfo("INSERT INTO `alternativa` VALUES (1,'5',0,1),(2,'4',0,1),(3,'6',1,1),(4,'3',0,1),(5,'3',1,2),(6,'1',0,2),(7,'2',0,2),(8,'6',0,2),(9,'2',0,3),(10,'4',0,3),(11,'6',1,3),(12,'a2',0,3),(13,'ab',0,4),(14,'6',1,4),(15,'4',0,4),(16,'2',0,4),(17,'uk',0,5),(18,'qx',0,5),(19,'ukqx',1,5),(20,'ab',0,5),(21,'meit',1,6),(22,'it',0,6),(23,'me',0,6),(24,'a',0,6),(25,'vd',0,7),(26,'70',0,7),(27,'a',0,7),(28,'vd70',1,7),(29,'qrqp13',1,8),(30,'qrq',0,8),(31,'\\\"\\\"\\\"',0,8),(32,'a+b',0,8),(33,'02',1,9),(34,'0',0,9),(35,'2',0,9),(36,'1',0,9),(37,'02',0,10),(38,'2',0,10),(39,'0',0,10),(40,'20',1,10),(41,'1',0,11),(42,'6',1,11),(43,'4',0,11),(44,'24',0,11),(45,'04',1,12),(46,'4',0,12),(47,'0',0,12),(48,'40',0,12);");
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
