package com.marcal.pdumbbell.config;

import com.marcal.pdumbbell.common.resolver.AuthUserResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthUserResolver authUserResolver;

    public WebConfig( AuthUserResolver authUserResolver ) {
        this.authUserResolver = authUserResolver;
    }

    @Override
    public void addArgumentResolvers( List<HandlerMethodArgumentResolver> resolvers ) {
        resolvers.add( authUserResolver );
    }

}
