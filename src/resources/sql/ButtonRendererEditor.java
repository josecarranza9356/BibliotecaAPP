package resources.sql;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private JPanel panel;
    private JButton editButton;
    private JButton deleteButton;
    private String text;

    public ButtonRendererEditor() {
        panel = new JPanel(new FlowLayout());
        editButton = new JButton("e");
        deleteButton = new JButton("D");

        editButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);

        // Cambiar el color al pasar el cursor sobre el botón Edit
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editButton.setBackground(UIManager.getColor("Button.background"));
            }
        });

        // Cambiar el color al pasar el cursor sobre el botón Delete
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteButton.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteButton.setBackground(UIManager.getColor("Button.background"));
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Aquí puedes poner el código que se ejecutará cuando el botón de editar sea presionado
                System.out.println("Edit button clicked!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Aquí puedes poner el código que se ejecutará cuando el botón de eliminar sea presionado
                System.out.println("Delete button clicked!");
            }
        });

        panel.add(editButton);
        panel.add(deleteButton);
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        text = (value == null) ? "" : value.toString();
        return panel;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            panel.setForeground(table.getSelectionForeground());
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setForeground(table.getForeground());
            panel.setBackground(UIManager.getColor("Button.background"));
        }

        return panel;
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
