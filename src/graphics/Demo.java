package graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

 

public class Demo extends JFrame{

    public Demo() {

    super("Auto-Scroll JTextArea");

    this.setSize(500, 300);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setResizable(true);

    this.setVisible(true);

 

    // We create a TextArea object

    final JTextArea textArea = new JTextArea(5, 30);

    // We put the TextArea object in a Scrollable Pane

    JScrollPane scrollPane = new JScrollPane(textArea);

 

    // In order to ensure the scroll Pane object appears in your window,

    // set a preferred size to it!

    scrollPane.setPreferredSize(new Dimension(380, 100));
    scrollPane.getViewport().setOpaque(true);
    scrollPane.getViewport().setBackground(Color.RED);

 

    // Lines will be wrapped if they are too long to fit within the

    // allocated width

    textArea.setLineWrap(true);

 

    // Lines will be wrapped at word boundaries (whitespace) if they are

    // too long to fit within the allocated width

    textArea.setWrapStyleWord(true);

 

    // Assuming this is the chat client's window where we read text sent out

    // and received, we don't want our Text Area to be editable!

    textArea.setEditable(false);

 

    // We also want a vertical scroll bar on our pane, as text is added to it

    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

 

    // Now let's just add a Text Field for user input, and make sure our

    // text area stays on the last line as subsequent lines are

    // added and auto-scrolls

    final JTextField userInputField = new JTextField(30);

    userInputField.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent event){

        //We get the text from the textfield

        String fromUser = userInputField.getText();

 

        if (fromUser != null) {

            //We append the text from the user

            textArea.append("Asim: " + fromUser + "\n");

 

            //The pane auto-scrolls with each new response added

            textArea.setCaretPosition(textArea.getDocument().getLength());

            //We reset our text field to "" each time the user presses Enter

            userInputField.setText("");

        }

        }

    });

 

    this.setLayout(new FlowLayout());

    //adds and centers the text field to the frame

    this.add(userInputField, SwingConstants.CENTER);

    //adds and centers the scroll pane to the frame

    this.add(scrollPane, SwingConstants.CENTER);

    }

 
}
