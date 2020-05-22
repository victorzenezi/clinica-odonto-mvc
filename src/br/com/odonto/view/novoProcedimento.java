package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odondo.dao.ProcedimentoDao;
import br.com.odonto.models.Procedimento;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class novoProcedimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtvalor;
	
	private ProcedimentoDao procDao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					novoProcedimento frame = new novoProcedimento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public novoProcedimento() {
		setResizable(false);
		setTitle("Novo Procedimento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(novoProcedimento.class.getResource("/images/fav.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 250, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoProcedimento = new JLabel(" Novo Procedimento");
		lblNovoProcedimento.setForeground(new Color(42, 157, 143));
		lblNovoProcedimento.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNovoProcedimento.setBounds(62, 11, 204, 45);
		contentPane.add(lblNovoProcedimento);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(novoProcedimento.class.getResource("/images/dente.png")));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 11, 32, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblnome = new JLabel("Nome");
		lblnome.setForeground(new Color(42, 157, 143));
		lblnome.setFont(new Font("Arial", Font.PLAIN, 17));
		lblnome.setBounds(20, 75, 76, 35);
		contentPane.add(lblnome);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtnome.setColumns(10);
		txtnome.setBounds(20, 120, 246, 35);
		contentPane.add(txtnome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(38, 70, 83));
		btnCadastrar.setBounds(20, 296, 256, 54);
		contentPane.add(btnCadastrar);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(42, 157, 143));
		lblValor.setFont(new Font("Arial", Font.PLAIN, 17));
		lblValor.setBounds(20, 166, 76, 35);
		contentPane.add(lblValor);
		
		txtvalor = new JTextField();
		txtvalor.setFont(new Font("Arial", Font.PLAIN, 15));
		txtvalor.setColumns(10);
		txtvalor.setBounds(20, 211, 246, 35);
		contentPane.add(txtvalor);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					procDao = new ProcedimentoDao();
					
					var proc = new Procedimento();
					
					proc.setDescricao(txtnome.getText());
					proc.setValor(Double.parseDouble(txtvalor.getText()));
					procDao.Cadastrar(proc);
					
					dispose();
					
				}
				catch(Exception ex)
				{
					ex.getMessage();
				
				}

			}
		});
		
	}

}
