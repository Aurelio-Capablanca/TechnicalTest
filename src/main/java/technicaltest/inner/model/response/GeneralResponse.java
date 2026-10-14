package technicaltest.inner.model.response;

import lombok.Data;

/*se utilza data para invocar en una sola anotación los llamados a:
getter,setter,toString, value, y requiredargsconstructor, dado que esta no es una entidad
no hay problemas con la representacion de la misma en logs
*/
@Data
/*la funcion de la clase es abarcar data y metadata necesaria
para resumir de forma conscisa la respuesta a enviar al cliente HTTP*/
public class GeneralResponse<T> {

    private String message;
    private String code;
    private String error;
    private T dataset;
    /* se utiliza un Generic para el campo dataset con el fin que
    la clase pueda ser extendida en etapas futuras del desarrollo*/


}
