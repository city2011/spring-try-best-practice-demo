package demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages={"demo.mapper"}, sqlSessionFactoryRef="db1SessionFactory")
public class DbConfiguration {
    @Value("${datasource.jdbc.driverClassName}")
    private String dbDriver;

    @Value("${datasource.jdbc.url}")
    private String dbUrl;

    @Value("${datasource.jdbc.username}")
    private String dbUsername;

    @Value("${datasource.jdbc.password}")
    private String dbPassword;

    @Bean(name = "hcDataSource")
    @Primary
    public DataSource hcDataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbUrl+"?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&allowMultiQueries=true");
        dataSource.setPassword(dbPassword);
        dataSource.setUsername(dbUsername);
        dataSource.setDriverClassName(dbDriver);

        dataSource.setFilters("stat,wall");

        dataSource.setMaxActive(300);
        dataSource.setInitialSize(1);
        dataSource.setMaxWait(60000);
        dataSource.setMinIdle(30);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(-1);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(hcDataSource());
    }

    @Bean(name = "db1SessionFactory")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("hcDataSource") DataSource dataSource) {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sessionFactory;
    }
}
