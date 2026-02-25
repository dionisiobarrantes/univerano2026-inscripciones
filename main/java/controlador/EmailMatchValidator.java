package controlador;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("EmailMatchValidator")
public class EmailMatchValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // El valor de este componente (correoElectronico2)
        String confirmEmail = value == null ? "" : value.toString();

        // Obtener el ID del componente con el que comparar desde un atributo del componente actual
        String matchComponentId = (String) component.getAttributes().get("matchComponentId");

        if (matchComponentId == null) {
            return;
        }

        // Buscar el componente original
        UIInput matchComponent = (UIInput) component.findComponent(matchComponentId);

        if (matchComponent == null) {
            throw new RuntimeException("No se pudo encontrar el componente con ID: " + matchComponentId);
        }

        // Obtener el valor ya validado/enviado del componente original
        Object originalValue = matchComponent.getSubmittedValue();
        if (originalValue == null) {
            originalValue = matchComponent.getValue();
        }
        
        String originalEmail = originalValue == null ? "" : originalValue.toString();

        if (!confirmEmail.equals(originalEmail)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validación", "Los correos electrónicos no coinciden");
            throw new ValidatorException(msg);
        }
    }
}
