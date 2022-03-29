package certificados.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AlunoGetResponse {
    private Long id;
    private String nome;
    private String curso;
    private String docente;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataConclusao;
    private String certificado;

    public String getCertificado() {
        return getDataConclusao() != null
                ? "https://edvan-api-certificados.herokuapp.com/certificados/".concat(id.toString()) : null;
    }
}
