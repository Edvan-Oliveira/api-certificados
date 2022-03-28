package certificados.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AlunoGetResponse {
    private Long id;
    private String nome;
    private String curso;
    private String docente;
    private Date dataInicio;
    private Date dataConclusao;
}
