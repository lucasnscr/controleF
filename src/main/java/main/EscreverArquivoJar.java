package main;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

//Escrever um arquivo num jar
public class EscreverArquivoJar {
	
	public static void main(String[] args) throws IOException {
		Path caminhoJar = Paths.get("um.jar");
		FileSystem fs = FileSystems.newFileSystem(caminhoJar, null);
		Path caminhoArquivo = fs.getPath("arquivo.txt");
		
		List<String> letras = new ArrayList<String>();
		letras.add("A");
		letras.add("B");
		letras.add("C");
		
		Files.write(caminhoArquivo, letras, StandardOpenOption.APPEND);
		fs.close();
		
	}

}
