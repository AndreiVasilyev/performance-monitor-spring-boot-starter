package by.clevertec.starter.performancemonitorspringbootstarter.config;

import by.clevertec.starter.performancemonitorspringbootstarter.aspect.PerformanceMonitorAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({PerformanceMonitorProperties.class})
public class PerformanceMonitorAutoConfiguration {

    @Bean
    PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties performanceMonitorProperties) {
        return new PerformanceMonitorAspect(performanceMonitorProperties.isPresent(), performanceMonitorProperties.getMinExecutionTime());
    }

    @Bean
    PerformanceMonitorProperties performanceMonitorProperties() {
        return new PerformanceMonitorProperties();
    }
}
