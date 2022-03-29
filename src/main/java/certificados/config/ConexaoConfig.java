package certificados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class ConexaoConfig {

    @Bean
    public Connection obterConexao(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }
}
