abstract class PrepareRecipe {
    void prepare() {
        boilwater();
        addIngredients();
        addHeat();
        addOther();
    }
    abstract void addIngredients();
    abstract void addOther();
    void boilwater() {
        System.out.println("Boiling water");
    }
    void addHeat() {
        System.out.println("Adding heat");
    }
}

class Tea extends PrepareRecipe {
    void addIngredients() {
        System.out.println("Adding tea leaves");
    }
    void addOther() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends PrepareRecipe {
    void addIngredients() {
        System.out.println("Adding coffee powder");
    }
    void addOther() {
        System.out.println("Adding sugar and milk");
    }
}

class Template {
    public static void main(String args[]) {
        PrepareRecipe tea = new Tea();
        tea.prepare();
    }
}