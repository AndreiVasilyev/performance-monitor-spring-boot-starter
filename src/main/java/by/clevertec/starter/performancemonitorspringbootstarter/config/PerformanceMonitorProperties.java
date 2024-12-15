package by.clevertec.starter.performancemonitorspringbootstarter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "performance-monitor")
@Getter
@Setter
public class PerformanceMonitorProperties {
    private boolean isPresent;
    private int minExecutionTime;
}
