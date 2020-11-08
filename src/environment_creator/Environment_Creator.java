/*
 * @Autor: Pragmatic Coder
 * @Repositorio : https://github.com/Zelechos/Pragmatic_Java
*/
package environment_creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Environment_Creator {

        File MainDirectory;
        File DirectoryCss;
        File DirectoryJs;
        File DirectoryImg;
        File FileHtml;
        File FileJs;
        File FileCss;
        File FileREADME;
        
        FileWriter Readme;
        FileWriter Html;
        FileWriter Css;
        FileWriter Js;
        
        
        private String AbsolutePath = "";
        private String AbsolutePathJS = "";
        private String AbsolutePathCSS = "";
        private String AbsolutePathIMG = "";
        private String PathJs = "";
        private String PathCss = "";
        private String PathHtml = "";
        private String PathReadme = "";
        private String Name;
        
        private Texts Contenido = new Texts();

    private void CreateFile(){
        FileJs = new File(PathJs);
        FileCss = new File(PathCss);
        FileHtml = new File(PathHtml);
        FileREADME = new File(PathReadme);


            try {
                if(FileJs.createNewFile() && FileCss.createNewFile() && FileHtml.createNewFile() && FileREADME.createNewFile()){
                     System.out.println("The File "+FileJs.getName()+" has been created successfully . . . ");
                     System.out.println("The File "+FileCss.getName()+" has been created successfully . . . ");
                     System.out.println("The File "+FileHtml.getName()+" has been created successfully . . . ");
                     System.out.println("The File "+FileREADME.getName()+" has been created successfully . . . ");
                }   
            } catch (IOException ex) {
                System.err.println("Error the file has not been created : "+ex);
            }
    }
    
    private void WriteFile(){
        
            try {
                Readme = new FileWriter(FileREADME);
                Html = new FileWriter(FileHtml);
                Css = new FileWriter(FileCss);
                Js = new FileWriter(FileJs);
                Readme.write(String.valueOf(Contenido.getContent().get(0)));
                Readme.close();
                Html.write(String.valueOf(Contenido.getContent().get(1)));
                Html.close();
                Css.write(String.valueOf(Contenido.getContent().get(2)));
                Css.close();
                Js.write(String.valueOf(Contenido.getContent().get(3)));
                Js.close();
            } catch (IOException ex) {
                System.err.println("Error could not write to file ..."+ex);
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
        AbsolutePathIMG += AbsolutePath+"\\Img";

        
        PathHtml += AbsolutePath+"\\index.html";
        PathReadme += AbsolutePath+"\\README.md";
        
        if(MainDirectory.mkdir()){
            System.out.println("The Directory has been created successfully . . . ");
        }else{
            System.err.println("Error the Directory has not been created");
        }
        
    }
    
    private void CreateSubDirectory(){
        DirectoryJs = new File(AbsolutePathJS);
        DirectoryCss = new File(AbsolutePathCSS);
        DirectoryImg = new File(AbsolutePathIMG);
        PathJs += AbsolutePathJS+"\\script.js";
        PathCss += AbsolutePathCSS+"\\style.css";
        
        if(DirectoryJs.mkdir() && DirectoryCss.mkdir() && DirectoryImg.mkdir()){
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
        environment.WriteFile();
        
    }
    
}
