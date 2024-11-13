package com.example.new_project_challenge_15.configuration;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.example.new_project_challenge_15.neo4j2", transactionManagerRef = "neo4j2TransactionManager", neo4jTemplateRef = "neo4j2Template")
@EnableTransactionManagement
public class neo4j2Configuration {
    @Value("${spring.neo4j2.uri}")
    private String neo4jUri;
    @Value("${spring.neo4j2.authentication.username}")
    private String username;
    @Value("${spring.neo4j2.authentication.password}")
    private String password;
    @Bean
    @Primary
    public Driver getConfiguration2(){return GraphDatabase.driver(neo4jUri, AuthTokens.basic(username,password));}
    @Bean(name = "neo4j2TransactionManager")
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(getConfiguration2());
    }
    @Bean(name = "neo4j2Client")
    public Neo4jClient neo4j2Client(DatabaseSelectionProvider databaseNameProvider){
        return Neo4jClient.create(getConfiguration2(),databaseNameProvider);
    }
    @Bean(name = "neo4j2Template")
    public Neo4jTemplate neo4j2Template(@Qualifier("neo4j2Client") Neo4jClient neo4jClient, Neo4jMappingContext neo4jMappingContext){
        return new Neo4jTemplate(neo4jClient,neo4jMappingContext);
    }

}

