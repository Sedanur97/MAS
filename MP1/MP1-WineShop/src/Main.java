import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Wine wine1 = new Wine(1,"seda",LocalDate.of(2012, 1, 13));
        //extend
        Wine.getExtent();
        Wine.saveExtent();
        Wine.loadExtent();
//         Override method toString()
        Wine wine2 = new Wine(2,"baltic wine", LocalDate.of(1950, 1, 13));
        Wine wine3 = new Wine(3, "uzumlu wine", LocalDate.of(2021, 1, 13));

       // System.out.println(Wine.findRedWines(TypeOfWine.Red));

        System.out.println(wine1 + " \n\n" + wine2 + " \n\n" + wine3);

        wine2.setTypeOfWine(TypeOfWine.White);
        wine3.setTypeOfWine(TypeOfWine.Red);
        wine1.setTypeOfWine(TypeOfWine.Rose);


        System.out.println("Type of wines:");
        System.out.println(wine1.getTypeOfWine());
        System.out.println(wine2.getTypeOfWine());
        System.out.println(wine3.getTypeOfWine());
        System.out.println("find the red wine");

        System.out.println(" ");

      //  System.out.println("find red wines : " + Wine.findRedWines(TypeOfWine.Red));


        //System.out.println(Wine.findRedWines(TypeOfWine.Red));
        System.out.println();
        wine1.addCountry("French");
        wine2.addCountry("Polish");
        wine3.addCountry("Turkish");
        System.out.println("made of Countries of wines");
        System.out.println( wine1.getCountry());
        System.out.println( wine2.getCountry());
        System.out.println( wine3.getCountry());

        System.out.println();
        System.out.println(" ");

        // price cannot be less than $90k
        wine1.setPrice(2000);
        System.out.println("Price of wine : " + wine1.getPrice());
        wine1.setSalePrice(3050);
        System.out.println("Profit is " + wine1.getProfit());

        System.out.println();

        Product product1 = new Product();
        product1.setIngredients("uzum");
        product1.setLitterOfBottle(1L);
        Wine wine4 = new Wine(4, "fashion", LocalDate.of(2013, 1, 13), "italy", 123 , 200, product1);
        System.out.println("\n");
        System.out.println("\nWine with mandatory attributes: " + wine4.toString() + "\nWine with optional attributes: " +
                wine1.toString());
        System.out.println();
        System.out.println("*************************");
        Wine.addBrandsOfWine("Kayra");
        Wine.addBrandsOfWine("Turnau Riesling");
        Wine.addBrandsOfWine("Louis Roederer");
        System.out.println("Brands of wines" + "\n" +Wine.getBrandsOfWine());
        Wine.removeBrandsOfWine("Louis Roederer");
        System.out.println();
        System.out.println("after remove the Brands of wines" + "\n" +Wine.getBrandsOfWine());
        System.out.println();

        System.out.println("\n");
        System.out.println("find by year made of date");
        //class method
        System.out.println(Wine.findByYearOfDate(2012));



    }
}
