package com.aulaJavaNova.Trainee.controleDePonto.service;

import com.aulaJavaNova.Trainee.controleDePonto.domain.Funcionario;
import com.aulaJavaNova.Trainee.controleDePonto.domain.Ponto;
import com.aulaJavaNova.Trainee.controleDePonto.repository.FuncionarioRepository;
import com.aulaJavaNova.Trainee.controleDePonto.repository.PontoRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PontoService {
    private PontoRepository repository;
    private FuncionarioRepository funcionarioRepository;


    public PontoService(PontoRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }


    public void formatData(Ponto ponto) {
        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss");
        Date data = new Date();
        String strDate = sm.format(data);
        ponto.setData(strDate);
    }


    @Transactional
    public Ponto salvarPonto(Ponto ponto) {
        formatData(ponto);
        return this.repository.save(ponto);
    }

    @Transactional
    public Ponto buscarPonto(int id) {
        Optional<Ponto> pontoBanco = this.repository.findById(id);

        if (pontoBanco.isPresent()) {
            return pontoBanco.get();
        }

        return null;
    }

    @Transactional
    public List<Ponto> listarPonto() {
        return this.repository.findAll();
    }

    @Transactional
    public void deletarPonto(Ponto ponto) {
        repository.delete(ponto);
    }

    @Transactional
    public Ponto desbloquearPonto(int id) {
        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(id);
        if (funcionarioBanco.isPresent()) {
            Funcionario funcionario = funcionarioBanco.get();
            funcionario.setQuantidade(0);
            funcionarioRepository.save(funcionario);
            System.out.println("Ponto do funcionario " + funcionario.getNome() + " está desbloqueado!!");
            Ponto ponto = new Ponto();
            return ponto;
        } else {
            System.out.println("Id não existe");
            return null;
        }
    }

    @Transactional
    public Ponto baterPonto(int id, Ponto ponto) {

        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(id);

        DateTime dia = new DateTime();
        String diaSemana = dia.dayOfWeek().getAsText();

        int horaPonto = Integer.parseInt(dia.hourOfDay().getAsText());
        int diaPonto = Integer.parseInt(dia.dayOfMonth().getAsText());

        if (funcionarioBanco.isPresent()) {

            Funcionario funcionario = funcionarioBanco.get();

//           System.out.println("Dia da semana String: "
//                   + diaSemana + " - " + funcionario.getDiaSemana() + " - "+ dia.hourOfDay().getAsText() + ":" + dia.minuteOfHour().getAsText());

            if (funcionario.getDiaSemana().equals(diaSemana)) {
                System.out.println("Usuario já bateu ponto hoje, por favor procurar R.H para mais informações");
                return null;
            } else {

                SimpleDateFormat sm = new SimpleDateFormat("MMddyyyy");
                Date data = new Date();
                String strDate = sm.format(data).substring(0, 2);
                int mesPonto = Integer.parseInt(strDate);

                if (mesPonto > funcionario.getMes()) {
                    funcionario.setData(diaPonto);
                    funcionarioRepository.save(funcionario);
                }
                if (diaSemana.equals("Segunda-feira") && funcionario.getData() <= diaPonto) {
                    funcionario.setQuantidade(0);
                    funcionarioRepository.save(funcionario);
                    System.out.println("Ponto resetado");
                }

                if (8 <= horaPonto) {
                    funcionario.setQuantidade(funcionario.getQuantidade() + 1);
                    funcionarioRepository.save(funcionario);

                }

                if (funcionario.getQuantidade() < 3) {
                    funcionario.setDiaSemana(diaSemana);
                    funcionario.setData(diaPonto);
                    funcionario.setMes(mesPonto);
                    formatData(ponto);
                    System.out.println("Comprovante de Ponto \nNome: " +
                            funcionario.getNome() + "\nData: " +
                            ponto.getData() + " - " + funcionario.getDiaSemana());
                    return this.repository.save(ponto);

                } else {
                    System.out.println("Usuario com Ponto bloqueado, por favor procurar R.H para mais informações");
                    return null;
                }
            }
        } else {
            System.out.println("Usuario invalido, por favor procurar R.H para mais informações");
            return null;
        }
    }
}



