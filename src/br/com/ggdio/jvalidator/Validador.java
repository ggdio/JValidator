package br.com.ggdio.jvalidator;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Validador 
{
	private String erro;

	private void setErro(String erro) 
	{
		this.erro = erro;
	}

	public String getErro() 
	{
		return erro;
	}

	public Validador() 
	{
		erro = "";
	}

	public void Valida(JTextField txt, int maximo)
	{
		if (txt.getText().length() > maximo) 
		{
			JOptionPane.showMessageDialog(null, "Erro: Máximo de " + maximo
					+ " caracteres !", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void Valida(JTextField txt, String tipo) 
	{
		if (tipo.equals("int")) 
		{
			if (!txt.getText().isEmpty())
{
				try 
				{
					Integer.parseInt(txt.getText());
				} 
				catch (Exception e) 
				{
					javax.swing.JOptionPane.showMessageDialog(null,
							"Erro: Digite apenas números inteiros!\n", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (tipo.equals("double"))
		{
			if (!txt.getText().isEmpty()) 
			{
				try 
				{
					Double.parseDouble(txt.getText());
				} 
				catch (Exception e) 
				{
					javax.swing.JOptionPane.showMessageDialog(null,
									"Erro: Digite apenas números!\n"
								  + "Utilize um ponto para separar os valores ao invés de vírgula !",
									"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public boolean Valida(JFrame frame) 
	{
		// Lista de JPanels
		List<JPanel> panel = new ArrayList<JPanel>();
		// Adiciona o JPanel "pai" do JFrame à List<JPanel>
		panel.add((JPanel) frame.getContentPane());
		// Retorna o resultado do método Valida(List<JPanel)
		return Valida(panel);
	}

	public boolean Valida(JInternalFrame frame) 
	{
		// Lista de JPanels
		List<JPanel> panel = new ArrayList<JPanel>();
		// JPanel "pai"
		JPanel pnl = (JPanel) frame.getLayeredPane().getComponent(0);

		// Percorre todos os Components do JPanel "pai"
		for (Component comp : pnl.getComponents())
		{
			// Verifica se possuí um JTabbedPane
			if (comp instanceof JTabbedPane) 
			{
				JTabbedPane tabbed = (JTabbedPane) comp;
				// Adiciona todos os JPanels do JTabbedPane à List<JPanel>
				for (Component c : tabbed.getComponents())
				{
					panel.add((JPanel) c);
				}
				return Valida(panel);
			} 
			else 
			{
				// Adiciona somente o JPanel "pai" à List<JPanel>
				if (panel.isEmpty())
					panel.add(pnl);
			}
		}

		// Retorna o resultado do método Valida(List<JPanel)
		return Valida(panel);
	}

	public boolean Valida(JInternalFrame frame, String nome) 
	{
		// Lista de JPanels
		List<JPanel> panel = new ArrayList<JPanel>();
		// JPanel "pai"
		JPanel pnl = (JPanel) frame.getLayeredPane().getComponent(0);

		// Percorre todos os Components do JPanel "pai"
		for (Component comp : pnl.getComponents())
		{
			// Verifica se possuí um JTabbedPane
			if (comp instanceof JTabbedPane) 
			{
				JTabbedPane tabbed = (JTabbedPane) comp;
				// Adiciona todos os JPanels do JTabbedPane à List<JPanel>
				for (Component c : tabbed.getComponents()) 
				{
					// Verifica se o Nome do component é igual ao parâmetro
					if (c.getName().equals(nome))
						panel.add((JPanel) c);
				}
				return Valida(panel);
			} 
			else 
			{
				// Adiciona somente o JPanel "pai" à List<JPanel>
				if (panel.isEmpty())
					panel.add(pnl);
			}
		}

		// Retorna o resultado do método Valida(List<JPanel)
		return Valida(panel);
	}

	private boolean Valida(List<JPanel> panel) 
	{
		// Seleciona todos os JPanels do List<JPanel>
		for (JPanel pnl : panel) 
		{
			Valida(pnl);
		}
		// Verifica se a String de erros está vazia
		if (getErro().isEmpty())
			// Retorna "false" - sem erros
			return false;
		else
			// Retorna "true" com erros
			return true;
	}

	private void Valida(JPanel panel)
	{
		// Percorre todos os Components do JPanel informado
		for (Component comp : panel.getComponents()) 
		{
			// Verifica se é outro JPanel encadeado
			if (comp instanceof JPanel) 
			{
				// Recursividade para refinar a validação
				Valida((JPanel) comp);
			} 
			else 
			{
				// Verifica se o component é um JTextField somente
				if (comp instanceof JTextField && !(comp instanceof JFormattedTextField) && !(comp instanceof JTextArea)) 
				{
					Valida((JTextField) comp);
				}
				// Verifica se o Component é um JTextArea
				if (comp instanceof JTextArea) 
				{
					Valida((JTextArea) comp);
				}
				// Verifica se o Component é JFormattedTextField
				if (comp instanceof JFormattedTextField) 
				{
					Valida((JFormattedTextField) comp);
				}
			}
		}
	}

	private void Valida(JTextField txt)
	{
		// Verifica se está em branco
		if (txt.getText().isEmpty()) 
		{
			// Verifica se a String de erro esta vazia
			if (getErro().isEmpty()) 
			{
				// Inicializa a String de erro
				setErro("Erro - Preencha os campos abaixo:\n");
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			} 
			else 
			{
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			}
		}
	}

	private void Valida(JTextArea txt) 
	{
		// Verifica se está em branco
		if (txt.getText().isEmpty()) 
		{
			// Verifica se a String de erro esta vazia
			if (getErro().isEmpty()) 
			{
				// Inicializa a String de erro
				setErro("Erro - Preencha os campos abaixo:\n");
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			} 
			else
			{
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			}
		}
	}

	private void Valida(JFormattedTextField txt) 
	{
		// Verifica se está em branco
		if (txt.getText().substring(2, txt.getText().length()).replaceAll("\\s+", "").isEmpty()) {
			// Verifica se a String de erro esta vazia
			if (getErro().isEmpty()) 
			{
				// Inicializa a String de erro
				setErro("Erro - Preencha os campos abaixo:\n");
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			} 
			else 
			{
				// Adiciona o nome do Component que está em branco na String
				setErro(getErro() + txt.getName() + "\n");
			}
		}
	}
}
