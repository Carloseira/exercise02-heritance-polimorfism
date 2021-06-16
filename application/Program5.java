package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program5 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = input.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char answer = input.next().charAt(0);
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Price: ");
			double price = input.nextDouble();
			if (answer == 'c') {
				list.add(new Product(name, price));
			}
			else if (answer == 'u') {
				System.out.print("Manufactured date: ");
				Date manufacturedDate = sdf.parse(input.next());
				list.add(new UsedProduct(name, price, manufacturedDate));
			}
			else {
				System.out.print("Customs fee: ");
				double customsFee = input.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println();
		System.out.println("---------PRICE TAGS---------");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		
		input.close();
	}

}
