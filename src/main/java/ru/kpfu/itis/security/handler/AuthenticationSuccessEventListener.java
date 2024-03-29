package ru.kpfu.itis.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import ru.kpfu.itis.services.SingInAttemptService;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private SingInAttemptService singInAttemptService;

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent e) {
        HttpServletRequest request = null;
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof NativeWebRequest) {
            request = (HttpServletRequest) ((NativeWebRequest) attribs).getNativeRequest();
        } else {
            return;
        }

        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            singInAttemptService.loginSucceeded(request.getRemoteAddr());
        } else {
            singInAttemptService.loginSucceeded(xfHeader.split(",")[0]);
        }
    }
}