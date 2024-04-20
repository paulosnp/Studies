import java.util.Scanner;
public class TipoDeImovel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char tipoImovel;
        char residencial = 'R',comercial = 'C',industrial = 'I';
        double valorAnterior,valorAtual,consumoEnergia,valorConta,valorKwh,valorTotalConta;
        double valorContaRecidencial = 0,valorContaComercial = 0,valorContaIndustrial = 0;
        int quantidadeResidencial = 0,quantidadeComercial = 0,quantidadeIndustrial = 0;

        for (int i=1;i<=4;i++){
            do {
                System.out.printf("Insira o tipo do %d° imóvel (R/C/I):",i);
                tipoImovel = input.next().charAt(0);
                tipoImovel = Character.toUpperCase(tipoImovel);
                if (tipoImovel!=residencial && tipoImovel!=comercial && tipoImovel!=industrial){
                    System.out.println("Tipo inválido!");
                    continue;
                }
                break;
            }while (tipoImovel!=residencial && tipoImovel!=comercial && tipoImovel!=industrial);

            if (tipoImovel==residencial) {
                System.out.println("Tipo Residencial escolhido!");
                quantidadeResidencial++;
                valorKwh = 0.50;
            } else if (tipoImovel==comercial) {
                System.out.println("Tipo Comercial escolhido!");
                quantidadeComercial++;
                valorKwh = 0.70;
            }else {
                System.out.println("Tipo Industrial escolhido!");
                quantidadeIndustrial++;
                valorKwh = 0.40;
            }
            System.out.printf("Insira o valor ANTERIOR do medidor de energia do %d° imovel:",i);
            valorAnterior = input.nextDouble();

            while (valorAnterior<0){
                System.out.println("O valor ANTERIOR precisa ser positivo!");
                System.out.printf("Insira o valor ANTERIOR do medidor de energia do %d° imovel:",i);
                valorAnterior = input.nextDouble();
            }
            System.out.printf("Insira o valor ATUAL do medidor de energia do %d° imovel:",i);
            valorAtual = input.nextDouble();

            while(valorAtual<valorAnterior){
                System.out.println("O valor ATUAL precisa ser maior o igual o valor anterior!");
                System.out.printf("Insira o valor ATUAL do medidor de energia do %d° imovel:",i);
                valorAtual = input.nextDouble();
            }
            consumoEnergia = valorAtual - valorAnterior;
            valorConta = consumoEnergia * valorKwh;
            if (tipoImovel==residencial) {
                valorContaRecidencial = valorContaRecidencial + valorConta;
            } else if (tipoImovel==comercial) {
                valorContaComercial = valorContaComercial + valorConta;
            }else {
                valorContaIndustrial = valorContaIndustrial + valorConta;
            }
            System.out.printf("Consumo de energia do %d° imóvel: %.2f kWh\n",i,consumoEnergia);
            System.out.printf("Valor da conta de energia do %d° imóvel: R$ %.2f\n",i,valorConta);
        }
        valorTotalConta = valorContaRecidencial + valorContaComercial + valorContaIndustrial;
        System.out.printf("Quantidade de imóveis por tipo\nResidencial: %d \nComercial: %d \nIndustrial: %d \n",quantidadeResidencial,quantidadeComercial,quantidadeIndustrial);
        System.out.printf("Valor total da conta dos imóveis por tipo:\nResidencial: R$ %.2f \nComercial: R$ %.2f \nIndustrial: R$ %.2f \n"
                ,valorContaRecidencial,valorContaComercial,valorContaIndustrial);
        System.out.printf("Valor total da conta: R$ %.2f",valorTotalConta);
    }
}