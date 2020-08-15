package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.*;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final OrcamentoRespository orcamentoRespository;
    private final OrdemServicoRepository ordemServicoRepository;
    private final RegistroDiaTrabalhoRepository registroDiaTrabalhoRepository;


    public OrdemServicoService(OrdemServicoRepository repository, FuncionarioRepository funcionarioRepository, VeiculoRepository veiculoRepository, OrcamentoRespository orcamentoRespository, OrdemServicoRepository ordemServicoRepository, RegistroDiaTrabalhoRepository registroDiaTrabalhoRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.veiculoRepository = veiculoRepository;
        this.orcamentoRespository = orcamentoRespository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.registroDiaTrabalhoRepository = registroDiaTrabalhoRepository;
    }

    @Transactional
    public OrdemServico criarOs(OrdemServico ordemServico){

        Optional<Orcamento> orcamentoBanco = this.orcamentoRespository.findById(ordemServico.getOrcamento().getId());

        LocalDateTime dataAtualInicio = LocalDateTime.now();
        LocalDateTime dataFim = dataAtualInicio.plusDays(orcamentoBanco.get().getTotalDiasEntrega());


        if (orcamentoBanco.isPresent()) {
            for (int i = 0; i < ordemServico.getFuncionario().size();i++) {
                Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(ordemServico.getFuncionario().get(i).getId());
                if (!funcionarioBanco.isPresent() || !funcionarioBanco.get().isMecanico()) {
                    return null;
                }

                ordemServico.setDataInicio(dataAtualInicio);
                ordemServico.setDataFim(dataFim);
                return repository.save(ordemServico);
            }
        }
       return null;
    }
    private long calcularDiasEntreDatas( LocalDateTime dataConclusao,LocalDateTime dataFim ){
        //System.out.println(data + " dataquandoChega");
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
       // System.out.println(data + " dataTransformada");

        long diferencaEmDias = ChronoUnit.DAYS.between(dataConclusao, dataFim);

        return diferencaEmDias;

    }

    @Transactional
    public OrdemServico finalizarOS(int id){
        Optional<OrdemServico> ordemServicoBanco = this.repository.findById(id);

        LocalDateTime dataConclusao = LocalDateTime.now();


        if(ordemServicoBanco.isPresent() && ordemServicoBanco.get().getFechada() == false){
            OrdemServico os = ordemServicoBanco.get();
            os.setFechada(true);
            os.setDataConclusao(dataConclusao);
            long produtividade = calcularDiasEntreDatas(dataConclusao,os.getDataFim());
            System.out.println(produtividade);
            os.setProdutividade(produtividade);

            return repository.save(os);
        }
        return null;
    }

    @Transactional
    public RegistroDiaTrabalho registrarTarefaDia(RegistroDiaTrabalho registro){

        Optional<OrdemServico> ordemServicoBanco = this.ordemServicoRepository.findById(registro.getOrdemServico().getId());

        if (ordemServicoBanco.isPresent()){
            registro.setFuncionario(ordemServicoBanco.get().getFuncionario().get(0));
            return this.registroDiaTrabalhoRepository.save(registro);
        }
        return null;
    }

    @Transactional
    public List<OrdemServico> buscarOrdemServicoPorFuncionario(int id){

        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(id);
        List<OrdemServico> osFuncionario = this.ordemServicoRepository.findAll();
        List<OrdemServico> osFuncionarioLocalizada = new ArrayList<>();

        if (funcionarioBanco.isPresent()){
            for (int i= 0 ; i < osFuncionario.size();i++){
                for (int j= 0 ; j < osFuncionario.get(i).getFuncionario().size();j++){
                    if (funcionarioBanco.get().getId() == osFuncionario.get(i).getFuncionario().get(j).getId()){
                        osFuncionarioLocalizada.add(osFuncionario.get(i));
                    }
                }
            }
            return osFuncionarioLocalizada;
        }
        return null;
    }
    @Transactional
    public OrdemServico registroBuscaVeiculo(int idOS){
        Optional<OrdemServico> ordemServicoBanco = this.repository.findById(idOS);
        if (ordemServicoBanco.isPresent() && ordemServicoBanco.get().getFechada() == true){
            LocalDateTime dataAtual= LocalDateTime.now();

            OrdemServico os = ordemServicoBanco.get();
            os.setDataBuscaVeiculo(dataAtual);
            return repository.save(os);
        }
        return null;

    }

}
