package com.app.acmedelivery.repository;

import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.domainModel.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {


	@Query("select o from Store o where o.storeName = :storeName")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Optional<Store> findByStoreName(String storeName);

	@Query("select o from Store o where o.storeCategory = :storeCategory")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Optional<Store> findByStoreCategory(StoreCategory storeCategory);

	@Query("select o from Store o join fetch o.catalog where o.id = :id")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Optional<Store> getLazy(Long id);








}



