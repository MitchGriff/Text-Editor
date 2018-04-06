package edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import views.NewJFrame;

/**
 *
 * @author mitchellgriffith
 */
public class Edit {

  private final NewJFrame frame = new NewJFrame();

  private static JFileChooser getFileChooser() {
    JFileChooser chooser = new JFileChooser();

    // specify where chooser should open up
    chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

    // define a set of "Editable Files" files by extension
    chooser.addChoosableFileFilter(
        new FileNameExtensionFilter("Editable Files", "txt")
    );

    // do not accept "All Files"
    chooser.setAcceptAllFileFilterUsed(false);

    return chooser;
  }

  public Edit() {
    frame.setTitle(getClass().getSimpleName());
    frame.setLocationRelativeTo(null);
    frame.setSize(600, 600);

    // set fields not editable
    frame.getEdited().setEditable(false);
    frame.getFileName().setEditable(false);
    frame.getSaveMenuItem().setEnabled(false);
    frame.getSaveAsMenuItem().setEnabled(false);

    frame.getTextArea().addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        frame.getEdited().setText("*****Changes Have Not Been Saved*****");
      }

      @Override
      public void keyPressed(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });

    frame.getOpenMenuItem().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = getFileChooser();

        // invoke the chooser dialog for opening a file
        int status = chooser.showOpenDialog(frame);

        // test for approval
        if (status != JFileChooser.APPROVE_OPTION) {
          return;
        }
        File file = chooser.getSelectedFile();
        Path path = file.toPath();

        try {
          System.out.println("\n--------- Load -------------");
          System.out.println("full path: " + path);
          String base = file.getName();
          System.out.println("base name = " + base);
          Path work = Paths.get(System.getProperty("user.dir"));
          System.out.println("working path: " + work);
          Path rel = work.relativize(path);
          System.out.println("relative path: " + rel);
          String content = new String(Files.readAllBytes(path));
          
          if(path.toString().indexOf("subdir") != -1){
            frame.getFileName().setText("subdir/" + base);
          }
          else
            frame.getFileName().setText(base);
          
          frame.getTextArea().setText(content);
          frame.getTextArea().setCaretPosition(0);
          frame.getSaveMenuItem().setEnabled(true);
          frame.getSaveAsMenuItem().setEnabled(true);
        }
        catch (IOException ex) {
          ex.printStackTrace(System.err);
          JOptionPane.showMessageDialog(frame, "Cannot open file " + file);
        }

      }
    });

    frame.getNewMenuItem().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.getFileName().setText("<NEW FILE>");
        frame.getTextArea().setText("");
        frame.getSaveAsMenuItem().setEnabled(true);
        frame.getSaveMenuItem().setEnabled(false);
      }
    });

    frame.getSaveMenuItem().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try {
          System.out.println("\n--------- Save -------------");
          File file = new File(Paths.get(System.getProperty("user.dir")).toString() + "/" + frame.getFileName().getText()); // "/" for mac
          System.out.println("File: " + file);
          Path path = file.toPath();
          System.out.println("full path: " + path);
          String base = file.getName();
          System.out.println("base name = " + base);
          Path work = Paths.get(System.getProperty("user.dir"));
          System.out.println("working path: " + work);
          Path rel = work.relativize(path);
          System.out.println("relative path: " + rel);
          String content = frame.getTextArea().getText();
          Files.write(path, content.getBytes());
          frame.getEdited().setText("");
        }
        catch (Exception ex) {
          ex.printStackTrace(System.err);
          JOptionPane.showMessageDialog(frame, "Cannot save file " + frame.getFileName().getText());
        }

      }
    });

    frame.getSaveAsMenuItem().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = getFileChooser();

        // invoke the chooser dialog for opening a file
        int status = chooser.showSaveDialog(frame);

        // test for approval
        if (status != JFileChooser.APPROVE_OPTION) {
          return;
        }

        File file = chooser.getSelectedFile();
        Path path = file.toPath();

        if (file.exists()) {
          String m = "OK to overwrite existing file?";
          String t = "Choose an Option";
          int choice = JOptionPane.showConfirmDialog(null, m, t, JOptionPane.YES_NO_CANCEL_OPTION);
          if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
            return;
          }
        }

        try {
          //add .txt if file doesnt have an extension
          if (!file.getName().contains(".")) {
            file = new File(file + ".txt");
            path = file.toPath();
          }

          System.out.println("\n--------- Save to -------------");
          System.out.println("full path: " + path);
          String base = file.getName();
          System.out.println("base name = " + base);
          Path working = Paths.get(System.getProperty("user.dir"));
          System.out.println("working path: " + working);
          Path relative = working.relativize(path);
          System.out.println("relative path: " + relative);
          String content = frame.getTextArea().getText();
          Files.write(path, content.getBytes());
          frame.getEdited().setText("");
          if(path.toString().indexOf("subdir") != -1){
            frame.getFileName().setText("subdir/" + base);
          }
          else
            frame.getFileName().setText(base);
          frame.getSaveMenuItem().setEnabled(true);
        }
        catch (IOException ex) {
          ex.printStackTrace(System.err);
          JOptionPane.showMessageDialog(frame, "Cannot open file " + file);
        }
      }
    }
    );

    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent evt
      ) {
        if (!(frame.getEdited().getText().equals(""))) {
          String m = "OK to discard changes?";
          String t = "Choose an Option";
          int choice = JOptionPane.showConfirmDialog(null, m, t, JOptionPane.YES_NO_CANCEL_OPTION);
          if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
          }
          else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
            frame.setDefaultCloseOperation(NewJFrame.DO_NOTHING_ON_CLOSE);
          }
        }
      }
    }
    );
  }

  public static void main(String[] args) {
    System.setProperty("apple.eawt.quitStrategy", "CLOSE_ALL_WINDOWS");
    Edit app = new Edit();
    app.frame.setVisible(true);
  }
}
