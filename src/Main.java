import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        List<Compra> listaCompras = new ArrayList<>();

        int operacao;
        System.out.println("Qual é o limite do seu cartão?");
        int limite = leitura.nextInt();
        System.out.println("Você quer realizar uma compra? (1 para SIM,0 para NÃO)");
        operacao = leitura.nextInt();

        while(operacao != 0){
            if (operacao == 1){
                System.out.println("Qual é o produto que você quer comprar?");
                String produto = leitura.next();

                System.out.println("Qual o valor desse produto?");
                int valor = leitura.nextInt();

                if(valor > limite){
                    System.out.println("Valor acima do limite");
                    System.out.println("Deseja tentar comprar outro produto? 1 - SIM; 0 - NÃO");
                    operacao = leitura.nextInt();
                }else{
                    System.out.println( produto + " comprado, você ainda tem R$" + (limite - valor) + " de limite.");
                    Compra compra = new Compra(valor, produto);
                    listaCompras.add(compra);
                    limite -= valor;

                    System.out.println("Quer realizar outra compra? COMPRAR MAIS = 1; SAIR = 0");
                    operacao = leitura.nextInt();
                }
            }else{
                System.out.println("Número inválido");
                break;
            }
        }
        Collections.sort(listaCompras);
        System.out.println("Produtos comprados:");
        for(Compra compra : listaCompras){
            System.out.println(compra);
        }
    }
}