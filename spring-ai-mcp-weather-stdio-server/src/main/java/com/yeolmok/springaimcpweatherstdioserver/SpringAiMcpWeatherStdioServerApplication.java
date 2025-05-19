package com.yeolmok.springaimcpweatherstdioserver;

import com.yeolmok.springaimcpweatherstdioserver.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiMcpWeatherStdioServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiMcpWeatherStdioServerApplication.class, args);
    }

    // MethodToolCallbackProvider를 사용하여 @Tool을 MCP 서버에서 사용하는 실행 가능한 콜백으로 변환
    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }
}
