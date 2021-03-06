package myspringboot.reactive.mongo.router;

import myspringboot.reactive.mongo.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouterFunction
{
    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler productHandler)
    {
        return route(GET("/router/products"), productHandler::getProducts)
                .andRoute(GET("/router/products/{id}"), productHandler::getProduct)
                .andRoute(GET("/router/product-range"), productHandler::getProductInRange)
                .andRoute(POST("/router/products"), productHandler::saveProduct)
                .andRoute(PATCH("/router/products/{id}"), productHandler::updateProduct)
                .andRoute(DELETE("/router/products/{id}"), productHandler::deleteProduct);
    }
}
