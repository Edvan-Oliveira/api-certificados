package certificados.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
public class AlunoPostRequest {
    @NotEmpty(message = "Nome obrigatório")
    @Size(max = 50, message = "Nome é no maximo {max} caracteres")
    private String nome;
    @NotEmpty(message = "Curso obrigatório")
    @Size(max = 50, message = "Curso é no maximo {max} caracteres")
    private String curso;
    @NotEmpty(message = "Docente obrigatório")
    @Size(max = 50, message = "Docente é no maximo {max} caracteres")
    private String docente;
    @NotNull(message = "Data inicio obrigatória")
    private Date dataInicio;
}
