import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class HikariDataSourceConfiguration {

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    @ConfigurationProperties(Prefix ="custom.application.hikari.datasource")
    public Datasource customDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .userName(userId)
                .password(userPassword)
                .build();
    }
}