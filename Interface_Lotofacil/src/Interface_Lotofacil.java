import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Interface_Lotofacil extends JFrame implements ActionListener {
    private final JLabel titleLabel;
    private final JButton betNumberButton;
    private final JButton betLetterButton;
    private final JButton betOddEvenButton;
    private final JButton exitButton;

    public Interface_Lotofacil() {
        setTitle("LOTOFÁCIL");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        titleLabel = new JLabel("Escolha uma opção:");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        betNumberButton = new JButton("APOSTAR DE 0 A 100");
        betNumberButton.addActionListener(this);

        betLetterButton = new JButton("APOSTAR DE A ATÉ Z");
        betLetterButton.addActionListener(this);

        betOddEvenButton = new JButton("APOSTAR EM PAR OU ÍMPAR");
        betOddEvenButton.addActionListener(this);

        exitButton = new JButton("SAIR :(");
        exitButton.addActionListener(this);

        add(titleLabel);
        add(betNumberButton);
        add(betLetterButton);
        add(betOddEvenButton);
        add(exitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == betNumberButton) {
            betNumber();
        } else if (e.getSource() == betLetterButton) {
            betLetter();
        } else if (e.getSource() == betOddEvenButton) {
            betOddEven();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void betNumber() {
        int minimo = 0;
        int maximo = 100;
        Random r = new Random();
        int vencedorNumero = r.nextInt(maximo - minimo) + minimo;

        String input = JOptionPane.showInputDialog("Digite um número de 0 a 100:");
        int numeroAposta;
        try {
            numeroAposta = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (numeroAposta == vencedorNumero) {
            JOptionPane.showMessageDialog(this, "Jackpot! Você ganhou R$1000,00");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! O número correto era: " + vencedorNumero);
        }
    }

    private void betLetter() {
        char letraVencedora = 'O';

        String input = JOptionPane.showInputDialog("Digite uma letra de A até Z:");
        char letraAposta;
        if (input != null && input.length() == 1) {
            letraAposta = input.charAt(0);
        } else {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira uma única letra.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        letraAposta = Character.toUpperCase(letraAposta);

        if (!Character.isLetter(letraAposta)) {
            JOptionPane.showMessageDialog(this, "Aposta inválida, tente novamente com uma letra de A até Z.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (letraAposta == letraVencedora) {
            JOptionPane.showMessageDialog(this, "Jackpot! Você ganhou R$500,00");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! Você perdeu, a letra sorteada foi: " + letraVencedora);
        }
    }

    private void betOddEven() {
        String input = JOptionPane.showInputDialog("Insira um número ímpar ou par:");
        int apostaParImpar;
        try {
            apostaParImpar = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (apostaParImpar % 2 == 0) {
            JOptionPane.showMessageDialog(this, "Jackpot! Você ganhou R$100,00");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! O número digitado é ímpar e a premiação foi para números pares");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Interface_Lotofacil();
        });
    }
}
