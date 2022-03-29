package certificados.resource;

import certificados.service.CertificadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/certificados")
public class CertificadoResource {

    private final CertificadoService certificadoService;

    @GetMapping("/{id}")
    public void exibirCertificado(@PathVariable Long id, HttpServletResponse resposta) throws IOException {
        String nomeCertificado = "certificado-".concat(id.toString()).concat(".pdf");
        resposta.setContentType(MediaType.APPLICATION_PDF_VALUE);
        resposta.setHeader("Content-disposition", "inline; filename=".concat(nomeCertificado));
        resposta.getOutputStream().write(certificadoService.buscarCertificado(id));
    }
}
