package start;

//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory",
//        basePackages = {"org.sun.resorts.holidays.data.repository.jpa"})
//@PropertySource("application.properties")
public class configuracionDataBase {

//    @Value("${database.url}")
//    private String databaseUrl;
//
//    @Value("${database.username}")
//    private String username;
//
//    @Value("${database.password}")
//    private String password;
//
//    @Value("${database.driverClassName}")
//    private String driverClassName;
//
//    @Value("${database.databasePlatform}")
//    private String dialect;
//    
//    @Value("${database.database}")
//    private String dataBase;
//    
//    @Value("${database.showSql}")
//    private String showSQL;
//    
//    @Value("${database.generateDdl}")
//    private String generarDDL;
//
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(databaseUrl, username, password);
//        dataSource.setDriverClassName(driverClassName);
//        return dataSource;
//    }

//    @Bean(name = "entityManager")
//    public EntityManager entityManager() {
//        return entityManagerFactory().createEntityManager();
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public EntityManagerFactory entityManagerFactory() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", dialect);
//
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource());
//        emf.setPackagesToScan("org.sun.resorts.holidays.model.jpa");   // <- package for entities
//        emf.setPersistenceUnitName("persistenceUnit");
//        emf.setJpaProperties(properties); 
//        emf.setPersistenceProvider(persistenceProvider);
//        emf.afterPropertiesSet();
//        return emf.getObject();
//    }
//
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager(entityManagerFactory());
//    }
//    
  
}

