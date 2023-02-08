package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.Departament;
import entites.HourContract;
import entites.Worker;
import entites.enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Stub de método gerado automaticamente
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departamentName = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salario base: ");
		double workerSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), 
				workerSalary, new Departament(departamentName));
		
		System.out.print("Quantos contratos o trabalhador possui: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato Nº" + i );
			System.out.print("Entre com a data: ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valouePerHour = sc.nextDouble();
			System.out.print("Duração: ");
			int hours = sc.nextInt();
			HourContract cantract = new HourContract(contractDate, valouePerHour, hours);
			worker.addContract(cantract);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e o ano (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Salario do periodo" + monthAndYear +": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

	

}
