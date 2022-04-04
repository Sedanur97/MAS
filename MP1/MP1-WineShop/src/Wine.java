import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Wine implements Serializable {

    public static final String WINE_EXTENT_SER = "./data/WineExtent.ser";
    private static List <Wine> extent = new ArrayList<>(); // collection
    //mandatory attribute
    private long id;
    private String name;
    private LocalDate yearOfWine;


    //multi-value attribute
    private  List<String> Country = new ArrayList<>();
    private TypeOfWine typeOfWine;

    //optional attributes
    private Integer price;
    private Integer SalePrice;
    //  private Integer Profit;  //not for derrived!
    private Product product;

    //class attribute
    private static Set<String> BrandsOfWine = new HashSet<>();
    // private integer profit; not far derrived


    // All mandatory attributes
    public Wine(long id, String name, LocalDate yearOfWine) {
        this.id = id;
        setName(name);
        setYearOfWine(yearOfWine);
        extent.add(this);
    }

    // All attributes
    public Wine(long id, String name, LocalDate yearOfWine, String Country, Integer price, Integer salePrice, Product product) {
        super();
       // this.id = id;
        setId(id);
        setName(name);
        setYearOfWine(yearOfWine);
        addCountry(Country);
        setPrice(price);
        setSalePrice(salePrice);
        setProduct(product);
        //this.product = product;
        extent.add(this);
    }

    /**
     *  GETTER AND SETTER
     */
    public static List<Wine> getExtent() {
        //return new ArrayList<>(extent); this is other option
        return Collections.unmodifiableList(extent); //utinity class it will create kind of raper
        //it wont allow the change the values
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || "".equals(name.trim())){
            new ValidationException("name can not be null or empty");
        }
        this.name = name;
    }

    public static void setExtent(List<Wine> extent) {
        Wine.extent = extent;
    }

    public LocalDate getYearOfWine() {
        return yearOfWine;
    }

    public void setYearOfWine(LocalDate yearOfWine) {
        if(yearOfWine == null){
            new ValidationException("year of wine can not be null or empty.");
        }
        this.yearOfWine = yearOfWine;
    }

    /**
     * Class method
     */

    public static List<Wine> findByYearOfDate(int year ) {
        LocalDate now = LocalDate.now();
        int difference = year - now.getYear();

        if(difference > 2) {
            throw new RuntimeException("The date must be less than " + (now.getYear() + 2));
        }

        return extent.stream()
                .filter( c -> c.getYearOfWine().getYear() == year)
                .collect(Collectors.toList());
    }

    public List<String> getCountry() {
        return Collections.unmodifiableList(Country);
    }
    public void addCountry (String country){
        if(country == null || "".equals(country.trim()) ){
            new ValidationException("can not be null or empty. and can not be more than 1 country");
        }
        this.Country.add(country);
    }

        public void removeCountry(String country){
        if(this.Country.size()<2 ){
            new RuntimeException("Cannot remove the country.");
        }
        this.Country.remove(country);

    }
    public void setCountry(List<String> country) {
        Country = country;
    }

    public TypeOfWine getTypeOfWine() {
        return typeOfWine;
    }

    public void setTypeOfWine(TypeOfWine typeOfWine) {
        if(typeOfWine == null){
            throw new ValidationException("Invalid input.");
        }
        this.typeOfWine = typeOfWine;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * for sale price getter setter
     *
     * @return
     */
    public Integer getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.SalePrice = salePrice;
    }
/**
 * for price getter setter
 */
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price != null && price <0){
            throw new ValidationException("price can not be smaller than 0");
        }
        this.price = price;
    }

    public Integer getProfit (){
        if(price == null || SalePrice== null){
            return null;
        }
        return SalePrice - price;
    }

    public Wine(Product product){
        this.product=product;
    }

    public static Set<String> getBrandsOfWine() {
        return BrandsOfWine;
    }

    public static void setBrandsOfWine(Set<String> brandsOfWine) {
        Wine.BrandsOfWine = brandsOfWine;
    }
    public static void addBrandsOfWine (String brands){
        if(brands == null || "".equals(brands.trim())){
            new RuntimeException("Invalid input.");
        }
        getBrandsOfWine().add(brands);
    }

    public static void removeBrandsOfWine(String brands){
        if(BrandsOfWine.size()<2){
            new RuntimeException("Cannot remove last brand.");
        }
        BrandsOfWine.remove(brands);
    }





    /**
     * persistence
     */
    public static void saveExtent(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(WINE_EXTENT_SER))){
            oos.writeObject(extent);
        }catch (IOException e){
            e.printStackTrace();
        };
    }
    public static void loadExtent(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(WINE_EXTENT_SER))){
            extent = (List<Wine>)(ois.readObject());
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    @Override
    public String toString() {
        return "\n" +"\nWine: " +  "\nid='" + id +
                ", \nname='" + name +
                ", \nyear of wine='" + yearOfWine +
                ", \ncountry=" + Country +
                ", \ntypeof wine =" + typeOfWine +
                ", \nprice=" + price +
                ", \nsalePrice=" + SalePrice +
                ", \nproduct=" + product;


    }
}
