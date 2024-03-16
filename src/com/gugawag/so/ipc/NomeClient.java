package com.gugawag.so.ipc;

/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Eighth Edition
 */

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class NomeClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket servidorSock = new Socket("127.0.0.1",6014);
			InputStream in = servidorSock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));

			System.out.println("=== Cliente iniciado1 ===");
			System.out.println("=== Walter Filho ===\n");


			String line = bin.readLine();
			System.out.println("O servidor Walter me disse:" + line);

			PrintWriter pout = new PrintWriter(servidorSock.getOutputStream(), true);
			// TODO Altere abaixo para enviar seu nome ao servidor
			pout.println("Walter da Silva Filho");
			servidorSock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
