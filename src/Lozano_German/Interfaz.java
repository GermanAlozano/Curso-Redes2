/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lozano_German;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estudiante
 */
public class Interfaz extends JFrame implements ActionListener {

    JPanel panel1, panel2, panel3,panel4;
    JTextField nombres, apellidos;
    JLabel sexo, dosisaplicadas,pregunta;
    JRadioButton masculino, femenino, siAutorizo,noAutorizo;
    JTable Tabla;
    DefaultTableModel modelo;
    JScrollPane scrollTabla;
    JCheckBox dosis1, dosis2, dosis3, dosis4, noVacunado;
    JButton guardar, limpiar, salir;
    ImageIcon icon;

    String TitulosTabla[] = {"nombres", "apellidos", "sexo", "dosis "};

    ButtonGroup Grupodosisaplicadas, GrupoSexo, GrupoAutorizacion;

    Interfaz () {
        setLayout(null);
        setTitle("Producto de almacenes");
        setSize(1000, 600);
        getContentPane().setBackground(new Color(216, 224, 232));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // listando paneles 
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(183, 200, 249));
        panel1.setBorder(BorderFactory.createTitledBorder("PANEL 1"));
        panel1.setBounds(40, 30, 420, 150);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(183, 200, 249));
        panel2.setBorder(BorderFactory.createTitledBorder("PANEL 2"));
        panel2.setBounds(40, 265, 925, 170);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(183, 200, 249));
        panel3.setBorder(BorderFactory.createTitledBorder("PANEL 3"));
        panel3.setBounds(490, 30, 470, 220);
        
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBackground(new Color(183,200,249));
        panel4.setBorder(BorderFactory.createTitledBorder("PANEL 4"));
        panel4.setBounds(420, 450, 300, 90);
        
        pregunta = new JLabel(" Autoriza tratamiento de datos sensibles ?");
        pregunta.setBounds(80, 30, 250, 50);

        siAutorizo = new JRadioButton("Si Autorizo");
        siAutorizo.setBackground(new Color(200, 223, 246));
        siAutorizo.setBounds(100, 80, 100, 40);
        siAutorizo.setActionCommand("Si Autorizo");
        siAutorizo.addActionListener(this);

        noAutorizo = new JRadioButton("No Autorizo");
        noAutorizo.setBackground(new Color(200, 223, 246));
        noAutorizo.setBounds(200, 80, 100, 40);
        noAutorizo.setActionCommand("No Autorizo");
        
        GrupoAutorizacion = new ButtonGroup();
        GrupoAutorizacion.add(siAutorizo);
        GrupoAutorizacion.add(noAutorizo);

        nombres = new JTextField();
        nombres.setBorder(BorderFactory.createTitledBorder("NOMBRES"));
        nombres.setBackground(new Color(200, 223, 246));
        nombres.setBounds(40, 30, 200, 40);

        apellidos = new JTextField();
        apellidos.setBorder(BorderFactory.createTitledBorder("APELLIDOS"));
        apellidos.setBackground(new Color(200, 223, 246));
        apellidos.setBounds(40, 80, 200, 40);

        
        sexo = new JLabel("SEXO");
        sexo.setBounds(40, 130, 120, 25);

        masculino = new JRadioButton("Masculino");
        masculino.setBackground(new Color(200, 223, 246));
        masculino.setBounds(40, 160, 120, 20);
        masculino.setActionCommand("Masculino");

        femenino = new JRadioButton("Femenino");
        femenino.setBackground(new Color(200, 223, 246));
        femenino.setBounds(40, 185, 100, 20);
        femenino.setActionCommand("Femenino");
        
        GrupoSexo = new ButtonGroup();
        GrupoSexo.add(masculino);
        GrupoSexo.add(femenino);

        dosisaplicadas = new JLabel("Dosis Aplicadas");
        dosisaplicadas.setBounds(300, 30, 140, 20);

        dosis1 = new JCheckBox("1 Dosis");
        dosis1.setBackground(new Color(200, 223, 246));
        dosis1.setBounds(290, 60, 80, 25);
        dosis1.setActionCommand("1 Dosis");
        
        dosis2 = new JCheckBox("2 Dosis");
        dosis2.setBackground(new Color(200, 223, 246));
        dosis2.setBounds(290, 90, 80, 25);
        dosis2.setActionCommand("2 Dosis");

        dosis3 = new JCheckBox("3 Dosis");
        dosis3.setBackground(new Color(200, 223, 246));
        dosis3.setBounds(290, 120, 80, 25);
        dosis3.setActionCommand("3 Dosis");
        
        dosis4 = new JCheckBox("4 Dosis");
        dosis4.setBackground(new Color(200, 223, 246));
        dosis4.setBounds(290, 150, 80, 25);
        dosis4.setActionCommand("4 Dosis");
        
        noVacunado = new JCheckBox("No vacunado");
        noVacunado.setBackground(new Color(200, 223, 246));
        noVacunado.setBounds(290, 180, 100, 25);
        noVacunado.setActionCommand("No vacunado");

        Grupodosisaplicadas = new ButtonGroup();
        Grupodosisaplicadas.add(dosis1);
        Grupodosisaplicadas.add(dosis2);
        Grupodosisaplicadas.add(dosis3);
        Grupodosisaplicadas.add(dosis4);
        Grupodosisaplicadas.add(noVacunado);

        modelo = new DefaultTableModel(TitulosTabla, 0);
        Tabla = new JTable(modelo);
        scrollTabla = new JScrollPane(Tabla);
        scrollTabla.setBounds(15, 20, 895, 140);
        Tabla.setEnabled(false);

        guardar = new JButton("Guardar");
        guardar.setBackground(new Color(200, 223, 246));
        guardar.setBounds(40, 20, 50, 50);
        guardar.addActionListener(this);

        icon = new ImageIcon("src/IMG/save.png");
        guardar.setIcon(new ImageIcon(icon.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_SMOOTH)));
        
        limpiar = new JButton("Limpiar");
        limpiar.setBackground(new Color(200, 223, 246));
        limpiar.setBounds(120, 20, 50, 50);
        limpiar.addActionListener(this);

        icon = new ImageIcon("src/IMG/clear.png");
        limpiar.setIcon(new ImageIcon(icon.getImage().getScaledInstance(limpiar.getWidth(), limpiar.getHeight(), Image.SCALE_SMOOTH)));
        salir = new JButton("Salir");
        salir.setBackground(new Color(200, 223, 246));
        salir.setBounds(200, 20, 50, 50);
        salir.addActionListener(this);

        icon = new ImageIcon("src/IMG/exit.png");
        salir.setIcon(new ImageIcon(icon.getImage().getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_SMOOTH)));
       
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        
        panel1.add(pregunta);
        panel1.add(siAutorizo);
        panel1.add(noAutorizo);
        
        panel2.add(scrollTabla);
        
        panel3.add(nombres);
        panel3.add(apellidos);
        panel3.add(sexo);
        panel3.add(masculino);
        panel3.add(femenino);
        panel3.add(dosisaplicadas);
        panel3.add(dosis1);
        panel3.add(dosis2);
        panel3.add(dosis3);
        panel3.add(dosis4);
        panel3.add(noVacunado);
        
        panel4.add(guardar);
        panel4.add(limpiar);
        panel4.add(salir);
        

        setVisible(true);
    }

    
    public void limpiar() {
        nombres.setText(null);
        apellidos.setText(null);
        Grupodosisaplicadas.clearSelection();
        GrupoSexo.clearSelection();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(GrupoAutorizacion)) {
            panel3.setVisible(true);
        }else{
//           
        }
        
        if (ae.getSource().equals(salir)) {
            System.exit(0);
            
        }else if (ae.getSource().equals(limpiar)) {
            limpiar();
            
        }else if (ae.getSource().equals(guardar)) {
            
            Object fila [] = new Object[8];
            
            fila [0] = nombres.getText();
            fila [1] = apellidos.getText();
            fila [2] = GrupoSexo.getSelection().getActionCommand();
            fila [3] = Grupodosisaplicadas.getSelection().getActionCommand();
            
            modelo.addRow(fila);
            Tabla.setModel(modelo);
            
        }
    }

}
