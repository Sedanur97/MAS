public class Product {
    private String ingredients;
    private Long LitterOfBottle; //weight


    public Product() {
        //if(ingredients == null){throw new NullPointerException("ingredients can not be null");}
        this.ingredients = ingredients;
        //if(litterOfBottle == null){throw new NullPointerException("Bottle size can not smaller than 150 ml");}
       this.LitterOfBottle = getLitterOfBottle();


    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients (String ingredients) {
        if(ingredients == null || "".equals(ingredients.trim())) {
            new ValidationException("Invalid input.");
        }


        this.ingredients = ingredients;
    }

    public Long getLitterOfBottle() {
        return LitterOfBottle;
    }

    public void setLitterOfBottle(Long litterOfBottle) {
       if(ingredients == null || "".equals(ingredients.trim())) {
            new ValidationException("Invalid input.");
        }

        LitterOfBottle = litterOfBottle;
    }

}
