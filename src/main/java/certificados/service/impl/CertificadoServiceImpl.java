package certificados.service.impl;

import certificados.service.CertificadoService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CertificadoServiceImpl implements CertificadoService {

    private static final String CAMINHO = "classpath:certificado/";
    private static final String CAMINHO_CERTIFICADO = "certificado.jasper";
    private static final String PARAMETRO_CAMINHO_IMAGEM = "CAMINHO_IMAGEM";
    private static final String PARAMETRO_ID_CERTIFICADO = "ID_CERTIFICADO";

    private final Connection conexao;
    private final ResourceLoader resourceLoader;
    private Map<String, Object> parametros;

    public CertificadoServiceImpl(Connection conexao, ResourceLoader resourceLoader) {
        this.conexao = conexao;
        this.resourceLoader = resourceLoader;
        parametros = new HashMap<>();
        parametros.put(PARAMETRO_CAMINHO_IMAGEM, CAMINHO);
    }

    @Override
    public byte[] buscarCertificado(Long id) {
        try {
            Resource resource = resourceLoader.getResource(CAMINHO.concat(CAMINHO_CERTIFICADO));
            parametros.put(PARAMETRO_ID_CERTIFICADO, id);
            JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getInputStream(), parametros, conexao);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
