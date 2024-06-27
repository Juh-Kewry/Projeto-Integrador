import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//tela principal do código
public class Cadastro extends JFrame {
    // componentes
    private JTextField campoNome, campoIdade, campoTel, campoCpf, campoEmail;
    private JTextField campoRua, campoNum, campoBairro, campoCep;
    private JButton cadastrarButton, limparButton;
    private JComboBox<String> tipoCadastroBox;
    private JTextArea cadastrosArea;

    // lista pra armazenar os cadastros
    private List<String> cadastros;

    // construtor da classe
    public Cadastro() {

        cadastros = new ArrayList<>();

        // formatação da tela principal - FRAME
        setTitle("Cadastro - Pet Shop");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // painel pros componentes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(12, 2, 5, 5));

        // componentes
        JLabel tipo = new JLabel("Tipo de Cadastro:");
        String[] tipos = {"Funcionário", "Cliente"};
        tipoCadastroBox = new JComboBox<>(tipos);

        JLabel nomeLbl = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel idadeLbl = new JLabel("Idade:");
        campoIdade = new JTextField(10);

        JLabel telLbl = new JLabel("Telefone:");
        campoTel = new JTextField(15);

        JLabel cpfLbl = new JLabel("CPF:");
        campoCpf = new JTextField(15);

        JLabel emailLbl = new JLabel("E-mail:");
        campoEmail = new JTextField(30);

        JLabel ruaLbl = new JLabel("Rua:");
        campoRua = new JTextField(30);

        JLabel numLbl = new JLabel("Número:");
        campoNum = new JTextField(10);

        JLabel bairroLbl = new JLabel("Bairro:");
        campoBairro = new JTextField(20);

        JLabel cepLbl = new JLabel("CEP:");
        campoCep = new JTextField(15);

        cadastrarButton = new JButton("Cadastrar");
        limparButton = new JButton("Limpar Campos");

        cadastrosArea = new JTextArea(10, 60);
        cadastrosArea.setEditable(false);

        // add componentes
        painel.add(tipo);
        painel.add(tipoCadastroBox);
        painel.add(nomeLbl);
        painel.add(campoNome);
        painel.add(idadeLbl);
        painel.add(campoIdade);
        painel.add(telLbl);
        painel.add(campoTel);
        painel.add(cpfLbl);
        painel.add(campoCpf);
        painel.add(emailLbl);
        painel.add(campoEmail);
        painel.add(ruaLbl);
        painel.add(campoRua);
        painel.add(numLbl);
        painel.add(campoNum);
        painel.add(bairroLbl);
        painel.add(campoBairro);
        painel.add(cepLbl);
        painel.add(campoCep);
        painel.add(cadastrarButton);
        painel.add(limparButton);

        // painel para mostrar os cadastros já existentes
        JPanel cadastrosPainel = new JPanel();
        cadastrosPainel.setBorder(BorderFactory.createTitledBorder("Cadastros Existente"));
        cadastrosPainel.add(new JScrollPane(cadastrosArea));

        // ação do botão cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        // ação do botão limpar
        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        // ação do combo de caixas para limpar campos ao mudar de opção: cliente - funcionario
        tipoCadastroBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        // add o painel principal à tela
        add(painel, BorderLayout.CENTER);
        add(cadastrosPainel, BorderLayout.SOUTH);

        // mostrar a janela
        setVisible(true);
    }

    // Método para fazer o cadastro
    private void cadastrar() {
        // pegar os dados dos campos(caixas)
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String tel = campoTel.getText();
        String cpf = campoCpf.getText();
        String email = campoEmail.getText();
        String rua = campoRua.getText();
        String num = campoNum.getText();
        String bairro = campoBairro.getText();
        String cep = campoCep.getText();
        String tipoCadastro = (String) tipoCadastroBox.getSelectedItem();

        // construir a string do cadastro
        String cadastro = "Tipo: " + tipoCadastro + "\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Telefone: " + tel + "\n" +
                "CPF: " + cpf + "\n" +
                "E-mail: " + email + "\n" +
                "Rua: " + rua + "\n" +
                "Número: " + num + "\n" +
                "Bairro: " + bairro + "\n" +
                "CEP: " + cep + "\n";

        // add cadastro à lista
        cadastros.add(cadastro);

        // atualizar área de cadastros existentes
        atualizarCadastros();

        // limpar campos depois de cadastrar
        limparCampos();
    }

    // método pra limpar os campos
    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        campoTel.setText("");
        campoCpf.setText("");
        campoEmail.setText("");
        campoRua.setText("");
        campoNum.setText("");
        campoBairro.setText("");
        campoCep.setText("");
    }

    // método pra atualizar a área de cadastros existentes
    private void atualizarCadastros() {
        StringBuilder sb = new StringBuilder();
        for (String cadastro : cadastros) {
            sb.append(cadastro).append("\n");
            //pegando cada cadastro da lista, lendo um por um e depois adicionando
        }
        cadastrosArea.setText(sb.toString());
    }
}
