import com.miller.learn.basicio.ChkFileDirMethods;
import com.miller.learn.basicio.CopyBytes;
import com.miller.learn.basicio.PathMethods;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        ChkFileDirMethods.checkFileAccessibilityAndExistence();
    }
}