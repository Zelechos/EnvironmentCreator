package environment_creator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Environment_Creator {

        File MainDirectory;
        File DirectoryCss;
        File DirectoryJs;
        File FileHtml;
        File FileJs;
        File FileCss;
        private String AbsolutePath = "";
        private String AbsolutePathJS = "";
        private String AbsolutePathCSS = "";
        private String PathJs = "";
        private String PathCss = "";
        private String PathHtml = "";
        private String Name;
        
        
    private void CreateFile(){
        FileJs = new File(PathJs);
        FileCss = new File(PathCss);
        FileHtml = new File(PathHtml);
        

            try {
                if(FileJs.createNewFile() && FileCss.createNewFile() && FileHtml.createNewFile()){
                     System.out.println("The File "+FileJs.getName()+" has been created successfully . . . ");
                     System.out.println("The File "+FileCss.getName()+" has been created successfully . . . ");
                     System.out.println("The File "+FileHtml.getName()+" has been created successfully . . . ");
                }   
            } catch (IOException ex) {
                System.err.println("Error the file has not been created : "+ex);
            }
    }
    
    private void CreateDirectory(){
        Scanner scann = new Scanner(System.in);
        System.out.println("Digite el Nombre de su Proyecto : ");
        Name = scann.nextLine();
        MainDirectory =  new File("C:\\Users\\Zelec\\OneDrive\\Desktop\\"+Name);
        AbsolutePath += MainDirectory.getAbsolutePath();
        AbsolutePathJS += AbsolutePath+"\\JS";
        AbsolutePathCSS += AbsolutePath+"\\CSS";

        
        PathHtml += AbsolutePath+"\\index.html";
        
        if(MainDirectory.mkdir()){
            System.out.println("The Directory has been created successfully . . . ");
        }else{
            System.err.println("Error the Directory has not been created");
        }
        
    }
    
    private void CreateSubDirectory(){
        DirectoryJs = new File(AbsolutePathJS);
        DirectoryCss = new File(AbsolutePathCSS);
        PathJs += AbsolutePathJS+"\\script.js";
        PathCss += AbsolutePathCSS+"\\style.css";
        
        if(DirectoryJs.mkdir() && DirectoryCss.mkdir()){
            System.out.println("The Directorys has been created successfully . . . ");
        }else{
            System.err.println("Error the Directorys has not been created");
        }
        
    }
    
        
    public static void main(String[] args) {

        Environment_Creator environment = new Environment_Creator();
        
        environment.CreateDirectory();
        environment.CreateSubDirectory();
        environment.CreateFile();
        
        
        
    }
    
}
