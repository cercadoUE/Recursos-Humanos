package recursos_humanos;

import javax.swing.*;
import javax.swing.text.*;


public class SeguridadCampos {

    
    public static void bloquearCaracteresPeligrosos(JTextField campoTexto) {
        ((AbstractDocument) campoTexto.getDocument()).setDocumentFilter(new DocumentFilter() {


            private final String caracteresProhibidos = "\"'{}^/?%$#*@[]<>;";

            // Al insertar texto (ej. teclear)
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                string = filtrar(string);
                if (!string.isEmpty()) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            // Al reemplazar texto (ej. pegar)
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                text = filtrar(text);
                if (!text.isEmpty()) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            // Elimina los caracteres prohibidos del texto ingresado
            private String filtrar(String texto) {
                StringBuilder resultado = new StringBuilder();
                for (char c : texto.toCharArray()) {
                    if (caracteresProhibidos.indexOf(c) == -1) {
                        resultado.append(c);
                    }
                }
                return resultado.toString();
            }
        });
    }
}
