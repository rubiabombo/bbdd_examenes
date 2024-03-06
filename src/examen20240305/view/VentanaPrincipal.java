package examen20240305.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen20240305.controller.ControladorCategoria;
import examen20240305.controller.ControladorProducto;
import examen20240305.model.Categoria;
import examen20240305.model.Producto;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JtfId;
	private JTextField jtfcodigo;
	private JTextField jtfNombre;
	private JTextField jtfFechacad;
	private JTextField jtfunidades;
	private JComboBox<Producto> jcbProducto;
	private JComboBox<Categoria> jcbCategoria;
	private JButton CargarProductos;
	private JButton VerProducto;
	private JButton guardar;
	JCheckBox checkPerecedero;
	private Object jtfidCategoria;
	private Object jtfFechaCaducidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestión de productos de supermercado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 1;
		contentPane.add(lblCategoria, gbc_lblCategoria);
		
		JComboBox jcbCategoria = new JComboBox();
		GridBagConstraints gbc_jcbCategoria = new GridBagConstraints();
		gbc_jcbCategoria.gridwidth = 7;
		gbc_jcbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCategoria.gridx = 3;
		gbc_jcbCategoria.gridy = 1;
		contentPane.add(jcbCategoria, gbc_jcbCategoria);
		
		JButton jbtnCargarProductos = new JButton("Cargar productos");
		GridBagConstraints gbc_jbtnCargarProductos = new GridBagConstraints();
		gbc_jbtnCargarProductos.gridwidth = 3;
		gbc_jbtnCargarProductos.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnCargarProductos.gridx = 10;
		gbc_jbtnCargarProductos.gridy = 1;
		contentPane.add(jbtnCargarProductos, gbc_jbtnCargarProductos);
		
		JLabel jlabelProducto = new JLabel("Producto: ");
		GridBagConstraints gbc_jlabelProducto = new GridBagConstraints();
		gbc_jlabelProducto.anchor = GridBagConstraints.EAST;
		gbc_jlabelProducto.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelProducto.gridx = 2;
		gbc_jlabelProducto.gridy = 2;
		contentPane.add(jlabelProducto, gbc_jlabelProducto);
		
		JComboBox jcbProducto = new JComboBox();
		GridBagConstraints gbc_jcbProducto = new GridBagConstraints();
		gbc_jcbProducto.gridwidth = 7;
		gbc_jcbProducto.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProducto.gridx = 3;
		gbc_jcbProducto.gridy = 2;
		contentPane.add(jcbProducto, gbc_jcbProducto);
		
		JButton jbtnVerProducto = new JButton("Ver producto");
		GridBagConstraints gbc_jbtnVerProducto = new GridBagConstraints();
		gbc_jbtnVerProducto.gridwidth = 3;
		gbc_jbtnVerProducto.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnVerProducto.gridx = 10;
		gbc_jbtnVerProducto.gridy = 2;
		contentPane.add(jbtnVerProducto, gbc_jbtnVerProducto);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 14;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel jlbldatosProducto = new JLabel("Datos del producto");
		jlbldatosProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbldatosProducto = new GridBagConstraints();
		gbc_jlbldatosProducto.gridwidth = 16;
		gbc_jlbldatosProducto.insets = new Insets(0, 0, 5, 0);
		gbc_jlbldatosProducto.gridx = 0;
		gbc_jlbldatosProducto.gridy = 0;
		panel.add(jlbldatosProducto, gbc_jlbldatosProducto);
		
		JLabel jlblId = new JLabel("Id:");
		GridBagConstraints gbc_jlblId = new GridBagConstraints();
		gbc_jlblId.anchor = GridBagConstraints.EAST;
		gbc_jlblId.insets = new Insets(0, 0, 5, 5);
		gbc_jlblId.gridx = 1;
		gbc_jlblId.gridy = 1;
		panel.add(jlblId, gbc_jlblId);
		
		JtfId = new JTextField();
		JtfId.setEditable(false);
		JtfId.setEnabled(false);
		GridBagConstraints gbc_JtfId = new GridBagConstraints();
		gbc_JtfId.gridwidth = 12;
		gbc_JtfId.insets = new Insets(0, 0, 5, 5);
		gbc_JtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_JtfId.gridx = 2;
		gbc_JtfId.gridy = 1;
		panel.add(JtfId, gbc_JtfId);
		JtfId.setColumns(10);
		
		JLabel JlblCodigo = new JLabel("Código: ");
		GridBagConstraints gbc_JlblCodigo = new GridBagConstraints();
		gbc_JlblCodigo.anchor = GridBagConstraints.EAST;
		gbc_JlblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_JlblCodigo.gridx = 1;
		gbc_JlblCodigo.gridy = 2;
		panel.add(JlblCodigo, gbc_JlblCodigo);
		
		jtfcodigo = new JTextField();
		GridBagConstraints gbc_jtfcodigo = new GridBagConstraints();
		gbc_jtfcodigo.gridwidth = 12;
		gbc_jtfcodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfcodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfcodigo.gridx = 2;
		gbc_jtfcodigo.gridy = 2;
		panel.add(jtfcodigo, gbc_jtfcodigo);
		jtfcodigo.setColumns(10);
		
		JLabel JlblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_JlblNombre = new GridBagConstraints();
		gbc_JlblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_JlblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_JlblNombre.gridx = 1;
		gbc_JlblNombre.gridy = 3;
		panel.add(JlblNombre, gbc_JlblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 12;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 3;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.EAST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 5;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel JlblPerecedero = new JLabel("Perecedero");
		GridBagConstraints gbc_JlblPerecedero = new GridBagConstraints();
		gbc_JlblPerecedero.insets = new Insets(0, 0, 5, 5);
		gbc_JlblPerecedero.gridx = 3;
		gbc_JlblPerecedero.gridy = 5;
		panel.add(JlblPerecedero, gbc_JlblPerecedero);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Caducidad: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfFechacad = new JTextField();
		GridBagConstraints gbc_jtfFechacad = new GridBagConstraints();
		gbc_jtfFechacad.gridwidth = 12;
		gbc_jtfFechacad.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechacad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechacad.gridx = 2;
		gbc_jtfFechacad.gridy = 6;
		panel.add(jtfFechacad, gbc_jtfFechacad);
		jtfFechacad.setColumns(10);
		
		JLabel JlblUnidadesenstock = new JLabel("Unidades en Stock: ");
		GridBagConstraints gbc_JlblUnidadesenstock = new GridBagConstraints();
		gbc_JlblUnidadesenstock.anchor = GridBagConstraints.EAST;
		gbc_JlblUnidadesenstock.insets = new Insets(0, 0, 5, 5);
		gbc_JlblUnidadesenstock.gridx = 1;
		gbc_JlblUnidadesenstock.gridy = 7;
		panel.add(JlblUnidadesenstock, gbc_JlblUnidadesenstock);
		
		jtfunidades = new JTextField();
		GridBagConstraints gbc_jtfunidades = new GridBagConstraints();
		gbc_jtfunidades.gridwidth = 12;
		gbc_jtfunidades.insets = new Insets(0, 0, 5, 5);
		gbc_jtfunidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfunidades.gridx = 2;
		gbc_jtfunidades.gridy = 7;
		panel.add(jtfunidades, gbc_jtfunidades);
		jtfunidades.setColumns(10);
		
		JButton jbtnguardar = new JButton("Guardar");
		jbtnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}

			private void guardar() {
				Producto o = (Producto) VentanaPrincipal.this.jcbProducto.getSelectedItem();
				o.setNombre(jtfNombre.getText());
				
				
			}
		});
		GridBagConstraints gbc_jbtnguardar = new GridBagConstraints();
		gbc_jbtnguardar.gridwidth = 16;
		gbc_jbtnguardar.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnguardar.gridx = 0;
		gbc_jbtnguardar.gridy = 8;
		panel.add(jbtnguardar, gbc_jbtnguardar);

	}
	/**
	 * 
	 */
	private void cargarProducto() {
		Producto p =	(Producto) this.jcbProducto.getSelectedItem();
		
		this.jcbCategoria.removeAllItems();
		
		List<Categoria> categorias = ControladorCategoria.findAllByIdCentro(p.getId());
		for (Categoria c: categorias) {
			this.jcbCategoria.addItem(c);
		}
	}
	
	/**
	 * 
	 */
	private void cargarCategoria() {
		Categoria c = (Categoria) this.jcbProducto.getSelectedItem();
		
		this.jcbCategoria.removeAllItems();
		
		List<Producto> productos = ControladorProducto.findAllByIdCategorial(c.getId());
		for (Producto p : productos) {
			this.jcbProducto.addItem(p);
		}
	}
	
	/**
	 * 
	 */
	private void cargarDatosProducto() {
		Producto p = (Producto) this.jcbProducto.getSelectedItem();
		
		if (p!= null) {
			this.JtfId.setText("" + p.getId());
			this.jtfNombre.setText(p.getNombre());
			this.jtfcodigo.setText(p.getCodigo());
	
		}
	}
	
	
	private Object Timestamp(Date fechaCaducidad) {
		// TODO Auto-generated method stub
		return null;
	}

	private void jtfidCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void guardarProductod() {
		
		if (!isCodigoValido()) {
			JOptionPane.showMessageDialog(null, "El código indicado no tiene al menos tres letras");
			return;
		}
		
		if (!isUrlValida()) {
			JOptionPane.showMessageDialog(null, "La url debe comenzar por http o https");
			return;
		}
		
		Producto p = new Producto();
		
		p.setId(Integer.parseInt(this.JtfId.getText()));
		p.setCodigo(this.jtfcodigo.getText());
		p.setNombre(this.jtfNombre.getText());
		
		
		p.setPerecedero1(this.checkPerecedero.isSelected());
		
		if (ControladorProducto.modificar(p) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido () {
		String codigo = this.jtfcodigo.getText();
		int contLetras = 0;
		
		for (int i = 0; i < codigo.length(); i++) {
			if (Character.isLetter(codigo.charAt(i))) {
				contLetras++;
			}
		}
		
		if (contLetras > 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isUrlValida() {
		String url = this.jtfcodigo.getText().toUpperCase();
		if (url.startsWith("HTTP") || url.startsWith("HTTPS")) {
			return true;
		}
		return false;
	}
	}
	

