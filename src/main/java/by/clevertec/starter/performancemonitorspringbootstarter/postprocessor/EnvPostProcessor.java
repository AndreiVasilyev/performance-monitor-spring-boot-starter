package by.clevertec.starter.performancemonitorspringbootstarter.postprocessor;

import by.clevertec.starter.performancemonitorspringbootstarter.exception.PerformanceMonitorInitException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EnvPostProcessor implements EnvironmentPostProcessor {

    YamlPropertySourceLoader loader;

    public EnvPostProcessor() {
        loader = new YamlPropertySourceLoader();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource("default.yaml");
        PropertySource<?> propertySource = null;
        try {
            propertySource = loader.load("performance-monitor", resource).getFirst();
        } catch (IOException e) {
            throw new PerformanceMonitorInitException(e);
        }
        environment.getPropertySources().addLast(propertySource);

    }
}
