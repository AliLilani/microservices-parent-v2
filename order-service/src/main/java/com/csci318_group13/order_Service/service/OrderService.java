

package com.csci318_group13.order_Service.service;

//import com.csci318_group13.order_Service.domain.model.aggregates.MyOrder;
import com.csci318_group13.order_Service.repository.SalesOrderRepository;
import com.csci318_group13.order_Service.repository.ProductRepository;
        import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final SalesOrderRepository salesOrderRepository;
    private final ProductRepository productRepository ;
    private final RestTemplate restTemplate;

    public OrderService(SalesOrderRepository salesOrderRepository, ProductRepository productRepository  , RestTemplate restTemplate ) {
        this.salesOrderRepository = salesOrderRepository;
        this.restTemplate = restTemplate;
        this.productRepository = productRepository ;
    }
/*
    public List<MyOrder> getAllProducts() {
        return salesOrderRepository.findAll();
    }

 */
/*
    public MyOrder getProduct(String id) {

        Long longId = Long.valueOf(id);


        return salesOrderRepository.findById((longId)).orElseThrow();
    }

 */
/*
    public MyOrder addProduct(MyOrder myOrder) {

        // here the order will have customer id ,list of product ids and son

        return salesOrderRepository.save(myOrder);
    }
    */


/*
    public MyOrder createOrder(Long customerId, List<Long> productIds) {
        String productServiceUrl = "http://localhost:8083/products/";
        // Fetch customer from CustomerService
        System.out.println(customerId);
        System.out.println(productIds);

        String customerServiceUrl = "http://localhost:8080/customers/" + customerId;
        ResponseEntity<Customer> customerResponse = restTemplate.getForEntity(customerServiceUrl, Customer.class);

        if (customerResponse.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Customer not found in CustomerService");
        }
        else {
            System.out.println("Customer with this Id found");
        }
        Customer customer = customerResponse.getBody();

        // Fetch products from ProductService by productIds
        List<Product> products = new ArrayList<>();
        for (Long productId : productIds) {
            ResponseEntity<Product> productResponse = restTemplate.getForEntity(productServiceUrl + productId, Product.class);
            if (productResponse.getStatusCode() == HttpStatus.OK) {
                System.out.println("Product  this Id found in product service");
                System.out.println(productResponse.getBody());
                Product productFromService = productResponse.getBody();



                Optional<Product> productInDB = productRepository.findById(productId);
                if (productInDB.isPresent()) {
                    products.add(productInDB.get());
                } else {
                    // If not present in DB, save the fetched product (you can also just merge it)
                    products.add(productRepository.save(productFromService));
                }
            } else {
                throw new RuntimeException("Product not found in ProductService with id: " + productId);
            }

//
                /*
                products.add(productResponse.getBody());
            } else {
                throw new RuntimeException("Product not found in ProductService with id: " + productId);
            }


        }

        // Create and save the order
        MyOrder order = new MyOrder();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setOrderDate(LocalDate.now());


        return salesOrderRepository.save(order);
    }

*/
    /*
    public MyOrder getOrder(String id) {
        Long longId =   Long.valueOf(id);  // this line to convert string id to Long id


        return salesOrderRepository.findById((longId)).orElseThrow();
    }
/*
    public List<MyOrder> getAllOrders() {
        return salesOrderRepository.findAll();
    }
    */

}

