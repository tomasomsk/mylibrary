package my.library.controller;

import my.library.dao.GenericDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;

import java.util.Collections;
import java.util.List;

@Controller
public class AbstractController {

    void rollbackAndAddErrorToModel(Model model, Exception exception, String objName, GenericDao dao) {
        dao.getCurrentSession().getTransaction().rollback();
        List<ObjectError> error = Collections.singletonList(
                new ObjectError(objName,
                        new String[]{exception.getCause() == null ? exception.getClass().getCanonicalName() : exception.getMessage()},
                        null,
                        exception.getCause() == null ? exception.getMessage() : exception.getCause().getMessage()
                ));
        model.addAttribute("errors", error);
    }

    protected boolean performCheck(Model model, boolean condition, String objName, String codes, String message) {
        if (condition) {
            List<ObjectError> error = Collections.singletonList(new ObjectError(objName,
                    new String[]{codes}, null, message));
            model.addAttribute("errors", error);
            return true;
        }
        return false;
    }

}
