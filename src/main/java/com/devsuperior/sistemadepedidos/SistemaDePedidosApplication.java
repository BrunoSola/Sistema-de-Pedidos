package com.devsuperior.sistemadepedidos;

import com.devsuperior.sistemadepedidos.model.entities.Order;
import com.devsuperior.sistemadepedidos.model.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class SistemaDePedidosApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Order ex1 = new Order(1034, 150.00, 20.0);
		Order ex2 = new Order(2282, 800.00,10.0);
		Order ex3 = new Order(1309,95.90,0.0);

		System.out.println("Exemplo 1:");
		System.out.println(ex1);
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(ex1));
		System.out.println();
		System.out.println("Exemplo 2:");
		System.out.println(ex2);
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(ex2));
		System.out.println();
		System.out.println("Exemplo 3:");
		System.out.println(ex3);
		System.out.printf("Valor total: R$ %.2f", orderService.total(ex3));
	}
}
