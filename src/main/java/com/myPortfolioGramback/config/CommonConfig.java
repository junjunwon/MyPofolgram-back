package com.myPortfolioGramback.config;

import org.apache.catalina.Container;
import org.apache.catalina.core.StandardHost;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
//@EnableWebMvc
public class CommonConfig implements WebMvcConfigurer {

    /**
     * spring boot resource handling config set
     *
     * @author jh.won
     * @since 2022.03.07
     * @param registry
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }

    /**
     * Content-Type 기본 인코딩 변경 ( ISO-8859-1 -> UTF-8)
     *
     * @author jh.won
     * @since 2022.03.07
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
                .filter(converter -> converter instanceof StringHttpMessageConverter)
                .forEach(converter -> ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8));
    }

    /**
     * spring boot view resource config set
     *
     * @author jh.won
     * @since 2022.03.07
     * @return
     */
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".html");
        resolver.setCache(false);
        return resolver;
    }

    /**
     * Tomcat 기본 에러 페이지 커스텀
     * URL에 허용되지 않는 특수문자가 포함될 경우 에러처리 대응
     * CustomErrorReportValveHandler 에서 에러 내용 출력
     *
     * @author jh.won
     * @since 2022.03.07
     */
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> errorReportValveCustomizer() {
//        return (factory) -> {
//            factory.addContextCustomizers(context -> {
//                final Container parent = context.getParent();
//                if (parent instanceof StandardHost) {
//                    ((StandardHost) parent).setErrorReportValveClass(
//                            "commonweb.handler.CustomErrorReportValveHandler");
//                }
//            });
//        };
//    }
//
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //.allowedOrigins("http://localhost:8080")
                //.allowedMethods("*")
                //.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedMethods("POST", "GET")
                .allowedHeaders("*")
                .exposedHeaders("authorization");
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
//                .setPropertyCondition(Conditions.isNotNull())
                .setSourceNamingConvention(NamingConventions.NONE)
                .setDestinationNamingConvention(NamingConventions.NONE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
