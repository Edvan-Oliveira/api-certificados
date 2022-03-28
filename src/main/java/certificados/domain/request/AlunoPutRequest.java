package certificados.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class AlunoPutRequest {
    private Long id;
    @NotEmpty(message = "Nome obrigatório")
    @Size(max = 50, message = "Nome é no maximo {max} caracteres")
    private String nome;
    @NotEmpty(message = "Curso obrigatório")
    @Size(max = 50, message = "Curso é no maximo {max} caracteres")
    private String curso;
    @NotEmpty(message = "Docente obrigatório")
    @Size(max = 50, message = "Docente é no maximo {max} caracteres")
    private String docente;
}
