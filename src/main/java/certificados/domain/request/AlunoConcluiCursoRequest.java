package certificados.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
public class AlunoConcluiCursoRequest {
    private Long id;
    @NotNull(message = "Data conclusão obrigatória")
    private Date dataConclusao;
}
