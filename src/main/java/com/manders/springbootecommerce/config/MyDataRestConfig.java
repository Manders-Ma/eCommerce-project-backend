package com.manders.springbootecommerce.config;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import com.manders.springbootecommerce.entity.Country;
import com.manders.springbootecommerce.entity.Product;
import com.manders.springbootecommerce.entity.ProductCategory;
import com.manders.springbootecommerce.entity.State;


@Configuration("http://localhost:4200")
public class MyDataRestConfig implements RepositoryRestConfigurer {

  @Autowired
  private EntityManager entityManager;

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
      CorsRegistry cors) {
    HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    // disable HTTP method for Product : PUT, POST, DELETE
    disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

    // disable HTTP method for Product Category: PUT, POST, DELETE
    disableHttpMethods(Product.class, config, theUnsupportedActions);
    disableHttpMethods(Country.class, config, theUnsupportedActions);
    disableHttpMethods(State.class, config, theUnsupportedActions);

    exposeIds(config);
  }

  private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
      HttpMethod[] theUnsupportedActions) {
    config.getExposureConfiguration().forDomainType(ProductCategory.class)
        .withItemExposure((metadata, httpMethods) -> (httpMethods.disable(theUnsupportedActions)))
        .withCollectionExposure(
            (metadata, httpMethods) -> (httpMethods.disable(theUnsupportedActions)));
  }

  private void exposeIds(RepositoryRestConfiguration config) {
    config.exposeIdsFor(ProductCategory.class, Product.class, Country.class, State.class);

  }

}
