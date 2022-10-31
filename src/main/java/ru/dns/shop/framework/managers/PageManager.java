package ru.dns.shop.framework.managers;

import ru.dns.shop.framework.pages.*;


public class PageManager {

    private static PageManager INSTANCE = null;


    private StartPage startPage;
    private CartPage cartPage;
    private ListOfProductsPage listOfProductsPage;
    private  ProductPage productPage;




    private PageManager(){
    }

    public static PageManager getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public ListOfProductsPage getListOfProductsPage() {
        if (listOfProductsPage == null) {
            listOfProductsPage = new ListOfProductsPage();
        }
        return listOfProductsPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }


}
