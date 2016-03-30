package cn.cnnic.repo;

import org.springframework.data.repository.CrudRepository;

import cn.cnnic.entity.Address;

public interface AddressRepo extends CrudRepository<Address, Long> {
}
