package net.ensode.javaee8book.jsfcustomval;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;


@Named
@RequestScoped

public class AlphaValidator {
  // later binding using reflection (retrospection)
  public void validateAlpha(FacesContext facesContext,
      UIComponent uiComponent,
      Object value) throws ValidatorException {

    if (!StringUtils.isAlphaSpace((String) value)) {
      HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
      FacesMessage facesMessage = new FacesMessage(htmlInputText.
          getLabel()
          + ": only alphabetic characters are allowed.");
      throw new ValidatorException(facesMessage);
    }
  }
}
