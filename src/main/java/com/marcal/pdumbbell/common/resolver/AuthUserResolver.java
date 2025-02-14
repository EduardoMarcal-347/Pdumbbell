package com.marcal.pdumbbell.common.resolver;

import com.marcal.pdumbbell.common.annotation.AuthenticatedUser;
import com.marcal.pdumbbell.dto.data.UserDTO;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter( MethodParameter parameter ) {
        return parameter.getParameterAnnotation( AuthenticatedUser.class ) != null
                && UserDTO.class.isAssignableFrom( parameter.getParameterType( ) );
    }

    @Override
    public Object resolveArgument( MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory ) {
        Authentication authentication = SecurityContextHolder.getContext( ).getAuthentication( );
        if ( authentication == null || !authentication.isAuthenticated( ) ) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
