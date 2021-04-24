package mpl;

public enum ServiceType {

    CART("temp-mpl-cart.mpl.com"),
    CHEKOUT("mpl-cart.mpl.com");

    String url;
    ServiceType(String url){
        this.url = url;
    }

    public String getUrl(){

        return this.url;
    }
}

/**
 cluster = temp
 List<ServiceType>
 configURLs.json
 [
    servies: {
        serviceType: CART
        cart: {
        url:
    }
 }
 ]

 Pojo:

 class Services {
    String serviceType;
    String serviceType;
 }

 */