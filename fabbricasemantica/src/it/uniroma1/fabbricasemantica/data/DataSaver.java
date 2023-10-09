package it.uniroma1.fabbricasemantica.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che si occupa del dalvataggio dei dati ricevuti dai task. Verra' usata all'interno delle servlet di annotazione.
 * I database sono file di tipo csv. 1 record per riga.
 * @author Joan
 */
public class DataSaver 
{
	/**
	 * Percorso in cui salvare i dati.
	 */
	private String path;
	
	/**
	 * Costruttore della classe. Prende in input il percorso.
	 * Verra' usato nelle servlet di annotazione passando in input il percorso ricavato con il metodo getServletContext().getRealPath("path").
	 * @param path percorso del file in cui salvare i dati.
	 */
	public DataSaver(String path)
	{
		this.path = path;
	}

	/**
	 * Prende in input una lista di stringhe (i valori del form), costruisce un record per il file csv, 
	 * e lo aggiunge in coda al file dato dal @campo path.
	 * Se nel record ci sono parametri null, non viene aggiunto al database.
	 * @param parameters
	 */
	public void save(List<String> parameters)
	{
		if (parameters.stream().anyMatch( s -> s == null )) return;
		
		String csv = parameters.stream().collect(Collectors.joining(",", "", "\n"));
		
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8, StandardOpenOption.APPEND))
		{
			bw.append(csv);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
}
