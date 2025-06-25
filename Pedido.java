import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Categoria {
    ALIMENTO, ELETRONICO, OUTROS;

    public static Categoria fromNumero(int numero) {
        return switch (numero) {
            case 1 -> ALIMENTO;
            case 2 -> ELETRONICO;
            default -> OUTROS;
        };
    }
}

class ItemPedido {
    String descricao;
    int quantidade;
    Categoria categoria;

    public ItemPedido(String descricao, int quantidade, Categoria categoria) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria + " " + descricao + " " + quantidade;
    }
}

public class Pedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ItemPedido> itens = new ArrayList<>();

        while (true) {
            System.out.print("Descrição do item (em branco para encerrar): ");
            String descricao = scanner.nextLine().trim();

            if (descricao.isEmpty()) break;

            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.println("Categorias:");
            System.out.println("1. Alimento");
            System.out.println("2. Eletrônico");
            System.out.println("3. Outros");
            System.out.print("Escolha a categoria (1-3): ");
            int opcao = Integer.parseInt(scanner.nextLine());

            Categoria categoria = Categoria.fromNumero(opcao);
            itens.add(new ItemPedido(descricao, quantidade, categoria));
        }

        System.out.println("\nLista do pedido:");
        for (ItemPedido item : itens) {
            System.out.println(item);
        }
    }
}
