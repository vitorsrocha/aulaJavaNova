package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.*;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final OrcamentoRespository orcamentoRespository;
    private final OrdemServicoRepository ordemServicoRepository;
    private final RegistroDiaTrabalhoepository registroDiaTrabalhoepository;


    public OrdemServicoService(OrdemServicoRepository repository, FuncionarioRepository funcionarioRepository, VeiculoRepository veiculoRepository, OrcamentoRespository orcamentoRespository, OrdemServicoRepository ordemServicoRepository, RegistroDiaTrabalhoepository registroDiaTrabalhoepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.veiculoRepository = veiculoRepository;
        this.orcamentoRespository = orcamentoRespository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.registroDiaTrabalhoepository = registroDiaTrabalhoepository;
    }

    @Transactional
    public OrdemServico criarOs(OrdemServico ordemServico){
       Optional<Veiculo> veiculoBanco = this.veiculoRepository.findById(ordemServico.getVeiculo().getId());
        Optional<Orcamento> orcamentoBanco = this.orcamentoRespository.findById(ordemServico.getOrcamento().getId());
        if (veiculoBanco.isPresent() && orcamentoBanco.isPresent()) {
            for (int i = 0; i < ordemServico.getFuncionario().size();i++) {
                Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(ordemServico.getFuncionario().get(i).getId());
                if (!funcionarioBanco.isPresent() || !funcionarioBanco.get().isMecanico()) {
                    return null;
                }
                return repository.save(ordemServico);
            }
        }
       return null;
    }
    @Transactional
    public OrdemServico finalizarOS(int id, boolean status){
        Optional<OrdemServico> ordemServicoBanco = this.repository.findById(id);

        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        String strDate = sm.format(data);

        if(ordemServicoBanco.isPresent() && ordemServicoBanco.get().getFechada() == false){
            OrdemServico os = ordemServicoBanco.get();
            os.setFechada(true);
            os.setDataConclusao(strDate);
            return repository.save(os);
        }
        return null;
    }

    @Transactional
    public RegistroDiaTrabalho registrarTarefaDia(RegistroDiaTrabalho registro){

        Optional<OrdemServico> ordemServicoBanco = this.ordemServicoRepository.findById(registro.getOrdemServico().getId());

        if (ordemServicoBanco.isPresent()){
            return this.registroDiaTrabalhoepository.save(registro);
        }
        return null;
    }
   /* @Transactional
    public OrdemServico gerarOrcamento(int id){
        Optional<OrdemServico> osBanco = this.repository.findById(id);
        List<String> problemasOs = new ArrayList<>();
//        BigDecimal valorPeca = BigDecimal.ZERO;
//        BigDecimal valorMaoDeObra = BigDecimal.ZERO;

        if (osBanco.isPresent()){
            OrdemServico os = osBanco.get();
            for (Problema problemas: osBanco.get().getProblema()){
                problemasOs.add("Defeito: " + problemas.getDefeito() + "\nValor peça: " + problemas.getValor());
                os.setTotalPrecoPecas(os.getTotalPrecoPecas().add(problemas.getValor()));
                os.setTotalPrecoMaoDeObra(os.getTotalPrecoMaoDeObra().add(problemas.getValorMaoDeObra()));
                os.setTotalDiasEntrega(os.getTotalDiasEntrega() + problemas.getQtdDiasParaFazer());

            }
            return os;

        }
        return null;

    }*/
}
