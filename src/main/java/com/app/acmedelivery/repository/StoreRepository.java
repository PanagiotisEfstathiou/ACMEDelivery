package com.app.acmedelivery.repository;

import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.domainModel.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {


   Store findByStoreName(String StringName) ;




  @Query(
    value = "select distinct(rating.store) ,avg(rating.value)\n" +
      "from rating\n" +
      "group by (rating.store)\n" +
      "order by avg(rating.value) DESC",
        nativeQuery = true)
    List<Store>mostFamousStores();
  @Query(
    value ="select stores.name, avg(rating.value)\n"+
    "from rating\n"+
    "inner join stores\n"+
    "on stores.storeid = rating.store\n"+
    "where stores.category LIKE 'AAAA'\n"+
    "group by stores.name\n",
     nativeQuery = true)

    List<Store>mostFamousStoresPerCategory();




}


