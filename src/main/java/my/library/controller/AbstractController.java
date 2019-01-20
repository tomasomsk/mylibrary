package my.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;

import java.util.Collections;
import java.util.List;

@Controller
public abstract class AbstractController {
    void addErrorToModel(Model model, Exception exception, String objName) {
        Throwable cause = null;
        if (exception.getCause() != null) {
            cause = exception.getCause();
            while (cause.getCause() != null) {
                cause = cause.getCause();
            }
        }
        List<ObjectError> error = Collections.singletonList(
                new ObjectError(objName,
                        new String[]{cause == null ? exception.getClass().getCanonicalName() : exception.getMessage()},
                        null,
                        cause == null ? exception.getMessage() : cause.getMessage()
                ));
        model.addAttribute("errors", error);
    }
}
