package factory_method;

public class Shop extends Website {
    @Override
    public void createWebSite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
