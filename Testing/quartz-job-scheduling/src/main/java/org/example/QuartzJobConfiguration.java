package org.example;

import com.zaxxer.hikari.HikariDataSource;
import org.quartz.Scheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class QuartzJobConfiguration {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/quartz_db");
        dataSource.setUsername("myuser");
        dataSource.setPassword("mypassword");
        dataSource.setDriverClassName("org.postgresql:postgresql");
        return dataSource;
    }

    @Bean
    @DependsOn("springBeanFactory")
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) throws IOException {
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);

        Properties properties = new Properties();
        properties.load(QuartzJobConfiguration.class.getClassLoader().getResourceAsStream("quartz.properties"));

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setDataSource(dataSource());
        schedulerFactoryBean.setQuartzProperties(properties);
        return schedulerFactoryBean;
    }

    @Bean
    @DependsOn("schedulerFactoryBean")
    public ScheduleService springBeanFactory(ScheduleDetailsRepository scheduleDetailsRepository,ApplicationContext applicationContext) {
        Scheduler scheduler = applicationContext.getBean(Scheduler.class);
        return new SchedulerServiceImpl(scheduleDetailsRepository,scheduler);
    }


}
