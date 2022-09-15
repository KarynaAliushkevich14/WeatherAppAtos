package myweather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan("myCrud")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
//
//        private final ApplicationContext applicationContext;
//
//        @Autowired
//        public SpringConfig(ApplicationContext applicationContext) {
//            this.applicationContext = applicationContext;
//        }
//
//        @Bean
//        public SpringResourceTemplateResolver templateResolver() {
//            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//            templateResolver.setApplicationContext(applicationContext);
//            templateResolver.setPrefix("/WEB-INF/views/");
//            templateResolver.setSuffix(".html");
//            return templateResolver;
//        }
//
//        @Bean
//        public SpringTemplateEngine templateEngine() {
//            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//            templateEngine.setTemplateResolver(templateResolver());
//            templateEngine.setEnableSpringELCompiler(true);
//            return templateEngine;
//        }
//
//        @Override
//        public void configureViewResolvers(ViewResolverRegistry registry) {
//            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//            resolver.setTemplateEngine(templateEngine());
//            registry.viewResolver(resolver);
//        }

        //Bean JDBC Template
        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();

            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/city");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

            return dataSource;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }
    }
