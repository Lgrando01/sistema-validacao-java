package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE" , "LUCAS" , "AUGUSTO" , "MONICA"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);

        }
        
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do { 
            atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato Realizado com sucesso");
        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("Conseguimos contato com o " + candidato + "NA" + tentativasRealizadas + "TENTATIVA");
        else
            System.out.println("Não conseguimos contato com o" + candidato + "NUMERO MAXIMO TENTATIVAS" + tentativasRealizadas + "REALIZADA");
    }

    //método auxiliar
    static boolean atender() {
         return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE" , "LUCAS" , "AUGUSTO" , "MONICA"};
        System.out.println("Imprimindo a lista de candidatos selecionados");

        for(int indice=0; indice < candidatos.length;indice++){
            System.out.println("O candidato de Numero:" + (indice+1) + "É o" + candidatos[indice]);
        }
        System.out.println("Forma abrevida de interacao for each");

        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi:" + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "LUCAS" , "MATHEUS" , "AUGUSTO" , "PAULO" , "MONICA" , "MIRELA"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase=2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) { 
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato" + candidato + "Solicitou este valor de salario" + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato" + candidato + "foi selecionado para vaga");
                candidatosSelecionados++;
                
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
       double salarioBase = 2000.0;
       if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
       }else if(salarioBase==salarioPretendido)
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
       else{
        System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
       } 
    }
}