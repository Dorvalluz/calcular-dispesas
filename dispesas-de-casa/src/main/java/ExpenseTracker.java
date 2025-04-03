import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ExpenseTracker {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExpenseTracker::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Despesas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        String[] columnNames = {"Descrição", "Valor (R$)", "Porcentagem"};
        Object[][] data = {
                {"LUZ", "", ""},
                {"AGUA", "", ""},
                {"INTERNET", "", ""},
                {"GAZ", "", ""},
                {"LAZER", "", ""},
                {"INVESTIMENTOS", "", ""},
                {"FARMACIA", "", ""},
                {"TRANSPORTE", "", ""},
                {"SUPERMERCADO", "", ""},
                {"FINANCIAMENTOS", "", ""},
                {"PERFUMARIA", "", ""},
                {"ACADEMIA", "", ""},
                {"SERVIÇO DE STREAMING", "", ""},
                {"REMEDIOS", "", ""},
                {"CURSOS", "", ""},
                {"TOTAL", "R$ 0,00", "100%"} // Linha para o total
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
                    pasteClipboardData(model);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton calculateButton = new JButton("Calcular Total e Porcentagem");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal(model);
            }
        });

        JButton clearButton = new JButton("Limpar Valores");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.getRowCount() - 1; i++) {
                    model.setValueAt("", i, 1);
                    model.setValueAt("", i, 2);
                }
                model.setValueAt("R$ 0,00", model.getRowCount() - 1, 1);
                model.setValueAt("100%", model.getRowCount() - 1, 2);
            }
        });

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void calcularTotal(DefaultTableModel model) {
        double total = 0;
        NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));

        for (int i = 0; i < model.getRowCount() - 1; i++) {
            try {
                String valueStr = model.getValueAt(i, 1).toString().replace("R$", "").replace(".", "").replace(",", ".").trim();
                if (!valueStr.isEmpty()) {
                    total += Double.parseDouble(valueStr);
                }
            } catch (Exception ignored) {
                // Ignora erros de conversão
            }
        }

        // Define o total corretamente formatado
        DecimalFormat df = new DecimalFormat("#,##0.00");
        model.setValueAt("R$ " + df.format(total).replace(".", ","), model.getRowCount() - 1, 1);

        // Calcular porcentagem
        for (int i = 0; i < model.getRowCount() - 1; i++) {
            try {
                String valueStr = model.getValueAt(i, 1).toString().replace("R$", "").replace(".", "").replace(",", ".").trim();
                if (!valueStr.isEmpty() && total > 0) {
                    double value = Double.parseDouble(valueStr);
                    double percentage = (value / total) * 100;
                    model.setValueAt(String.format("%.2f%%", percentage), i, 2);
                } else {
                    model.setValueAt("0.00%", i, 2);
                }
            } catch (Exception ignored) {
                model.setValueAt("0.00%", i, 2);
            }
        }
    }

    private static void pasteClipboardData(DefaultTableModel model) {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = clipboard.getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String clipboardText = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                String[] lines = clipboardText.split("\\n");
                for (int i = 0; i < lines.length && i < model.getRowCount() - 1; i++) {
                    String formattedValue = lines[i].replace("R$", "").trim();
                    formattedValue = formattedValue.replace(".", "").replace(",", ".");
                    model.setValueAt("R$ " + formattedValue.replace(".", ","), i, 1);
                }
            }
        } catch (UnsupportedFlavorException | IOException ignored) {
        }
    }
}
